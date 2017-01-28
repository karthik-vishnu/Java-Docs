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
	
	public int[] combine(int[] input) {
		double len = input.length;
		double length = len / 2;
		int roundOff = (int)Math.ceil(length);
		int[] result = new int[roundOff];
		int count = 0;
		
		for (int i = 0; i < input.length; i++) {
			String firstValue = String.valueOf(input[i]);
			++i;
			if(i < input.length) {
				String secondValue = String.valueOf(input[i]);
				String combinedVal = firstValue+secondValue;
				Integer finalVal = Integer.valueOf(combinedVal);
				result[count++] = finalVal;
			} else {
				result[count] = Integer.valueOf(firstValue);
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input = 123456;
		Numbers numbers = new Numbers();
		int length = numbers.getCount(input);
		
		int[] result = numbers.split(length,input);
		System.out.println("splitted numbers");
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+", ");
		}
		int[] combinedNumbers = numbers.combine(result);
		System.out.println("Combined numbers");
		for (int i = 0; i < combinedNumbers.length; i++) {
			System.out.print(combinedNumbers[i]+", ");
		}
	}

}
