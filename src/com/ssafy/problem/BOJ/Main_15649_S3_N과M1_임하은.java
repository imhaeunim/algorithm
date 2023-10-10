package com.ssafy.problem.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_15649_S3_N과M1_임하은 {
	static int N;
	static int M;
	static int[] store;
	static boolean[] check;
	
	static void per(int c) { 		
	if(c==M) {
		for(int i=0;i<M;i++) {
			System.out.print(store[i]+" ");
		}
		System.out.println();
//		return;
	}else {
		for (int i =1; i<=N;i++) {
			if (check[i]==true) {
				continue;
			}
			store[c]=i;	
			check[i]=true;
			per(c+1);
			check[i]=false;
		}
	}
	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		store =	new int[M];
		check = new boolean[N+1];
		per(0);
		
	}

}
