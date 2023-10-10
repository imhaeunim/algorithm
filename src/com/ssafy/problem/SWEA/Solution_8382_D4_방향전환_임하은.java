package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8382_D4_방향전환_임하은 {

	static class Point{
		int x;
		int y;
		int c;
		int d;
		public Point(int x, int y, int c, int d) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.d = d;
		}		
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sx=Integer.parseInt(st.nextToken())+100;
			int sy=Integer.parseInt(st.nextToken())+100;
			int ex=Integer.parseInt(st.nextToken())+100;
			int ey=Integer.parseInt(st.nextToken())+100;
			
			int[] dx = {-1,1,0,0}; //상하좌우
			int[] dy = {0,0,-1,1};
			
			boolean visited[][][] = new boolean[201][201][2];
			Queue<Point> queue = new LinkedList<>();
			
			for(int d=0; d<4; d++) {
				int nx = sx+dx[d];
				int ny = sy+dy[d];
				if(nx<0||ny<0||nx>200||ny>200) continue;
				if(d<2) {//상하		
					visited[nx][ny][0]=true;
				}else {
					visited[nx][ny][1]=true;
				}
				queue.offer(new Point(nx, ny, 1, d));
			}
			
//			queue.offer(new Point(sx, sy, 0, 1));
//			queue.offer(new Point(sx, sy, 0, 3));
			
			visited[sx][sy][0]=true;
			visited[sx][sy][1]=true;
			
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				int cx = point.x;
				int cy = point.y;
				int c = point.c;
				int d = point.d;
				
				if(cx==ex&&cy==ey) {
					System.out.println("#"+t+" "+c);
					break;
				}
				
				if(d<2) {
					for(int i=2; i<4; i++) {
						int nx = cx+dx[i];
						int ny = cy+dy[i];
						if(nx<0||ny<0||nx>200||ny>200) continue;
						if(visited[nx][ny][1]) continue;
						visited[nx][ny][1]=true;
						queue.offer(new Point(nx, ny, c+1, i));
					}
				}else {
					for(int i=0; i<2; i++) {
						int nx = cx+dx[i];
						int ny = cy+dy[i];
						if(nx<0||ny<0||nx>200||ny>200) continue;
						if(visited[nx][ny][0]) continue;
						visited[nx][ny][0]=true;
						queue.offer(new Point(nx, ny, c+1, i));
					}
				}
				
			}

		}
		

	}

}
