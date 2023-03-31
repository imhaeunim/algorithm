package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_5656_모의_벽돌깨기 {
	
	
	private static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}	
	}
	
	static int N, W, H, min;
	static int[][] map;
	static int[] selected;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
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
			selected = new int[W];
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0,map);
			System.out.printf("#%d %d\n",t,min);

		
		}
	}
	
	private static boolean go(int count, int[][] map) {
		//던지기 전에 벽돌이 남아있는지 확인 if 벽돌이 없다면 return
		int result = getRemain(map);
		if(result==0) {
			min = 0;
			return true;
		}
		
		if(count==N){
			if(min>result) min = result;
			return false;
		}
		
		int[][] newMap = new int[H][W];
		//모든 열에 구슬 던져보기
		for(int c = 0; c<W; c++) { //c : 구슬을 던지는 열
			//구슬에 처음 맞는 벽돌 찾기(위쪽에서)
			int r = 0;
			while(r<H&&map[r][c]==0)++r;
			
			if(r==H) continue;
			
			//벽돌 원본의 상태로 초기화
			copy(map,newMap);
			//벽돌 부수기
			boom(newMap,r,c);
//			boom(newMap,r,c,newMap[r][c]);
			//벽돌 내리기
			down(newMap);
			//다음 구슬 던지러 가기
			if(go(count+1,newMap)) return true;
		}
		
		return false;
		
	}
	
	private static Stack<Integer> stack = new Stack<>();
	private static void down(int[][] map) { //자료구조
		//각 열에 대해 윗행부터 아래행가지 벽돌만 스택에 넣어두고 배서 아래행부터 채우기
		for(int c=0; c<W; c++) {
			for(int r=0; r<H; r++) {
				if(map[r][c]>0) {
					stack.push(map[r][c]);
					map[r][c]=0;
				}
			}
			int r = H-1;
			while(!stack.isEmpty()) {
				map[r--][c] = stack.pop();
			}
		}
	}

	// BFS
	private static void boom(int map[][], int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		if(map[r][c]>1) {
			queue.offer(new Point(r, c, map[r][c]));
		}
		map[r][c]=0;	//방문 체크
		
		Point current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			
			//현 벽돌의 cnt-1만큼 사방 탐색
			for (int d = 0; d < 4; d++) {
				int nr=current.r;
				int nc=current.c;
				for(int k=1; k<=current.cnt-1; k++) {
					nr+=dr[d];
					nc+=dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc]=0;	//방문 체크						
					}
				}
			}
		}
	}
	
	
	
//	//DFS
//	private static void boom(int map[][], int r, int c, int cnt) {
//		map[r][c]=0;
//		if(cnt==1) return;
//		
//		//현 벽돌의 cnt-1만큼 사방 탐색
//		for (int d = 0; d < 4; d++) {
//			int nr=r;
//			int nc=c;
//			for(int k=1; k<cnt-1; k++) {
//				nr+=dr[d];
//				nc+=dc[d];
//				if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]>0) {
//					boom(map,nr,nc,map[nr][nc]);
//				}
//			}
//		}
//	}
		

	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j]>0) count++;
			}
		}		
		return count;
	}
	
	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j]=map[i][j];
			}
		}		
	}


}
