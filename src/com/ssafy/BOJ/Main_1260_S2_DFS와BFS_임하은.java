package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1260_S2_DFS와BFS_임하은 {
	static int N,M;
	static boolean[][] map;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		int V = sc.nextInt()-1;
		
		map = new boolean[N][N];
		
		for(int i=0; i<M; i++) {
			int s1 = sc.nextInt()-1;
			int s2 = sc.nextInt()-1;
			map[s1][s2] = true;
			map[s2][s1] = true;
		}
		
		visited= new boolean[N];
		dfs(V);
		System.out.println();
		visited= new boolean[N];
		bfs(V);
		
	}
	
	static void dfs(int cur) {
		visited[cur] = true;	//재귀를 통해 메소드에 들어올 때 방문 처리
		System.out.print(cur+1+" ");
		for(int i =0; i<N; i++) {
			if(map[cur][i]&&!visited[i]) {	//인접해있고, 방문하지 않았다면
				dfs(i);
			}
		}
		
	}
	
	static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(cur);
		visited[cur]=true;	//넣을 때 방문 처리
		while(!queue.isEmpty()) {
			cur =queue.poll();
			System.out.print(cur+1+" ");
			for(int i=0; i<N; i++) {
				if(map[cur][i]&&!visited[i]) {	//인접해있고, 방문하지 않았다면
					queue.offer(i);		//queue에 넣고
					visited[i]=true;	//방문처리
				}
			}
		}
	}

}
