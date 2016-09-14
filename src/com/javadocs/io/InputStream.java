package com.javadocs.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputStream {

	public void dataInputStream(){
		try {
			System.out.println("Enter a value ");
			DataInputStream stream = new DataInputStream(System.in);
			int value = stream.readInt(); 
			
			FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/Javadocs", "fileOutStream.txt"));
			DataOutputStream outputStream = new DataOutputStream(fileOutputStream);
			outputStream.writeInt(value);
			
			outputStream.close();
			fileOutputStream.close();
			stream.close();
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		InputStream is = new InputStream();
		is.dataInputStream();
			
	
	}	

}
