package com.ssafy.BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main_17135_G3_캐슬디펜스_임하은 {
	static int N,M,D;
	static int count;
	static int MAX = 0;
	static int[][] map;
	static int[] shoot=new int[3];
	static ArrayList<int[]> idx =new ArrayList<>(); //적의 위치
	static ArrayList<int[]> p =new ArrayList<>();
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		M=sc.nextInt();
		D=sc.nextInt();
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==1) {
					int[] temp = new int[2];
					temp[0]=i;
					temp[1]=j;
					idx.add(temp);
				}
			}
		}
		
		combi(0,0);
		System.out.println(MAX);
			

	}
	private static void combi(int cur, int cnt) {
		if(cnt==3) {
			count=0;
			p =new ArrayList<>();
			for(int i=0; i<idx.size(); i++) {
				p.add(idx.get(i));
			}
			delete();
			MAX=Math.max(MAX, count);
			return;
		}
		for(int i=cur; i<M; i++) {
			shoot[cnt]=i;
			combi(i+1, cnt+1);
		}
	}
	
	private static void delete() {
		Set<Integer> set = new HashSet<>();
		while(p.size()!=0) { //남은 적이 없으면 종료
			//(M,temp[0]) 첫번째 궁수랑
			int index=-1; //적의 index
			
			for(int i=0; i<3; i++) {
				int min=N+M;
				for(int j=0; j<p.size(); j++) {
					if(Math.abs(N-p.get(j)[0])+Math.abs(shoot[i]-p.get(j)[1])<=D) {
						if(Math.abs(N-p.get(j)[0])+Math.abs(shoot[i]-p.get(j)[1])<min) {
							min=Math.abs(N-p.get(j)[0])+Math.abs(shoot[i]-p.get(j)[1]);
							index=j;
							
						}
						if(Math.abs(N-p.get(j)[0])+Math.abs(shoot[i]-p.get(j)[1])==min) {
							if(p.get(index)[1]>p.get(j)[1]) {
								index=j;
							}
						}
						
					}
				}
				set.add(index);
			}
			for(int i=p.size()-1; i>=0; i--) {
				if(set.contains(i)) {
					p.remove(i);
					count++;
				}
			}
			move();
		}
	}
	
	private static void move() {
		for(int j=p.size()-1; j>=0; j--) { //적의 위치 한칸씩 밑으로
			int x=p.get(j)[0];
			if(x+1>=N) {
				p.remove(j);
				continue;
			}
			p.get(j)[0]+=1;
		}

	}

}
