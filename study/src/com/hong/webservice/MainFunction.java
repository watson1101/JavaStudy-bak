package com.hong.webservice;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class MainFunction {
	public String responseString(String sStr) {
		System.out.println("function run , result is sending back.");
		return sStr + " has been received.";
	}
	
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/WebServiceDemo/MainFunction", new MainFunction());
		System.out.println("publish has been done.");
	}
}
