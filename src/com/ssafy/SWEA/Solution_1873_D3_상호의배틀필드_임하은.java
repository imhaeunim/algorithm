package com.ssafy.SWEA;

import java.util.Scanner;

public class Solution_1873_D3_상호의배틀필드_임하은 {
	static int N,M;
	static int x,y,d;
	static char[][] map;
	static char[] move;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for(int t =1; t<=T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			sc.nextLine();
			map = new char[N][M];
			for(int i=0; i<N; i++) {
				String temp = sc.nextLine();
				for(int j=0; j<M; j++) {
					map[i][j]=temp.charAt(j);
					if(map[i][j]=='^') {
						x=i; y=j; d=0;
						map[i][j]='.';
					}else if(map[i][j]=='v') {
						x=i; y=j; d=1;
						map[i][j]='.';
					}else if(map[i][j]=='<') {
						x=i; y=j; d=2;
						map[i][j]='.';
					}else if(map[i][j]=='>') {
						x=i; y=j; d=3;
						map[i][j]='.';
					}
					
				}
			}
			
			int num=sc.nextInt();
			move = new char[num];
			sc.nextLine();
			String in = sc.nextLine();
			for(int i=0; i<num; i++) {
				move[i]=in.charAt(i);
			}
			
			go();
			if(d==0) {
				map[x][y]='^';
			}else if(d==1) {
				map[x][y]='v';
			}else if(d==2) {
				map[x][y]='<';
			}else {
				map[x][y]='>';
			}
			System.out.printf("#%d ",t);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
		
	}
	
	private static void go() {
		for(int i=0; i<move.length; i++) {
			if(move[i]=='S') {
				Shoot(x+dx[d],y+dy[d]);
			}else if(move[i]=='U') {
				int cx=x+dx[0];
				int cy=y+dy[0];
				d=0;
				if(cx<0||cx>=N||cy<0||cy>=M) continue;
				if(map[cx][cy]=='*'||map[cx][cy]=='#'||map[cx][cy]=='-') continue;
				
				x=cx; y=cy;
			}else if(move[i]=='D') {
				int cx=x+dx[1];
				int cy=y+dy[1];
				d=1;
				if(cx<0||cx>=N||cy<0||cy>=M) continue;
				if(map[cx][cy]=='*'||map[cx][cy]=='#'||map[cx][cy]=='-') continue;
				
				x=cx; y=cy;
			}else if(move[i]=='L') {
				int cx=x+dx[2];
				int cy=y+dy[2];
				d=2;
				if(cx<0||cx>=N||cy<0||cy>=M) continue;
				if(map[cx][cy]=='*'||map[cx][cy]=='#'||map[cx][cy]=='-') continue;
				
				x=cx; y=cy;
			}else if(move[i]=='R') {
				int cx=x+dx[3];
				int cy=y+dy[3];
				d=3;
				if(cx<0||cx>=N||cy<0||cy>=M) continue;
				if(map[cx][cy]=='*'||map[cx][cy]=='#'||map[cx][cy]=='-') continue;
				
				x=cx; y=cy;
			}
			
		}
	}
	private static void Shoot(int cx, int cy) {
		while(true) {
			if(cx<0||cx>=N|| cy<0||cy>=M) return;
			if(map[cx][cy]=='.'||map[cx][cy]=='-') {
				cx+=dx[d];
				cy+=dy[d];
			}else if(map[cx][cy]=='*') {
				map[cx][cy]='.';
				return;
			}else if(map[cx][cy]=='#') {
				return;
			}
		}
	}
}
