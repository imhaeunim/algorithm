package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_D6_사람네트워크2_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE>>2;
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] map= new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i!=j && map[i][j]==0) {
						map[i][j]=INF;
					}
				}
			}
			
			for(int k=0; k<N; k++) {
				for(int i=0; i<N; i++) {
					for(int j=0; j<N; j++) {
						if(map[i][j]>map[i][k]+map[k][j]) {
							map[i][j]=map[i][k]+map[k][j];
						}
					}
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int i=0; i<N; i++) {
				int sum=0;
				for(int j=0; j<N; j++) {
					sum+=map[i][j];
				}
				min=Math.min(min, sum);
			}
			
			System.out.println("#"+t+" "+min);
			
		}

	}

}
