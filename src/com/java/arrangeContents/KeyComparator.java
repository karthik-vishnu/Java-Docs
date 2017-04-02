package com.java.arrangeContents;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class KeyComparator implements Comparator<Entry<String[], String>>{

	@Override
	public int compare(Entry<String[], String> o1, Entry<String[], String> o2) {
		// TODO Auto-generated method stub
		String[] key1 = o1.getKey();
		String[] key2 = o2.getKey();
		
		return key1[key1.length-1].compareTo(key2[key2.length-1]);
	}

	
}
