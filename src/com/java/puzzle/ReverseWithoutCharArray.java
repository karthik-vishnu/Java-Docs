package com.java.puzzle;

public class ReverseWithoutCharArray {

	
	public static void main(String[] args) {
		int a = 12345678;
		int temp = a;
		int[] newArray = new int[String.valueOf(a).length()];
		int i = String.valueOf(temp).length()-1;
		
		while(a > 0){
			if(i == String.valueOf(temp).length()-1){
				newArray[i-2] = a%10;
				a= a/10;
				--i;
			} else if (i ==  String.valueOf(temp).length()-3){
				newArray[i+2] = a%10;
				a = a/10;
				--i;
			} else {
				newArray[i] = a%10;
				a = a/10;
				--i;
			}
			
		}

		for (int j = 0; j < newArray.length; j++) {
			System.out.print(newArray[j]);
		}
	
	}

}
