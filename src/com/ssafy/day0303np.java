package com.ssafy;

import java.util.Arrays;

public class day0303np {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		Arrays.sort(arr);
		do {
			System.out.println(Arrays.toString(arr));
		} while (np(arr));

	}

	private static boolean np(int[] arr) {
		int n = arr.length;
		int i=n-1;
		while(i>0 && arr[i-1]>=arr[i]) i--;
		if(i==0) return false;
		
		int j=n-1;
		while(arr[i-1]>=arr[j]) j--;
		
		swap(arr,i-1,j);
		
		int k = n-i;
		while(i<k) {
			swap(arr,i++,k--);
		}
		
		return true;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}

}
