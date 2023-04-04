package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_3055_G4_탈출_임하은 {
	
	static class Position{
		int x;
		int y;
		int c;
		public Position(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[R][C];
		Queue<Position> queue = new LinkedList<>();

		int endx=0;
		int endy=0;
		boolean[][] gvisited = new boolean[R][C];
		for(int i=0; i<R; i++) {			
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='S') {
					queue.offer(new Position(i, j, 0));
					gvisited[i][j]=true;
				}
				if(map[i][j]=='D') {
					endx=i;
					endy=j;
				}
				
			}
		}
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		int result=Integer.MAX_VALUE;
		int gc=-1;
		while(!queue.isEmpty()) {
			Position go = queue.poll();
			int gx=go.x;
			int gy=go.y;
			if(gc<go.c) {
				boolean[][] visited = new boolean[R][C];
				for(int i=0; i<R; i++) {
					for(int j=0; j<C; j++) {
						if(visited[i][j]) continue;
						if(map[i][j]=='*') {
							visited[i][j]=true;
							for(int d=0; d<4; d++) {
								int nx=i+dx[d];
								int ny=j+dy[d];
								if(nx<0|| ny<0|| nx>=R|| ny>=C) continue;
								if(map[nx][ny]=='*'||map[nx][ny]=='X') continue;
								if(map[nx][ny]!='D') {
									map[nx][ny]='*';
									visited[nx][ny]=true;
								}
							}
						}
					}
				}
				gc=go.c;
			}
			for(int d=0; d<4; d++) {
				int gnx=gx+dx[d];
				int gny=gy+dy[d];
				if(gnx<0|| gny<0|| gnx>=R|| gny>=C) continue;
				if(gvisited[gnx][gny]) continue;
				if(gnx==endx&& gny==endy) {
					result=gc+1;
					queue.clear();
					break;
					
				}
				if(map[gnx][gny]=='.') {					
					queue.offer(new Position(gnx, gny, gc+1));
					gvisited[gnx][gny]=true;
				}
			}
			
		}

		if(result==Integer.MAX_VALUE) {
			System.out.println("KAKTUS");
		}else {
			System.out.println(result);
		}
			

	}

}
