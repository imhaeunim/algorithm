package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_7576_G5_토마토_임하은 {
	static int M, N;
	static int[][] map;
	static Queue<Integer> queue = new LinkedList<Integer>();
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					queue.offer(i);
					queue.offer(j);
				}
			}
		}
		
		bfs();

		int max=-1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>max) {
					max=map[i][j];
				}
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(max-1);
		
	}

	private static void bfs() {
		while(!queue.isEmpty()) {
			int x= queue.poll();
			int y= queue.poll();
			for(int i=0; i<4;i++) {
				int cx=x+dx[i];
				int cy=y+dy[i];
				if(cx<0||cx>=N||cy<0||cy>=M) continue;
				if(map[cx][cy]==0) {
					queue.offer(cx);
					queue.offer(cy);
					map[cx][cy]=map[x][y]+1;
				}				
			}
		}
	}
	
}
