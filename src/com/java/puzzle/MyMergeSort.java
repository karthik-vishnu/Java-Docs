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
	int count = 0;
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
		
		for(int i= low; i<=high; i++) {
			tempAry[i] = input[i];
		}
		int index = low;
		int mid = middle+1;
		while(low<= middle && mid <= high) {
			if(tempAry[low] <= tempAry[mid]) {
				input[index] = tempAry[low];
				++low;
				
			} else {
				input[index] = tempAry[mid];
				++mid;
			}
			++index;
		}
		while(low <= middle) {
			input[index] =tempAry[low];
			++low;
			++index;
		}
	}
	
	public static void main(String args[]) {
		int[] a = {1,2,10,1,5,40,65,78,63};
		
		MyMergeSort mergeSort = new MyMergeSort();
		mergeSort.globalize(a);
		mergeSort.split(0, a.length-1);
		
		for (int i = 0; i < mergeSort.tempAry.length; i++) {
			System.out.print(mergeSort.tempAry[i]+", ");
		}
	}
}