package com.ssafy.problem.BOJ;

import java.util.Scanner;

public class Main_2563_S5_색종이_임하은 {
	static boolean[][] map = new boolean[100][100];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N= sc.nextInt(); 
		
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();	//왼변에서 얼마나 떨어져 있는지
			int y = sc.nextInt();	//밑변에서 얼마나 떨어져 있는지
			
			for(int r=0; r<10; r++) {
				for(int c=0; c<10; c++) {	//행은 밑에서부터 돌거야 열은 왼쪽부터
					map[100-y-r][x+c]=true;
				}
			}
		}
		int cnt=0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j]) {	//만약 겹치면 +1
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

}
