package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_G5_맥주마시면서걸어가기_임하은 {
	
	public static class Point {
		int p;
		int c;
		public Point(int p, int c) {
			super();
			this.p = p;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st;
			int[][] map = new int[n+2][2];
			int[][] adj=new int[n+2][n+2];
			for(int i=0; i<=n+1; i++) {
				st = new StringTokenizer(br.readLine());
				map[i][0]= Integer.parseInt(st.nextToken());
				map[i][1]= Integer.parseInt(st.nextToken());
			}
			
			
			Queue<Point> queue = new LinkedList<>();
			boolean[] visited = new boolean[n+2];
			for(int i=1; i<=n+1; i++) {
				int dis = Math.abs(map[0][0]-map[i][0])+Math.abs(map[0][1]-map[i][1]);
				if(dis<=1000) {
					queue.offer(new Point(i,20));
					visited[i]=true;
				}
			}
			String result = "sad";
			while(!queue.isEmpty()) {
				Point point = queue.poll();
				int p=point.p;
				if(p==n+1) {
					result = "happy";
					break;
				}
				for(int i=1; i<=n+1; i++) {
					if(visited[i]) continue;
					int dis = Math.abs(map[p][0]-map[i][0])+Math.abs(map[p][1]-map[i][1]);
					if(dis<=1000) {
						queue.offer(new Point(i,20));
						visited[i]=true;
					}
				}
			}
			System.out.println(result);
			
		}
	}

}
