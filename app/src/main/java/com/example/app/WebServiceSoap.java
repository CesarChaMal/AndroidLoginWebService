package com.example.app;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;

public class WebServiceSoap
{
	private final String NAMESPACE = "http://tempuri.org/";
	private final String URL = "http://192.168.0.24:45455/Service1.asmx?WSDL";

    public boolean authenticateUser(String userName,String passWord)
    {
    	boolean result = false;
    	
    	final String SOAP_ACTION = "http://tempuri.org/AuthenticateUser";
    	final String METHOD_NAME = "AuthenticateUser";
    	
    	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 		

		PropertyInfo propInfo1 =new PropertyInfo();
		propInfo1.setName("_userName");
		propInfo1.setValue(userName);
		propInfo1.setType(String.class);
        request.addProperty(propInfo1);
        
		PropertyInfo propInfo2 = new PropertyInfo();
		propInfo2.setName("_passWord");
		propInfo2.setValue(passWord);
		propInfo2.setType(String.class);
        request.addProperty(propInfo2);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true; // put this only if the web service is .NET one
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
			Log.i("myApp", response.toString());
			if(response.toString().equalsIgnoreCase("true")){
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }

    public String HelloWorld()
    {
    	String result = null;
    	
    	final String SOAP_ACTION = "http://tempuri.org/HelloWorld";
    	final String METHOD_NAME = "HelloWorld";
    	
    	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 		
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
			Log.i("myApp", response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
    }
    
    public int AddTwoNums(int a, int b)
    {
    	int result = 0;
    	
    	final String SOAP_ACTION = "http://tempuri.org/AddTwoNums";
    	final String METHOD_NAME = "AddTwoNums";
    	
    	SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 		

		PropertyInfo propinfo =new PropertyInfo();
		propinfo.setName("a");
		propinfo.setValue(a);
		propinfo.setType(int.class);
        request.addProperty(propinfo);
        
		PropertyInfo propinfo1 = new PropertyInfo();
		propinfo1.setName("b");
		propinfo1.setValue(b);
		propinfo1.setType(int.class);
        request.addProperty(propinfo1);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
			Log.i("myApp", response.toString());
			result = Integer.parseInt(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
    }

}