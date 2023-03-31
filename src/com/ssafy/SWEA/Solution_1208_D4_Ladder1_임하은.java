package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1208_D4_Ladder1_임하은 {
	static int[][] map;
	static int t;
	
	static void Ladder(int r,int c) {
		int up = -1;
		int[] LR= {-1,1};
		
		if(r==0) {
			System.out.println();
			System.out.printf("#%d %d",t,c);
			return;
		}

		if(c+LR[0]>=0 && c+LR[1]<100) {
			for(int i=0; i<2;i++) {
				if(map[r][c+LR[i]]==1) {
					map[r][c+LR[i]]=0;
					Ladder(r,c+LR[i]);
					return;
				}
			}
			if(r+up>=0) {
				if(map[r+up][c]==1) {
					map[r+up][c]=0;
					Ladder(r+up,c);
					return;
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test=1;test<=10;test++){
			t = sc.nextInt();
			map = new int[100][100];
			for(int i=0; i<100;i++) {
				for(int j=0; j<100;j++){
					map[i][j]=sc.nextInt();
				}
			}
	
			for(int i =0; i<100;i++) {
				if(map[99][i]==2) {
	//				System.out.println(i);
					Ladder(99,i);
					break;
				}
			}
		}
		//		for(int i=0;i<100;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}		
	}

}
