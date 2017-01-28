package com.java;

public class Numbers {

	public int getCount(int number) {
		int length = 0;
		while(number > 0) {
			int splitNum = number % 10;
			number =number / 10;
			++length;
		}
		return length;
	}
	
	public int[] split(int length, int number) {
		int[] result = new int[length];
		int count = result.length-1;
		while(number > 0) {
			int splitNum = number % 10;
			number =number / 10;
			result[count--] = splitNum;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 12345;
		Numbers numbers = new Numbers();
		int length = numbers.getCount(input);
		
		int[] result = numbers.split(length,input);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
