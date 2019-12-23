package com.example.app;

public class WebServiceCaller extends Thread
{
    public WebServiceSoap webServiceSoap;
    public String user,password;

    public void run(){
        try{
            webServiceSoap =new WebServiceSoap();
            boolean response= webServiceSoap.authenticateUser(user, password);
//            MainActivity.rslt = String.valueOf(response);
        }
        catch(Exception ex)
        {
//            MainActivity.rslt = soutex.toString();
            System.out.println(ex.toString());;
        }
    }
}