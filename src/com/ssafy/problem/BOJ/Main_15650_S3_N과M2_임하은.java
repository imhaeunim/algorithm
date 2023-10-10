package com.ssafy.problem.BOJ;

import java.util.Scanner;

public class Main_15650_S3_N과M2_임하은 {
	static int N;
	static int M;
	static int[] MList;

	static void NM(int idx, int num) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(MList[i] + " ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(MList));
			return;
		}
		for(int i = num; i<=N; i++) {
			MList[idx]=i;
			NM(idx+1,i+1);
		}
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		M= sc.nextInt();
		MList = new int[M];
		NM(0,1);	
	}
}
