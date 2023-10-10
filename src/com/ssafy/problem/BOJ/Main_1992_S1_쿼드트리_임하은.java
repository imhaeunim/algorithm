package com.ssafy.problem.BOJ;

import java.util.Scanner;

public class Main_1992_S1_쿼드트리_임하은 {
	static int[][] map;
	static int N;
	static int[] temp = new int[4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			String temp = sc.nextLine();
			for(int j=0; j<N; j++) {
				map[i][j]=temp.charAt(j)-'0';
			}
		}
		
		
		divide(0,0,N);
		
	}
	static void divide(int x, int y, int dis) {
		int sum=0;
		for(int i=x; i<x+dis; i++) {
			for(int j=y; j<y+dis; j++) {
				sum+=map[i][j];
			}
		}
		
		if(sum==0) {
			System.out.print(0);
			return;
		}else if(sum==dis*dis) {
			System.out.print(1);
			return;
		}else {
			System.out.printf("(");
			int len = dis/2;
			//좌상
			divide(x,y,len);
	
			//우상
			divide(x,y+len,len);
	
			//좌하
			divide(x+len,y,len);
			
			//우하
			divide(x+len,y+len,len);
			System.out.printf(")");
			}
	}

}
