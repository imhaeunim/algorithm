package com.ssafy.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11660_S3_구간합구하기5_임하은 {


	public static void main(String[] args) {
	StringBuilder sb = new StringBuilder();	
	String[] out;
	
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int M = sc.nextInt();
	int[][] map = new int[N+1][N+1];
	
	for(int i=1; i<N+1;i++) {
		for(int j=1; j<N+1; j++) {
			map[i][j]= map[i][j-1]+map[i-1][j]-map[i-1][j-1]+sc.nextInt();
		}
	}
	
	for(int test=0; test<M; test++) {
		
		int x1=sc.nextInt();
		int y1=sc.nextInt();
		int x2=sc.nextInt();
		int y2=sc.nextInt();
		

		int sum=0;
		sum = map[x2][y2]-map[x2][y1-1]-map[x1-1][y2]+map[x1-1][y1-1];
//		System.out.println(sum);
		sb.append(sum);
		sb.append("\n");
		
	}
	System.out.println(sb.toString());
	}

}
