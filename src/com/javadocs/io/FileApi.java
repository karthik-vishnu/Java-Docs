package com.javadocs.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.net.URI;

public class FileApi {

	public File createNewFile()throws Exception{
		
		File file = new File("E:/Javadocs/","renamed.txt");
	//	file.createNewFile();
		
		/*File file1 = new File("my1.docx");
		file1.createNewFile();*/
	
		/*File file2 = new File("E:/Javadocs/");
		File file3 = new File(file2, "TextFile.txt");
		file3.createNewFile();*/
		
		URI uri = new URI("file:///E:/Javadocs/docs.txt");
		File file4 = new File(uri);
		if(!file4.exists()){
			file4.createNewFile();
		}	
		
		file4.renameTo(file);
		
		return file;
	}
	
	public File writer(File file){
		try {
			FileWriter writer = new FileWriter(file);
			System.out.println(file.getName());
			writer.write("File read and write operation ");
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return file;
	}
	
	public void readwrite(File writtenFile) throws Exception{
		FileReader reader = new FileReader(writtenFile);
		FileWriter writer = new FileWriter(new File("E:/Javadocs/","new.txt"));
		int asciiValue = reader.read();
		
		while(asciiValue != -1){
			System.out.print((char)asciiValue);
			writer.write(asciiValue);
			asciiValue = reader.read();
		}
		reader.close();
		writer.close();
	}
	
	public void bufferedReaderWriter(File writtenFile)throws Exception{
		BufferedReader reader = new BufferedReader(new FileReader(writtenFile));
		File newFile = new File("E:/Javadocs/","bufferedReaderWriter.txt");
		newFile.createNewFile();
		BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
		int len = reader.readLine().length();
		System.out.println(len);
		
		writer.write(reader.readLine(), 0, len);
		writer.close();
			
	}
	
	public void lineNumberReader(File writtenFile)throws Exception{
		LineNumberReader reader = new LineNumberReader(new FileReader(writtenFile));
		reader.getLineNumber();
	}
	
	public static void main(String args[]){
		FileApi api = new FileApi();
		try {
			File file = api.createNewFile();
			File writtenFile = api.writer(file);
			api.readwrite(writtenFile);
			api.bufferedReaderWriter(writtenFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
