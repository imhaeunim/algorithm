package com.ssafy;

import java.util.Arrays;

public class day0407 {

	static int[] list = {0,1,2,3,4};
	static int N=5;
	public static void main(String[] args) {
		
		do {
		System.out.println(Arrays.toString(list));
	} while (np());

	}
	static boolean np() {
		int i = N-1;
		
		while(i>0&& list[i-1]>=list[i]) i--;
		if(i==0) return false;
		
		int j = N-1;
		
		while(list[i-1]>=list[j]) j--;
		
		swap(i-1,j);
		
		int k=N-1;
		while(i<k) {
			swap(i++, k--);
		}
		return true;
	}
	
	static void swap(int a, int b) {
		int temp = list[a];
		list[a]=list[b];
		list[b]=temp;
	}

}
