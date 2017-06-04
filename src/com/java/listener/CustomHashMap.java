package com.java.listener;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;

public class CustomHashMap<K, V> extends HashMap<K, V>{

	@Override
	public V put(K key, V value) {
		Initiater initiater = Initiater.getInstance();
		initiater.clicked((Object)value);
		return super.put(key, value);
	}
}
