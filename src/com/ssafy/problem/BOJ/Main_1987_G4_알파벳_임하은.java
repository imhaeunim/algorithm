package com.ssafy.problem.BOJ;

import java.util.Scanner;

public class Main_1987_G4_알파벳_임하은 {
	static int R,C;
	static char[][] map;
	static int[] dx= {-1, 1, 0, 0};
	static int[] dy= {0, 0, -1, 1};
	static boolean[] visited = new boolean[26];
	static int max = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String temp=sc.next();
			for(int j=0; j<C; j++) {
				map[i][j]=temp.charAt(j);
			}
		}
		visited[map[0][0]-'A']=true;
		dfs(0,0,1);
		System.out.println(max);
		
	}
	
	static void dfs(int x, int y,int cnt) {
		if(cnt>max) {
			max=cnt;
		}
		
		for(int i=0; i<4; i++) {
			
			if(x+dx[i]<0||x+dx[i]>=R||y+dy[i]<0||y+dy[i]>=C) continue;
			if(!visited[map[x+dx[i]][y+dy[i]]-'A']) {
				visited[map[x+dx[i]][y+dy[i]]-'A']=true; 
				dfs(x+dx[i],y+dy[i],cnt+1);
				visited[map[x+dx[i]][y+dy[i]]-'A']=false;
			}
				
		}

		
	}
}
