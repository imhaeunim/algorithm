package com.ssafy.problem.JO;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1411_bank_두줄로타일깔기_임하은 {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		long[] memo = new long[n+1];
		Arrays.fill(memo, -1);
		
		memo[1]=1;
		memo[2]=3;
		
		for(int i=3; i<=n; i++) {
			if(memo[i]==-1) {
				memo[i]=(memo[i-2]*2+memo[i-1])%20100529;
			}
		}
		
		System.out.println(memo[n]);
	}
	

}
