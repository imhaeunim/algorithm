package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_G1_달이차오른다가자_임하은 {
	
	static int N,M;
	static char[][] map;
	static boolean[][][] visited;
	static int startx, starty;
	
	static class Key {
		int x;
		int y;
		int v;
		int k;
		public Key(int x, int y, int v, int k) {
			this.x = x;
			this.y = y;
			this.v = v;
			this.k = k;
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map=new char[N][M];
		visited = new boolean[N][M][1<<6];
		
		for(int i=0; i<N; i++) {			
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j]=input.charAt(j);
				if(map[i][j]=='0') {
					startx=i;
					starty=j;
				}

			}
		}
		
		
		Queue<Key> queue = new LinkedList<Key>();
		queue.offer(new Key(startx,starty,0,0));
		visited[startx][starty][0]=true;
		
		int[] dx = {1,-1,0,0};
		int[] dy = {0,0,-1,1};
		
		int result=-1;
		while(!queue.isEmpty()) {
			Key key=queue.poll();
			int x=key.x;
			int y=key.y;
			int v=key.v;
			int k=key.k;
			if(map[x][y]=='1') {
				result=v;
				break;
			}
			
			for(int d=0; d<4; d++)
			{
				int nx = x+dx[d];
				int ny = y+dy[d];
				int nk=k;
				if(nx<0||ny<0||nx>=N||ny>=M) continue;
				if(map[nx][ny]=='#') continue;
				if(visited[nx][ny][k]) continue;
				if(map[nx][ny]>='a'&&map[nx][ny]<='f') {
					nk|=(1<<map[nx][ny]-'a');
				}
				if(map[nx][ny]>='A' && map[nx][ny]<='F') {
					if(((1<<map[nx][ny]-'A')&k)==0) continue;
				}
				visited[nx][ny][k]=true;
				queue.offer(new Key(nx,ny,v+1,nk));
			}
			
			
		}
		
		System.out.println(result);

	}

}
