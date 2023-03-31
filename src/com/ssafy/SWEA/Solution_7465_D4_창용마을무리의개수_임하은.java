package com.ssafy.SWEA;

import java.util.Scanner;

public class Solution_7465_D4_창용마을무리의개수_임하은 {
	
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int N=sc.nextInt();
			int M=sc.nextInt();
			parents = new int[N+1];
			for(int i=1; i<=N; i++) {
				make(i);
			}
			
			for(int i=0; i<M; i++) {
				int u=sc.nextInt();
				int v=sc.nextInt();
				union(u,v);
			}
			
			for(int i=1; i<=N; i++) {
				find(i);
			}
			
			int count=0;
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(parents[j]==i) {
						count++;
						break;
					}
				}
			}
			System.out.printf("#%d %d\n",t,count);
		}

	}
	
	private static void make(int v) {
		parents[v]=v;
	}
	
	private static int find(int v) {
		if(v==parents[v]) return v;
		
		return parents[v] = find(parents[v]);
	}
	
	private static void union(int u, int v) {
		parents[find(u)]=find(v);
	}

}
