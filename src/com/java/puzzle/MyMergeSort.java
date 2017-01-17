package com.java.puzzle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyMergeSort {
	int[] input;
	int[] tempAry;
	
	public void globalize(int[] input) {
		this.input = input;
		tempAry = new int[input.length];
	}
	public void split(int low, int high) {
		if(low< high) {
			int middle = low + (high - low)/2;
			
			split(low, middle);
			split(middle+1, high);
			merge(low, middle, high);
		}
	}
	
	public void merge(int low, int middle, int high) {
		middle = middle+1;
		int index =low;
		while(low<= middle && middle <= high) {
			if(input[low] < input[middle]) {
				tempAry[index] = input[low];
				++index;
				++low;
				if(low > middle) {
					tempAry[high] = input[low];
				}
			} else {
				tempAry[index] = input[middle];
				++index;
				++middle;
				if(middle > high) {
					tempAry[high] = input[low];
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		int[] a = {2,10,1,5,40,65,78,63};
		
		MyMergeSort mergeSort = new MyMergeSort();
		mergeSort.globalize(a);
		mergeSort.split(0, a.length-1);
		
		for (int i = 0; i < mergeSort.tempAry.length; i++) {
			System.out.print(mergeSort.tempAry[i]+", ");
		}
	}
}