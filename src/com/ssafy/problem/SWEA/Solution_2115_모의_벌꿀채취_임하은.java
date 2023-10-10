package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2115_모의_벌꿀채취_임하은 {
	static int N, M, C;
	static int max;
	static int[][] map;
	static boolean[][] slected;
	static int[] box1, box2;
	static boolean[] use;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			use = new boolean[M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int result =0;
			slected = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<=N-M; j++) {
					box1=new int[M];
					for(int k = 0; k<M; k++) { //벌통 첫번째
						box1[k]=map[i][j+k];
						slected[i][j+k]=true;
					}			
					for(int ii=i; ii<N; ii++) {
						for(int jj=0; jj<=N-M; jj++) {
							box2 = new int[M];
							if(slected[ii][jj]) continue;
							for(int k =0; k<M; k++) { //벌통 두번째
								box2[k]=map[ii][jj+k];
							}
							int sub_result = 0;
							max=0;
							subSet(0, box1);
							sub_result=max;
							max=0;
							subSet(0, box2);
							sub_result+=max;
							result = Math.max(result, sub_result);
							
						}
					}
					
				}
			}
			
		sb.append("#").append(t).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}

	private static void subSet(int cur, int[] box) {
		if(cur==M) {
			int sum=0;
			int count=0;
			for(int i=0; i<M; i++) {
				if(use[i]) {
					count+=box[i];
					if(count<=C) {
						sum += Math.pow(box[i],2);
					}else return;
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		use[cur] = true;
		subSet(cur+1, box);
		use[cur] = false;
		subSet(cur+1, box);
		
	}
	

}
