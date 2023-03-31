package com.ssafy.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3040_B2_백설공주와일곱난쟁이_임하은 {
	
	static int[] num = new int[9];
	static int[] seven = new int[7];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<9; i++) {
			num[i]=sc.nextInt();
		}
		combi(0,0);
		
	}
	
	static void combi(int cur, int cnt) { //크기가 7인 모든 조합
		if(cnt==7) {
			int sum=0;
			if(Arrays.stream(seven).sum()==100) { //구한 조합의 합이 100이면
				for(int i=0; i<7; i++) {
					System.out.println(seven[i]);
				}	
			}
			
			return;
		}
		if(cur>=9) {
			return;
		}
		
		seven[cnt]=num[cur];
		combi(cur+1,cnt+1);
		
		combi(cur+1, cnt);
		
	}

}
