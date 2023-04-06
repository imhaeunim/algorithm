package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class day0406 {

	static int[] parents;
	static int N;
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
		N=5;
		parents = new int[N];
		make();
		union(0,1);
		union(1,3);

		System.out.println(Arrays.toString(parents));
		
	}
	
	private static void make() {
		for(int i=0; i<N; i++) {
			parents[i]=i;
		}
	}
	
	private static int find(int n) {
		if(parents[n]==n) return n;
		
		return parents[n]=find(parents[n]);
	}
	
	private static void union(int a, int b) {
		
		parents[b]=find(a);
	}
	
}
