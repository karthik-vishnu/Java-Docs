package com.java.listener;

import java.util.ArrayList;
import java.util.List;

public class Initiater {
	private List<OnUpdateListener> listener = new ArrayList<>(); 
	private static Initiater initiater = new Initiater();
	
	private Initiater() {
		
	}
	
	public static Initiater getInstance() {
		return initiater;
	}
	
	public void addOnUpdateListener(OnUpdateListener click) {
		listener.add(click);
	}
	
	public void clicked(Object name) {
		for(OnUpdateListener click: listener) {
			click.onUpdate(name);
		}
	}
}
