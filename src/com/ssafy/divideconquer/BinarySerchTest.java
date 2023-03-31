package com.ssafy.divideconquer;

import java.util.Arrays;

public class BinarySerchTest {
	private static int[] values = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(values));
		System.out.println(binarySearch(65));
		System.out.println(binarySearch(3));
		System.out.println(binarySearch(45));
		System.out.println(binarySearch(60));
		System.out.println("==============================");
		System.out.println(binarySearch2(65,0,9));
		System.out.println(binarySearch2(3,0,9));
		System.out.println(binarySearch2(45,0,9));
		System.out.println(binarySearch2(60,0,9));
		System.out.println("==============================");
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 45));
		System.out.println(Arrays.binarySearch(values, 60));
	}
	private static int binarySearch(int key) {
		int start = 0, end = values.length-1, mid=0;
		
		while(start <=end) {
			mid = (start+end)>>1;
			if(values[mid]==key) return mid;
			else if(values[mid]<key) start = mid+1;
			else end = mid -1;
		}
		return -1;
	}
	
	private static int binarySearch2(int key, int start, int end) {
		if(start>end) {
			return -1;
		}
		int mid = (start+end)/2;
		if(key==values[mid]) {
			return mid;
		}else if(key<values[mid]) {
			return binarySearch2(key, start, mid-1);

		}else{
			return binarySearch2(key, mid+1, end);
		}
	}
}
