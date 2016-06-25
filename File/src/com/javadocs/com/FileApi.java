package com.javadocs.com;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Time;
import java.util.Date;

public class FileApi {

	public File createNewFile()throws Exception{
		
		File file = new File("E:/Javadocs/","renamed.txt");
	//	file.createNewFile();
		
		/*File file1 = new File("E:/Javadocs/","my1.docx");
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
	
	public void writer(File file){
		try {
			FileWriter writer = new FileWriter(file);
			System.out.println(file.getName());
			writer.write("File read and write operation ");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]){
		FileApi api = new FileApi();
		try {
			File file = api.createNewFile();
			api.writer(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
