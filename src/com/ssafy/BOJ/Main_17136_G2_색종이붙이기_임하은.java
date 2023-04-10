package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17136_G2_색종이붙이기_임하은 {

	static int[][] map = new int[10][10];
	static int[] count = new int[6];
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<10;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		if(result==Integer.MAX_VALUE) result=-1;
		System.out.println(result);
		
	}
	
	private static void dfs(int x, int y) {
		if(x==10 && y==0) {
			int sum=0;
			for(int i=1; i<6; i++) {
				sum+=count[i];
			}
			result=Math.min(result, sum);
			return;
		}
		int nx=x;
		int ny=y+1;
		if(ny==10) {
			nx++;
			ny=0;
		}
		if(map[x][y]==0) {
			dfs(nx,ny);
		}else {
			for(int n=5; n>0; n--) {
				if(can(x, y, n)) {
					check(x, y, n);
					dfs(nx,ny);
					cancel(x, y, n);
				}
			}
		}
	}

	private static boolean can(int x, int y, int n) {
		if(x+n-1>=10||y+n-1>=10) return false;
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if(map[i][j]==0) {
					return false;
				}
			}
		}
		count[n]++;
		if(count[n]>5) {
			count[n]--;
			return false;
		}
		return true;
	}
	
	private static void check(int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				map[i][j]=0;
			}
		}
	}
	
	private static void cancel(int x, int y, int n) {
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				map[i][j]=1;
			}
		}
		count[n]--;
	}
	
}
