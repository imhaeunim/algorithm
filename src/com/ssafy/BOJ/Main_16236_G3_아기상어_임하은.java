package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_G3_아기상어_임하은 {
	
	static int[][] map;
	static int N;
	static int x,y;
	static int size = 2;
	static int eat, time;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==9) {
					x=i;
					y=j;
				}
			}
		}
		while(true) {
			if(!bfs()) {
				System.out.println(time);
				return;
			}
		}
		

	}
	
	private static boolean bfs() {
		visited = new boolean[N][N];
		int[] dx = {-1,0,0,1};
		int[] dy = {0,-1,1,0};
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		queue.offer(y);
		queue.offer(count);
		map[x][y]=0;
		
		while(!queue.isEmpty()) {
			x = queue.poll();
			y = queue.poll();
			count = queue.poll();
			for(int i=0; i<4; i++) {
				int cx = x+dx[i];
				int cy = y+dy[i];
				if(cx<0 || cx>=N || cy<0 || cy>=N) continue;
				if(visited[cx][cy]) continue;
				if(map[cx][cy]==0) {
					queue.offer(cx);
					queue.offer(cy);
					queue.offer(count+1);
					visited[cx][cy]=true;
					continue;
				}else if(map[cx][cy]==size){
					queue.offer(cx);
					queue.offer(cy);
					queue.offer(count+1);
					continue;
				}else if(map[cx][cy]<size) {
					time+=(count+1);
					map[cx][cy]=0;
					x=cx;
					y=cy;
					eat++;
					if(eat==size) {
						eat=0;
						size++;
					}
					return true;
				}			
			}
		}
		return false;
		
	}

}
