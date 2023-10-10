package com.ssafy.problem.SWEA;

import java.util.Scanner;

public class Solution_929_D3_한빈이와SpotMart임하은 {
	static int N;
	static int M;
	static int[] snack;	//입력받은 배열
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test= sc.nextInt();
		for(int t=1; t<test; t++) {
			N=sc.nextInt();
			M=sc.nextInt();
			max=-1;
			snack= new int[N];
			for(int i=0; i<N; i++) {
				snack[i]=sc.nextInt();
			}
			
			combi(0,0,0);
		}
	}
	
	private static void combi(int start, int cnt, int sum) {
		if(cnt==2) {
			if(sum>max && sum<=M) {
				max=sum;
			}
			return;
		}
		for(int i=start; i<N;i++) {
			combi(i+1,cnt+1,sum+snack[i]);
		}
	}

}
