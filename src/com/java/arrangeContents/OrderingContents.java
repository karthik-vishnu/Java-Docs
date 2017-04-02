package com.java.arrangeContents;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.InputMap;

public class OrderingContents {

	public List<String> contentsToArray(String path) {
		File givenFile = new File(path);
		List<String> contents = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		
		try {
			FileInputStream inputStream = new FileInputStream(givenFile);
			int read = inputStream.read();
			while(read != -1) {
				builder.append((char)read);
				if((char)read == '\n') {
					contents.add(builder.toString());
					builder.setLength(0);
				}
				read = inputStream.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return contents;
	}
	
	public List<Entry<String[], String>> sort(List<String> contents) {
		Map<String[], String> splittedContents = new HashMap<String[], String>();
		
		for (int i = 0; i < contents.size(); i++) {
			if(contents.get(i).contains("{") || contents.get(i).contains("}")) {
				contents.remove(i);
			}
		}
		
		for (int i = 0; i < contents.size(); i++) {
			if(contents.get(i).contains("=")) {
				String[] split = contents.get(i).split("=",2);
				String[] key = split[0].split(" ");
				splittedContents.put(key, split[1]);
			}
		}
		List<Entry<String[], String>> contentEntries = new ArrayList<Entry<String[], String>>(splittedContents.entrySet());
		Collections.sort(contentEntries, new KeyComparator());
		
		return contentEntries;
	}
	
	public boolean writeToFile(List<Entry<String[], String>> contentEntries, String path) {
		File file = new File(path);
		try {
			if(!file.exists())
				file.createNewFile();
			
				FileWriter fileWriter = new FileWriter(file);
				StringBuilder builder = new StringBuilder();
				
				for (int i = 0; i < contentEntries.size(); i++) {
					String[] key = contentEntries.get(i).getKey();
					for (int j = 0; j < key.length; j++) {
						builder.append(key[j]+" ");
					}
					
					builder.append("="+contentEntries.get(i).getValue());
					fileWriter.write(builder.toString());
					builder.setLength(0);
				}
				fileWriter.close();
			
		} catch (IOException e) {
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		String filePath = "E:/eclipse/Constants.txt";
		OrderingContents orderingContents = new OrderingContents();
		List<String> contents = orderingContents.contentsToArray(filePath);
		List<Entry<String[], String>> contentEntries = orderingContents.sort(contents);
		boolean success = orderingContents.writeToFile(contentEntries, filePath);
		System.out.println("success "+success);
	}
}
