package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_G3_말이되고픈원숭이_임하은 {

	public static class Position {
		int x;
		int y;
		int count;
		public Position(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		StringTokenizer sc = new StringTokenizer(br.readLine()," ");
		int W = Integer.parseInt(sc.nextToken());
		int H = Integer.parseInt(sc.nextToken());
		int[][] map = new int[H][W];
		
		for(int i=0; i<H; i++) {
			sc = new StringTokenizer(br.readLine());
			for(int j=0; j<W; j++) {
				map[i][j]=Integer.parseInt(sc.nextToken());
			}
		}
		
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int[] ddx = {-1,-2,-2,-1,1,2,2,1};
		int[] ddy = {-2,-1,1,2,2,1,-1,-2};
		int[][][] visited = new int[H][W][K+1];
		Queue<Position> queue = new LinkedList<Position>();
		
		queue.offer(new Position(0, 0, 0));
		

		while(!queue.isEmpty()) {
			Position position=queue.poll();
			int r=position.x;
			int c=position.y;
			int k=position.count;
			
			for(int i=0; i<4; i++) {
				int cx = r+dx[i];
				int cy = c+dy[i];
				if(cx<0|| cy<0||cx>=H||cy>=W) continue;
				if(visited[cx][cy][k]!=0) continue;
				if(map[cx][cy]==1) continue;
				visited[cx][cy][k]=visited[r][c][k]+1;
				queue.offer(new Position(cx, cy, k));
			}
			
			if(k>=K) continue;
			for(int i=0; i<8; i++) {
				int cx = r+ddx[i];
				int cy = c+ddy[i];
				if(cx<0|| cy<0||cx>=H||cy>=W) continue;
				if(visited[cx][cy][k+1]!=0) continue;
				if(map[cx][cy]==1) continue;
				visited[cx][cy][k+1]=visited[r][c][k]+1;				
				queue.offer(new Position(cx, cy, k+1));
			}

		}
		
		int result=Integer.MAX_VALUE;
		for(int i=0; i<=K; i++) {
			if(visited[H-1][W-1][i]==0) continue;
			result=Math.min(result, visited[H-1][W-1][i]);
		}
		if(result==Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
		

	}

}
