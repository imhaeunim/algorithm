package com.ssafy.problem.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_D3_Flatten_임하은 {
	static int[] yellow;
	static int t;
	
	static void dump(int d) {
		int max = 0;
		int min = 101;
		int min_idx=-1;
		int max_idx=-1;
		if(d==0) {
			for (int i=0; i<100;i++) {
				if(yellow[i]<min) {
					min=yellow[i];
				}
				if(yellow[i]>max) {
					max = yellow[i];
				}
			}
//			System.out.println(Arrays.toString(yellow));
			System.out.printf("#%d ",t);
			System.out.println(max-min);
			return;
		}
		for (int i =0; i<100;i++) {
			if(yellow[i]<min) {
				min=yellow[i];
				min_idx=i;
			}
			if(yellow[i]>max){
				max = yellow[i];
				max_idx=i;
			}
		}
		yellow[min_idx]++;
		yellow[max_idx]--;
//		System.out.println(Arrays.toString(yellow));
		dump(d-1);

		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (t = 1; t<=10;t++) {
			
			int N = sc.nextInt();
			yellow = new int[100];
			for(int i=0; i<100;i++) {
				yellow[i]=sc.nextInt();
			}
			dump(N);

		}

	}

}
