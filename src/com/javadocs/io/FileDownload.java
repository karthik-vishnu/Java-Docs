package com.javadocs.io;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownload {

	public void imgDownload(){
		
		try {
			HttpURLConnection urlConnection = (HttpURLConnection)new URL("http://api.androidhive.info/progressdialog/hive.jpg").openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			System.out.println(urlConnection.getResponseCode());
			
			InputStream stream = urlConnection.getInputStream();
			DataInputStream dis = new DataInputStream(stream);
			
			FileOutputStream fos = new FileOutputStream(new File("E:/Javadocs", "random.jpg"));
			int a = dis.read();
			while(a!=-1){
				fos.write(a);
				a = dis.read();
			}
			
			dis.close();
			stream.close();
			fos.close();
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void videoDownload(){
		String urlString = "http://www.ericmoyer.com/episode1.mp4";
		String[] stringAry = urlString.split("/");
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();
			System.out.println(urlConnection.getResponseCode());
			
			InputStream stream = urlConnection.getInputStream();
			FileOutputStream outputStream = new FileOutputStream(new File("E:/Javadocs", stringAry[stringAry.length-1]));
			
			int value = stream.read();
			while(value!=-1){
				outputStream.write(value);
				value = stream.read();
			}
			
			stream.close();
			outputStream.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String args[]){
		FileDownload img = new FileDownload();
		img.imgDownload();
		img.videoDownload();
	}
}
