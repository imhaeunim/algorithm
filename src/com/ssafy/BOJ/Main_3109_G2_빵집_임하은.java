package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_3109_G2_빵집_임하은 {
	static int R,C;
	static char[][] map;
	static int count=0;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		sc.nextLine();
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String temp=sc.nextLine();
			for(int j=0; j<C; j++) {
				map[i][j]=temp.charAt(j);
			}
		}
		int sum=0;
		for(int i=0; i<R; i++) {
			count=0;
			dfs(i,0);
			sum+=count;
		}

		System.out.println(sum);
	}
	
	private static void dfs(int x, int y) {
		int[] dx = {-1,0,1};

		map[x][y]='x';
		if(y==C-1) {
			count=1;
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(x+dx[i]<0||x+dx[i]>=R||y+1>=C) continue;
			if(map[x+dx[i]][y+1]!='x') {
				if(count==1) return;
				dfs(x+dx[i],y+1);
			}
		}
	}

}
