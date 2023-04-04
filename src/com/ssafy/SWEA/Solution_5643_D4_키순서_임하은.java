package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_5643_D4_키순서_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int[][] adj = new int[N][N];
			for(int i=0; i<M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken())-1;
				int big = Integer.parseInt(st.nextToken())-1;
				adj[small][big] = 1;
				adj[big][small] = -1;	
			}
			int count=0;
			for(int i=0; i<N; i++) {
				Queue<Integer> queue = new LinkedList<>();
				boolean[] visited = new boolean[N];
				visited[i]=true;
				for(int j=0; j<N; j++) {
					if(adj[i][j]==1) {
						queue.offer(j);
						visited[j]=true;
					}
				}
				while(!queue.isEmpty()) {
					int start = queue.poll();
					for(int j=0; j<N; j++) {
						if(visited[j]) continue;
						if(adj[start][j]==1) {
							queue.offer(j);
							visited[j]=true;
						}
					}
				}
				
				for(int j=0; j<N; j++) {
					if(adj[i][j]==-1) {
						queue.offer(j);
						visited[j]=true;
					}
				}
				while(!queue.isEmpty()) {
					int start = queue.poll();
					for(int j=0; j<N; j++) {
						if(visited[j]) continue;
						if(adj[start][j]==-1) {
							queue.offer(j);
							visited[j]=true;
						}
					}
				}
				for(int j=0; j<N; j++) {
					if(!visited[j]) {
						count--;
						break;
					}
				}
				count++;
				
			}
			System.out.println("#"+t+" "+count);

		}

	}

}
