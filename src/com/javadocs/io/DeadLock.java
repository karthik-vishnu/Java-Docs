package com.javadocs.io;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DeadLock {
	 String resource1 = "String method";
	 String resource2 = "Integer method";
	
	public void lock(){
		Thread t1 = new Thread(){
			public void run() {
				synchronized (resource1) {
					System.out.println(resource1 +"1");
				
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (resource2) {
					System.out.println(resource2 +"1");
				}
				}
			}
		};
		
		
		Thread t2 = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println(resource2 +"2");
				
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				synchronized (resource1) {
					System.out.println(resource1 +"2");
				}
			}
			}
			};
		
			t1.start();
			t2.start();
	}
	
	
	public static void main(String args[]){
	/*	DeadLock deadLock = new DeadLock();
		deadLock.lock();*/	
		
	}
}
	


