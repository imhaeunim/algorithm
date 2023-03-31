package com.ssafy.live04;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationInputTest3 {
	static int N, R;
	static int[] input, number;
	static int totalCnt;
		
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		R= sc.nextInt();
		
//		input = new int[N];
		number =new int[R];
		
//		for(int i =0; i<N; i++) {
//			input[i] = sc.nextInt();
//		}
		input = new int[] {1,2,3,4,5,6};
		
		combi(0,0);
		System.out.printf("%dC%d 경우의 수 %d%n",N,R,totalCnt);
	}

	/*
	 * cnt : 입력된 원소 다음 배열
	 * r : 선택한 원소 개수
	 * */
//	private static void combi(int cur, int r) {
//		if(r==R) {	//조합의 모든 원소를 모두 선택한 경우
//			totalCnt++;
//			System.out.println(Arrays.toString(number));
//			return;
//		}
//		if(cur>=N) return;
//		
//		//선택
//		number[r] = input[cur];
//		combi(cur+1, r+1);		
//		
//		//비선택
//		combi(cur+1,r);
//		
//		
//	}
	private static void combi(int cur, int r) {
		if(r==R) {	//조합의 모든 원소를 모두 선택한 경우
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		
		for(int i=cur; i<N; i++) {
			number[r] = input[i];
			combi(i+1, r+1);		
		}
		
	}

}
