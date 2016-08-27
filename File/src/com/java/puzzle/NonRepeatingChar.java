package com.java.puzzle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class NonRepeatingChar {

	public void nonRepeatingChar(){
		
		String str = "Aliveisawesome";
		str = str.toLowerCase();
		HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
		for (int i=0; i<str.length(); i++){
			Character c = str.charAt(i);
			 
			if(hash.containsKey(c)){
				hash.put(c, hash.get(c)+1);
				
			}
			else{
				hash.put(c, 1);
			}
		}
		
		for(int i=0; i<str.length();i++){
				System.out.println(str.charAt(i) +" " +hash.get(str.charAt(i)));
				
			}
			
		}
		
	public void leftTrim(){
		String s = "   Hello world";
		int i = 0;
		for (i=0; i<s.length(); i++){
			char c = s.charAt(i);
		
			if(c!= ' '){
				break;
				
			//	builder.append(c);
			}
		}
		for(int j=i; j<s.length(); j++){
			System.out.print(s.charAt(j));
		}
	}
	
	public void middleTrim(){
		String s = "Alive is awesome";
		StringBuilder builder = new StringBuilder();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if (c!= ' '){
				builder.append(c);
			}
		}
		System.out.println(builder.toString());
	}
	
	public void writeTextAtEndOfLine(){
		try {
			File file = new File("E:/Karthi/C++ and JAVA/Myecplise IDE/Practise", "my.txt");
			/*file.createNewFile();
			
			FileWriter writer = new FileWriter(file);
			writer.write("Hai \nHello \neveryone");
			writer.close();*/
			String output;
			FileReader reader = new FileReader(file);
			FileWriter writer = new FileWriter(new File("E:/Karthi/C++ and JAVA/Myecplise IDE/Practise", "new.txt"));
		
			BufferedReader buff = new BufferedReader(reader);
			while((output= buff.readLine())!= null){
				writer.write(output+" sag\n");
			}
			writer.close();
			reader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]){
		/*NonRepeatingChar no = new NonRepeatingChar();
		no.leftTrim();
		no.nonRepeatingChar();
		
		no.writeTextAtEndOfLine();*/
		/*Permutations perm = new Permutations("abc");
		perm.permute();*/
		
	}
	
	
}
