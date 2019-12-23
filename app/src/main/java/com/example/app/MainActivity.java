package com.example.app;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

//    public static String rslt="";
    Button ok;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //allow strict mode
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Login button clicked
        ok = (Button)findViewById(R.id.btn_login);
        ok.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void callWebService() {
        try {
            EditText uname = (EditText)findViewById(R.id.txt_username);
            String name = uname.getText().toString();

            EditText pword = (EditText)findViewById(R.id.txt_password);
            String password = pword.getText().toString();

            WebServiceSoap webServiceCaller = new WebServiceSoap();
/*
            WebServiceCaller webServiceCaller = new WebServiceCaller();
            webServiceCaller.user = name;
            webServiceCaller.password = password;
            webServiceCaller.join();
            webServiceCaller.start();
            while(rslt=="START") {
                try {
                    Thread.sleep(10);
                } catch(Exception ex) {
                }
            }

            boolean result = Boolean.parseBoolean(rslt);
*/
            boolean result = webServiceCaller.authenticateUser(name, password);

            if(result)
            {
                Intent intent = new Intent (MainActivity.this, Ok.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Intent intent = new Intent (MainActivity.this, Error.class);
                startActivity(intent);
                finish();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        if(view == ok){
            callWebService();
        }
    }
}
