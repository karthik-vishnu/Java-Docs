package com.java;

import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class PrettyPrint {
	String json;
	String space = "";
	private String userInput() {
		System.out.println("Enter your JSON");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		scanner.close();
		return input;
	}
	
	private void json(String json) {
		this.json = json;
		for(int i=0; i<json.length(); i++) {
			Character character = json.charAt(i);
			if(character.equals('{') || character.equals('[')) {
				System.out.println(character);
				this.json = this.json.substring(i+1, json.length());
				pretifiedPrint(this.json);
				break;
			}
		}
	}
	
	private void pretifiedPrint(String json) {
		space = space + "\t";
		System.out.print(space);
		for (int i = 0; i < json.length(); i++) {
			Character character = json.charAt(i);
			if(character.equals(',')) {
				int index = i -1;
				Character prevChar = json.charAt(index);
				System.out.println(character);
				System.out.print(space);
			
			} else if (character.equals('{') || character.equals('[')) {
				space = space + "\t";
				System.out.println(character);
				System.out.print(space);
			} else if (character.equals('}') || character.equals(']')) {
				System.out.println();
				space = space.substring(0, space.length()-1);
				System.out.print(space + character);
			} else 
				System.out.print(character);
		}
	}
	
	public static void main(String args[]) {
		PrettyPrint prettyPrint = new PrettyPrint();
		String input = prettyPrint.userInput();
		prettyPrint.json(input);
	}
}
