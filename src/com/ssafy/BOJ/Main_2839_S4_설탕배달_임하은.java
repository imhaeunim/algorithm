package com.ssafy.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2839_S4_설탕배달_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] num = new int[n+1];
		Arrays.fill(num, 10000);
		num[3]=1;
		if(n>=5) {			
			num[5]=1;
		}
		
		for(int i=6; i<=n; i++) {
			int min=10000;

			min = Math.min(min, num[i-3]);


			min = Math.min(min, num[i-5]);
				
			num[i]=min+1;
		}
		if(num[n]>=10000) {
			num[n]=-1;
		}
		System.out.println(num[n]);

	}

}
