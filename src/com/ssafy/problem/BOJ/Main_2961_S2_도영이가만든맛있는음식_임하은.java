package com.ssafy.problem.BOJ;

import java.util.Scanner;

public class Main_2961_S2_도영이가만든맛있는음식_임하은 {

	static int n;
	static int[][] FList;
	static boolean[] store;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		FList = new int[n][2];
		store = new boolean[n];
		for(int i=0; i<n; i++) {
			FList[i][0]=sc.nextInt();
			FList[i][1]=sc.nextInt();
		}
		
		food(0);
		System.out.println(min);
		
		
	}
static void food(int idx) {
		if(idx==n) {
			boolean no=true; 
			int sum1=1;
			int sum2=0;
			for(int i=0; i<n;i++) {
				if(store[i]==true) {
					no=false;	//공집합이 아니다
					sum1*=FList[i][0];
					sum2+=FList[i][1];
				}
			}
			if(no==true) {	//공집합이면 min 안 바꾸기
				return;
			}
			if(Math.abs(sum1-sum2)<min) {	//지금까지 나온 차보다 작으면 바꿔주기
				min=Math.abs(sum1-sum2);	//abs 함수 사용해서 절댓값으로 차 구함
			}
			return;
		}
		store[idx] = true;	//재료를 사용할 경우
		food(idx+1);
		store[idx]=false;	//재료를 사용하지 않을 경우
		food(idx+1);

	}

}
