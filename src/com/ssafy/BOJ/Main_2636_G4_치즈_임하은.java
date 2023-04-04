package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_G4_치즈_임하은 {
	
	static class Cheese{
		int x;
		int y;
		public Cheese(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int count=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {					
					count++;
				}
			}
		}
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		int time=0;
		int num=0;

		while(count>0) {		
			boolean[][] visited = new boolean[N][M];
			visited[0][0]=true;
			Queue<Cheese> queue = new LinkedList<>(); 
			queue.offer(new Cheese(0,0));
			num=count;
			while(!queue.isEmpty()) {
				Cheese cheese = queue.poll();
				int cx = cheese.x;
				int cy = cheese.y;;
				
				for(int d=0; d<4; d++) {
					int nx = cx+dx[d];
					int ny = cy+dy[d];
					if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
					if(visited[nx][ny]) continue;
					if(map[nx][ny]==1) {					
						visited[nx][ny]=true;
						map[nx][ny]=0;
						count--;
					}else {
						visited[nx][ny]=true;
						queue.offer(new Cheese(nx, ny));
					}
				}
			}
			time++;
		}
		
		System.out.println(time);
		System.out.println(num);
	}

}
