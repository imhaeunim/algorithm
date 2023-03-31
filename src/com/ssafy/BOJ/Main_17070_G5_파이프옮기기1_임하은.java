package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17070_G5_파이프옮기기1_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] dp = new int[N][N][3]; //가로 세로 대각선
		
//		int[] dx= {-1,-1,0};
//		int[] dy= {-1,0,-1};
		
		dp[0][1][0]=1;
//		dp[0][1][1]=1;
//		dp[0][1][2]=1;

		for(int i=0; i<N; i++) {
			for(int j=1; j<N; j++) {
				
				if(map[i][j]==1) continue;
				
				//가로
				if(dp[i][j][0]>=0) {
					//가로로 갈 때
					int nx=i; 
					int ny=j+1;
					if(nx<N && ny<N && map[nx][ny]==0) {						
						dp[nx][ny][0]+=dp[i][j][0];
					}
					//대각선으로 갈 때
					nx = i+1;
					ny = j+1;
					if(nx<N && ny<N && map[nx][ny]==0 
							&& map[i+1][j]==0 && map[i][j+1]==0) {
						dp[nx][ny][2]+=dp[i][j][0];
					}
				}
				
				//세로
				if(dp[i][j][1]>=0) {
					//세로로 갈 때
					int nx=i+1; 
					int ny=j;
					if(nx<N && ny<N && map[nx][ny]==0) {						
						dp[nx][ny][1]+=dp[i][j][1];
					}
					//대각선으로 갈 때
					nx = i+1;
					ny = j+1;
					if(nx<N && ny<N && map[nx][ny]==0 
							&& map[i+1][j]==0 && map[i][j+1]==0) {
						dp[nx][ny][2]+=dp[i][j][1];
					}
				}
				
				//대각선
				if(dp[i][j][2]>=0) {
					//가로로 갈 때
					int nx=i; 
					int ny=j+1;
					if(nx<N && ny<N && map[nx][ny]==0) {						
						dp[nx][ny][0]+=dp[i][j][2];
					}
					//세로로 갈 때
					nx=i+1; 
					ny=j;
					if(nx<N && ny<N && map[nx][ny]==0) {						
						dp[nx][ny][1]+=dp[i][j][2];
					}
					//대각선으로 갈 때
					nx = i+1;
					ny = j+1;
					if(nx<N && ny<N && map[nx][ny]==0 
							&& map[i+1][j]==0 && map[i][j+1]==0) {
						dp[nx][ny][2]+=dp[i][j][2];
					}
				}
				
				
			}
		}
		int result=0;
		for(int i=0; i<3; i++) {
			result+=dp[N-1][N-1][i];
		}
		System.out.println(result);
		
	}

}
