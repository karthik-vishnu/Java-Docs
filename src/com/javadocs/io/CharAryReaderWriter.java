package com.javadocs.io;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharAryReaderWriter {
	
	//This method reads all the entries in the char array
	public void charAryReader(char[] toRead){
		CharArrayReader reader = new CharArrayReader(toRead);
		try {
			int value = reader.read();
			while(value!=-1){
				System.out.println("CharAryReader "+(char)value);
				value = reader.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//This method reads only the even entries in the char array.
	public void readEvenNumbers(char[] toRead){
		CharArrayReader reader = new CharArrayReader(toRead);
		try {
			while(reader.read()!=-1){
				System.out.println("readEvenNumbers "+(char)reader.read());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void readOddNumbers(char[] toRead){
		CharArrayReader reader = new CharArrayReader(toRead);
		try {
			int value  = reader.read();
			while(reader.read()!=-1){
				System.out.println("readOddNumbers "+(char)value);
				value = reader.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void charAryWriter(char[] toRead){
		CharArrayReader reader = new CharArrayReader(toRead);
		CharArrayWriter writer = new CharArrayWriter();
		try {
			int value = reader.read();
			while(value!=-1){
				writer.write((char)value);
				value = reader.read();
			}
			char[] toWrite =writer.toCharArray();
			
			for(char array:toWrite){
				System.out.println("charAryWriter "+array);
			}
			reader.close();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = {'a', 'd', 'r', 'S', '6', 'H'};
		CharAryReaderWriter reader = new CharAryReaderWriter();
		reader.charAryReader(charArray);
		reader.readEvenNumbers(charArray);
		reader.readOddNumbers(charArray);
		reader.charAryWriter(charArray);
	}

}
