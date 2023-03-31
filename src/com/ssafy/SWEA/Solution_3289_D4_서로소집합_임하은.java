package com.ssafy.SWEA;

import java.util.Scanner;

public class Solution_3289_D4_서로소집합_임하은 {
	
	static int N, M;
	static int[] parents;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T= sc.nextInt();
		for(int t=1; t<=T; t++) {
			System.out.printf("#%d ",t);
			N = sc.nextInt();
			M = sc.nextInt();
			
			parents = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				make(i);
			}
			
			for(int i=0; i<M; i++) {
				int type = sc.nextInt();
				if(type==0) {
					union(sc.nextInt(),sc.nextInt());
				}else {
					if(find(sc.nextInt())==find(sc.nextInt())) {
						System.out.print(1);
					}else {
						System.out.print(0);
					}
				}
			}
			System.out.println();
		}

	}
	private static void make(int v) {
		parents[v] = v;
	}
	
	private static int find(int v) {
		if(v==parents[v]) {
			return v;			
		}
		return parents[v] = find(parents[v]);
	}
	
	private static void union(int u, int v) {
		parents[find(u)] = find(v); 
	}

}
