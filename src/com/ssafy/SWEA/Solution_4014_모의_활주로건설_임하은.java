package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_모의_활주로건설_임하은 {
	
	static int N, X;
	static int[][] map;
	static int count;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			count=0;
			StringTokenizer st =  new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<N; i++) {
				
				if(cango(i,0,1,map[i][0])) count++;
				if(cango(0,i,0,map[0][i])) count++;
				
			}
			
			System.out.println("#"+t+" "+count);
		}

	}
	
	public static boolean cango(int x, int y, int d, int num) {
		int[] dx= {1,0}; //하, 우
		int[] dy= {0,1}; 
		int c=1;
		int nx=x;
		int ny=y;
		for(int i=1; i<N; i++ ) {
			nx +=dx[d];
			ny +=dy[d];
			if(map[nx][ny]==num) {
				c++;
				continue;
			}else if(map[nx][ny]-num==1){//커질 때
				if(c>=X) {
					num=map[nx][ny];
					c=1;
					continue; 
				}
				return false;
			}else if(map[nx][ny]-num==-1) { //작아질 때
				if(c<0) return false;
				num=map[nx][ny];
				c=X*(-1)+1;
			}else {
				return false;
			}	
		}
		if(c>=0) {
			return true;			
		}
		return false;
		
		
	}

}
