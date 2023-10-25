package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_G1_토마토_임하은 {

	
	static int M,N,H;
	static int[][][] box;
	static int[] dx = {-1,1,0,0,0,0}; //상하좌우뒤앞
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	
	static class Tomato{
		int x;
		int y;
		int z;
		int day;
		
		public Tomato(int x, int y, int z, int day) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); //행
		N = Integer.parseInt(st.nextToken()); //열
		H = Integer.parseInt(st.nextToken());
		box = new int[N][M][H]; //열 행 깊이
		
		Queue<Tomato> queue = new LinkedList<>();
		
		int check = 0; //안 익은 토마토 개수
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=0; m<M; m++) {
					int temp = Integer.parseInt(st.nextToken());
					box[n][m][h]=temp;
					if(temp==1) queue.offer(new Tomato(m, n, h, 1));
					else if(temp==0) check++;
				}
			}
		}
		
		int minDay = 0;
		if(check == 0) {
			System.out.println("0");
			System.exit(0);
		}

		while(!queue.isEmpty()) {
			
			Tomato tomato = queue.poll();
			int x = tomato.x;
			int y = tomato.y;
			int z = tomato.z;
			int day= tomato.day;
			
			for(int i=0; i<6; i++) {
				
				int nx = x+dx[i];
				int ny = y+dy[i];
				int nz = z+dz[i];
				if(nx<0 || ny<0 || nz<0 || nx>=M || ny>=N|| nz>=H) continue;
				if(box[ny][nx][nz]==0) {
					box[ny][nx][nz] = 1;
					queue.offer(new Tomato(nx,ny,nz,day+1));
					minDay = Math.max(minDay,day);
					check --;
				}
				
			}
			
		}
		
		if(check>0) System.out.println("-1");
		else System.out.println(minDay);
		
	}

}
