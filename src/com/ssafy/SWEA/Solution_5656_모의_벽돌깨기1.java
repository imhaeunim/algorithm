package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_모의_벽돌깨기1 {

	static int N, W, H, min;
	static int[][] map;
	static boolean[][] visited;
	static int[] selected;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		//중복 순열, dfs(방향, 힘)
		//벽돌 내리기(0이 아니고 밑에가 0이면 내리기)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			visited = new boolean[H][W];
			selected = new int[W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			
			permutation(0);
		
		}
	}
	

	
	private static void permutation(int cnt) {
		if(cnt==N) {
			
			return;
		}
		for(int i=0; i<W; i++) {
			selected[cnt]=i;
			permutation(cnt+1);
		}
	}
	
	private static void dfs(int x, int y, int d, int cnt) {
		if(cnt==0) {
			return;
		}
		for(int i=0; i<4; i++) {
			int cx = x+dx[i];
			int cy = y+dy[i];
			if(cx<0 || cx>=W || cy<0 || cy>=H) continue;
			if(map[cx][cy]>1) {
				dfs(cx,cy,i,cnt);
			}
			dfs(cx,cy,i,cnt);
		}
	}

}
