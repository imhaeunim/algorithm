package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643_D4_키순서_DFS2_플로이드워샬 {
	
	static int N,M,adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			
			adj = new int[N+1][N+1]; //자신보다 키가 큰 관계를 표현
			adj = new int[N+1][N+1]; //자신보다 키가 작은 관계를 표현
			
			StringTokenizer st = null;
			int a,b;
			for(int m=0; m<M; m++) {
				st = new StringTokenizer(br.readLine()," ");
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				adj[a][b] = 1; 
			}
			
			for(int k=1; k<=N; k++) { //경유 (학생 k)
				for(int i=1; i<=N; i++) { //출발 (학생 i)
					if(i==k||adj[i][k]==0) continue; //i보다 k가 큰지 모르는 경우 skip
					for(int j=1; j<=N; j++) { //도착(학생 j)
						// i<k<j : 학생 i보다 학생 k가 키가 크고  학생 k보다 학생 j가 키가 크면
						//=> 학생 i보다 j의 키가 크다.
						if(adj[i][j]==1) continue; //이미 i보다 j가 큰 걸 알고 있음
						adj[i][j]=adj[k][j];
					}
				}
			}

			int ans=0;
			for(int i=1; i<=N; i++) {
//				int cnt=0;
				for(int j=1; j<=N; j++) {
					adj[i][0]+=adj[i][j];
					adj[0][j]+=adj[i][j];
//					if(adj[i][j]==1) cnt++;
//					if(adj[j][i]==1) cnt++;
				}
//				if(cnt==N-1) ans++;
			}
			
			for(int i=1; i<=N; i++) {
				if(adj[i][0]+adj[0][i]==N-1) ++ans;
			}
			System.out.println("#"+t+" "+ans);
		}
	}
	
}
