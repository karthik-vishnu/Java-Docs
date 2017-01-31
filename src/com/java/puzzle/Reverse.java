package com.sample;

public class Reverse {

	public static void main(String args[]){
		int a= 12345;
		char[] newValue = String.valueOf(a).toCharArray();
		System.out.println("Input " +a);
		for (int i = 0; i < newValue.length; i++) {
			int index = newValue.length-1;
			char temp = newValue[index];
			index = index-2;
			if(i == index){
				newValue[newValue.length-1] = newValue[i];
				newValue[i] = temp;
			}
		}
		
		String reversedString =  String.valueOf(newValue);
		int reversedInt = Integer.valueOf(reversedString);
		System.out.println(reversedString);
		
	}
}
