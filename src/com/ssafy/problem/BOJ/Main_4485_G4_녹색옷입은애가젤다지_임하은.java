package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4485_G4_녹색옷입은애가젤다지_임하은 {

	private static class Rupee implements Comparable<Rupee>{
		int x;
		int y;
		int v;
		
		public Rupee(int x, int y, int v) {
			super();
			this.x = x;
			this.y = y;
			this.v = v;
		}

		@Override
		public int compareTo(Rupee o) {
			return this.v-o.v;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = 1;
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N==0) break;
			int[][] map = new int[N][N];
			int[][] visited = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			int[] dx = {-1,1,0,0};
			int[] dy = {0,0,-1,1};
			
			PriorityQueue<Rupee> queue = new PriorityQueue<>();
			for(int i=0; i<N; i++) {				
				Arrays.fill(visited[i], Integer.MAX_VALUE);
			}
			visited[0][0]=map[0][0];
			queue.add(new Rupee(0,0,map[0][0]));
			while(!queue.isEmpty()) {
				Rupee rupee = queue.poll();
				int cx=rupee.x;
				int cy=rupee.y;
				int cv=rupee.v;
				
				for(int i=0; i<4; i++) {
					int nx=cx+dx[i];
					int ny=cy+dy[i];
					
					if(nx<0|| ny<0|| nx>=N|| ny>=N) continue;
					if(visited[nx][ny]!=Integer.MAX_VALUE) continue;
					if(cv+map[cx][cy]>visited[nx][ny]) continue;
					visited[nx][ny]=Math.min(visited[nx][ny],cv+map[nx][ny]);
					queue.add(new Rupee(nx,ny,cv+map[nx][ny]));
					
				}

			}
			System.out.printf("Problem %d: ",test);
			System.out.println(visited[N-1][N-1]);
			
			test++;
		}
	}

}
