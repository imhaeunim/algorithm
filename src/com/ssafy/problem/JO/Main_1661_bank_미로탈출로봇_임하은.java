package com.ssafy.problem.JO;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1661_bank_미로탈출로봇_임하은 {
	static int X,Y;
	static boolean[][] map;
	static boolean[][] visited;
	static int x2,y2;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y=sc.nextInt();
		X=sc.nextInt();
		int y1 =sc.nextInt()-1;
		int x1 =sc.nextInt()-1;
		y2 =sc.nextInt()-1;
		x2= sc.nextInt()-1;
		sc.nextLine();
		visited=new boolean[X][Y];
		map = new boolean[X][Y];
		for(int i=0; i<X; i++) {
			String in = sc.nextLine();
			for(int j=0; j<Y; j++) {
				if(in.charAt(j)=='1') {
					map[i][j]=true;
				}
			}
		}

//		bfs(x1,y1);
		dfs(x1,y1,0);
		System.out.println(min);
		
	}
	
	static void dfs(int x, int y, int cnt) {
		if(x==x2&&y==y2) {
			min=cnt;
			return;
		}
		if(cnt>=min) {
			return;
		}
		visited[x][y]=true;
		int[] dx = {0, 0, -1, 1};	//좌 우 상 하
		int[] dy = {-1, 1, 0, 0};
		for(int i=0; i<4; i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx>=0&&nx<X&&ny>=0&&ny<Y) {
				if(!map[nx][ny]&&!visited[nx][ny]) {
					dfs(nx,ny,cnt+1);
				}
			}
		}
	}
	
	
	
	static void bfs(int x,int y) {
		Queue<Integer> queue = new LinkedList<>();
		visited[x][y]=true;
		
		int[] dx = {0, 0, -1, 1};	//좌 우 상 하
		int[] dy = {-1, 1, 0, 0};
		
		queue.offer(x);
		queue.offer(y);
		queue.offer(0);
		
		while(!queue.isEmpty()) {
			int cx=queue.poll();
			int cy=queue.poll();
			int cnt=queue.poll();
			if(cx==x2&&cy==y2) {	//목적지에 도착
				System.out.println(cnt);
				return;
			}
			for(int i=0; i<4; i++) {	//4방
				int nx = cx + dx[i];
				int ny = cy + dy[i];
				if(nx>=0&&nx<X&&ny>=0&&ny<Y) {	//지도 범위
					if(!map[nx][ny]&&!visited[nx][ny]) {	//벽(true)이 아니고 방문한 곳이 아니면
						visited[nx][ny]=true;	//방문했어
						queue.offer(nx);
						queue.offer(ny);
						queue.offer(cnt+1);
					}
				}	
			}
		}		
	}
}
