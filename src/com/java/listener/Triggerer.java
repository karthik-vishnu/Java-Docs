package com.java.listener;

public class Triggerer {

	public static void main(String args[]) {
		Initiater initiater = Initiater.getInstance();
		initiater.addOnUpdateListener(new OnUpdateListener() {
			@Override
			public void onUpdate(Object name) {
				System.out.println("Hey "+name);
			}
		});
		
		CustomHashMap<String, String> hash = new CustomHashMap<>();
		hash.put("Hello", "Mike");
		hash.put("Vin", "diesel");
	}
}
