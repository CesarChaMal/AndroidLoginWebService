package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Ok extends Activity {
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.okk);
        
        WebServiceSoap webServiceCaller = new WebServiceSoap();
        
        int a = 3;
        int b = 4;
        
        int result = webServiceCaller.AddTwoNums(a, b);
        TextView tv = new TextView(this);
        tv.setText("Addition of "+a+" and "+b+" is " +result);
        setContentView(tv);

    }}