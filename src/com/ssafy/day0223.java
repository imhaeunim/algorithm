package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class day0223 {
	
	static int M;
	static int[] number = {0,1,2,3,4,5};
	static int[] temp;
	static boolean[] selected = new boolean[6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		temp = new int[M];
		

	}
	private static void subset(int cur) {
		if(cur==number.length) {
			System.out.println();
			return;
		}
		selected[cur]=true;
		subset(cur+1);
	}
	
	private static void combination(int start, int cnt) {
		if(cnt==M) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i = start; i<number.length; i++) {
			temp[cnt]=number[i];
			combination(i+1, cnt+1);
			combination(i+1, cnt);
		}
	}
	
	
	private static void permutation(int cnt) {
		if(cnt==M) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=0; i<number.length; i++) {
			if(selected[i]) continue;
			selected[i]=true;
			temp[cnt]=number[i];
			permutation(cnt+1);
			selected[i]=false;
		}
		
	}

}
