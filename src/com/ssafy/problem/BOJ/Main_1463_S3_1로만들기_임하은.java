package com.ssafy.problem.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1463_S3_1로만들기_임하은 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] number = new int[n+1];
		Arrays.fill(number, 0);
		number[1]=0;
		if(n>=2) {
			number[2]=1;
			if(n>=3) {
				number[3]=1;
			}
		}
		
		for(int i=4; i<=n; i++) {
			int min=Integer.MAX_VALUE;
			if(i%2==0) {
				min = Math.min(min, number[i/2]);
			}
			if(i%3==0) {
				min = Math.min(min, number[i/3]);
			}
			min = Math.min(min, number[i-1]);
			number[i]=min+1;
		}
		System.out.println(number[n]);
	}

}
