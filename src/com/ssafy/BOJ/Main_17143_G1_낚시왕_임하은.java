package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_17143_G1_낚시왕_임하은 {
	
	static int R,C,M,point;
	static boolean[][] inShark;
	static ArrayList<Shark> shark = new ArrayList<>();
	static int[] dr = {-1,1,0,0};	//상 하 우 좌 
	static int[] dc = {0,0,1,-1};
	
	static class Shark implements Comparable<Shark>{
		int r; 
		int c; 
		int s; //속력
		int d; //이동 방향
		int z; //크기
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
		@Override
		public int compareTo(Shark o) {
			return o.z-this.z;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Shark [r=").append(r).append(", c=").append(c).append(", s=").append(s).append(", d=")
					.append(d).append(", z=").append(z).append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			shark.add(new Shark(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(shark);
		for(int pos=0; pos<C; pos++) {
			if(shark.size()==0) break;
			int getR = Integer.MAX_VALUE;
			int getIdx = -1;
			for(int i=0; i<shark.size(); i++) {
				if (shark.get(i).c==pos) {
					if(shark.get(i).r<getR) {
						getR=shark.get(i).r;
						getIdx = i;
					}
				}
			}
			if(getIdx!=-1) {
				point+=shark.get(getIdx).z;
				shark.remove(getIdx);
			}
			
			inShark = new boolean[R][C];
			for(int i=0; i<shark.size(); i++) {
				int r = shark.get(i).r;
				int c = shark.get(i).c;
				int s = shark.get(i).s;
				
				if(shark.get(i).d<2) {
					s = s%((R-1)*2);
				}else {
					s = s%((C-1)*2);
				}
				
				int nr = r;
				int nc = c;
				while(s>0){
					nr += dr[shark.get(i).d];
					nc += dc[shark.get(i).d];
					if(nr<0||nr>=R||nc<0||nc>=C) {//경계값이면
						if(shark.get(i).d==0) shark.get(i).d=1;
						else if(shark.get(i).d==1) shark.get(i).d=0;
						else if(shark.get(i).d==2) shark.get(i).d=3;
						else shark.get(i).d=2;
						s++;
						continue;
					}
					s--;
				}
				
				shark.get(i).r = nr;
				shark.get(i).c = nc;
				
				if(inShark[nr][nc]) {//상어가 이미 있으면
					shark.remove(i);
					i--;
					continue;
				}else {
					inShark[nr][nc] = true;
				}
				
			}
			
		}
		System.out.println(point);
	
	
	}
}
