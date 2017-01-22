package com.java.puzzle;

import java.util.Arrays;

public class BinarySearch {
	int[] input;
	int point;
	int result = 0;
	
	public void globalize(int[] input, int point){
		this.input = input;
		this.point = point;
	}
	
	public int search(int start, int end) {
		int halfwayMark = start+(end-start)/2;
		
		if(point == input[halfwayMark]){
			result = halfwayMark;
			
		} else if (point > input[halfwayMark]){
			search(halfwayMark+1, end);
		} else {
			search(start, halfwayMark-1);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] input = {10, 2, 5, 45, 565, 14, 0, 65, 7};
		Arrays.sort(input);
		BinarySearch binarySearch = new BinarySearch();
		binarySearch.globalize(input, 65);
		int result = binarySearch.search(0, input.length-1);
		System.out.println(result);
	}
}
