package com.ssafy;

import java.util.Arrays;

public class day0405 {
	
//	static int[] list = {1,2,3,4,5};
	static int[] parent = new int[5];
	public static void main(String[] args) {
		
//		do {
//			System.out.println(Arrays.toString(list));
//		} while (np(list));
		
		make();
		union(0,1);
		union(1,3);
		System.out.println(Arrays.toString(parent));

	}

	private static void make() {
		for(int i=0; i<5; i++) {
			parent[i]=i;
		}
	}

	private static void union(int i, int j) {
		parent[j]=find(i);
//		return; 
		
	}

	private static int find(int i) {
		if(parent[i]==i) return i;
		
		return parent[i]=find(parent[i]);
	}


//	private static boolean np(int[] list) {
//		int n=list.length;
//		
//		int i=n-1;
//		while(i>0&&list[i-1]>=list[i]) --i;
//		if(i==0) return false;
//		
//		int j=n-1;
//		while(list[i-1]>list[j]) --j;
//		
//		swap(list,i-1,j);
//		
//		int k=n-1;
//		while(i<k) {
//			swap(list,i++,k--);
//		}
//		
//		return true;
//	}
//	private static void swap(int[] list, int i, int j) {
//		int temp = list[i];
//		list[i]=list[j];
//		list[j]=temp;
//		
//	}

}
