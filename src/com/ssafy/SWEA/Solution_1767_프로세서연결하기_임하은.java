package com.ssafy.SWEA;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_임하은 {
	
	static int N, num;
	static int result = Integer.MAX_VALUE;
	static int[] core_idx;
	static int[] combi;
	static int map[][];
	static int[] dx = {0,0,-1,1}; //좌 우 상 하
	static int[] dy = {-1,1,0,0,};
	static ArrayList<int[]> core;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			core = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						if(i==0 || i==N-1 || j==0 || j==N-1) {
							map[i][j]=-1;
						}else {
							core.add(new int[] {i, j});
						}
					}
				}
			}
			num = core.size();
			
			for(int use = num-1; use>0; use--) {
				if(result!=Integer.MAX_VALUE) {
					System.out.println(result);
					break;
				}
				combi = new int[use];
				combination(0, 0, use);
			}	
		}
	}
	
	private static void combination(int cur, int cnt, int use) {
		if(use == cnt) {
			result = Math.min(result, can_combi(0));
			return;
		}
		
		for(int i= cur; i<num; i++) {
			combi[cnt]=i;
			combination(i+1, cnt+1, use);
		}
	}
	
	private static int can_combi(int idx) {
		if(idx==num+1) {
			return cal_distance();
		}
		for(int d=0; d<4; d++) {
			if(can_go(core.get(idx)[0],core.get(idx)[1],d)) {
				can_combi(idx++);
			}
		}
		return Integer.MAX_VALUE;	
	}
	
	private static int cal_distance() {
		int count=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==2) count++;
			}
		}
		return count;
		
	}

	private static boolean can_go(int x, int y,int d) { //좌우상하
		if(d==0) {//좌
			int cx = x;
			for(int cy=y-1; cy>=0; cy--) {
				if(cx==0) return true;
				if (map[cx][cy]!=0) return false;
			}
		}else if(d==1) { //우
			int cx = x;
			for(int cy=y+1; cy<N; cy++) {
				if(cx==N-1) return true;
				if (map[cx][cy]!=0) return false;
			}
		}else if(d==2) {//상
			int cy=y;
			for(int cx = x-1; cx>=0; cx--) {
				if(cx==0) return true;
				if(map[cx][cy]!=0) return false;
			}
		}else { //하
			int cy=y;
			for(int cx = x+1; cx<N; cx++) {
				if(cx==N-1) return true;
				if(map[cx][cy]!=0) return false;
			}
		}
		return false;
			
	}
	
	
	

}
