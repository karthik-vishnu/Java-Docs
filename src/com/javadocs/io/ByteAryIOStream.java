package com.javadocs.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

//ByteArrayInputStream,  ByteArrayOutputStream and DataInputStream, DataOutputStream

public class ByteAryIOStream {

	public void byteAryIOStream(byte[] stringTobyte){
		byte[] buffer = new byte[stringTobyte.length];
		ByteArrayInputStream inputStream = new ByteArrayInputStream(stringTobyte);
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		
		int a = inputStream.read();
		while(a!=-1){
			outputStream.write(a);
			a = inputStream.read();
		}
		
		byte[] byteAry = outputStream.toByteArray();
		for(int i=0; i<byteAry.length; i++){
			System.out.print((char)byteAry[i]);
		}
		
		
	}
	public void dis(){
		InputStream in;
		try {
			in = new FileInputStream("E:/Oneeeeeeeeeeeeeeee.txt");
			DataInputStream data = new DataInputStream(in);
			Boolean line = data.readBoolean();
			while(line!=null){
				System.out.println(line);
				line = data.readBoolean();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {
	
		byte[] stringTobyte = "hello everyone".getBytes();
		ByteAryIOStream arrayInputStream = new ByteAryIOStream();
		arrayInputStream.byteAryIOStream(stringTobyte);
		arrayInputStream.dis();
		
	
		
	}

}
