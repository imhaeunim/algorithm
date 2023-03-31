package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_11659_S3_구간합구하기4_임하은 {

	static int N;
	static int M;
	static int NList[];
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	N = sc.nextInt();
	M = sc.nextInt();
	NList=new int[N+1];
	int sum=0;
	for (int i =1; i<=N; i++ ) {
		NList[i]=sum+sc.nextInt();
		sum=NList[i];
	}

	for(int i =0; i<M; i++) {
		int s =sc.nextInt();
		int end = sc.nextInt();
		System.out.println(NM(s,end));
	}
	
	}
	
	static int NM(int start, int end) {

		int sub= NList[end]-NList[start-1];

		return sub;
	}

}
