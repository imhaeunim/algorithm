package com.ssafy;

import java.util.Arrays;

public class day0228np {
	
	static int[] arr = {1,2,3,4};
	static int R;
	public static void main(String[] args) {
		
		do {
			System.out.println(Arrays.toString(arr));
		}while(np(arr));

	}
	
	private static boolean np(int[] arr2) {
		int n = arr.length-1;
		
		int i=n;
		while(i>0&&arr[i-1]>=arr[i]) i--;
		
		if(i==0) return false;
		
		int j=n;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(arr, i-1, j);
		
		int k =n;
		while(i<k) {
			swap(arr, i++, k--);
		}
		
		return true;
	}

	private static void swap(int[] arr2, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
