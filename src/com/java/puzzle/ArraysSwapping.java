package com.java.puzzle;

public class ArraysSwapping {

	public void swap(){
		int counter = 0;
		
		int[] a= {12, 65, 5 , 8 , 89};
		int[] b = new int[a.length];
		
		for (int i=0; i<a.length; i++){
			int temp = a[i];

				counter++;
		
			b[i] = a[a.length - counter];
			b[a.length - counter] = temp;

		}
		
		for(int i=0; i<b.length; i++){
			System.out.println(b[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*ArraysSwapping swapping = new ArraysSwapping();
		swapping.swap();*/
		
		Double doub = 2.321;
		long bits = Double.doubleToRawLongBits(doub);
		System.out.println(bits);
		Double bits1 = Double.longBitsToDouble(bits);
		System.out.println(Double.valueOf(doub));
		
		int a = 34;
		System.out.println((char)a);
		
	}

}
