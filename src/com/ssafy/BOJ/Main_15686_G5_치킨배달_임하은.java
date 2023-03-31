package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main_15686_G5_치킨배달_임하은 {
	static int N;
	static int M;
	static int[][] map;
	static int ch;
	static int house;
	static int[] num;
	static int[][] h_xy;
	static int[][] ch_xy;
	static int MIN=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queueC = new LinkedList<Integer>();
		Queue<Integer> queueH = new LinkedList<Integer>();
		N=sc.nextInt();
		M=sc.nextInt();
		num = new int[M];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j]=sc.nextInt();
				if(map[i][j]==2) {
					queueC.offer(i);
					queueC.offer(j);					
				}
				if(map[i][j]==1) {
					queueH.offer(i);
					queueH.offer(j);
				}
			}
		}
		
		ch = queueC.size()/2;
		house = queueH.size()/2;
		h_xy=new int[house][2];
		ch_xy=new int[ch][2];
		for(int i=0; i<ch; i++) {
			ch_xy[i][0]=queueC.poll();
			ch_xy[i][1]=queueC.poll();
		}
		for(int i=0; i<house; i++) {
			h_xy[i][0]=queueH.poll();
			h_xy[i][1]=queueH.poll();
		}		
		combi(0,0);
		System.out.println(MIN);
	}
	
	static void combi(int cur, int cnt) { //치킨 집 조합
		if(cnt==M) {

			if(distance()<MIN) { //가장 작은 도시의 치킨 거리 구해주기
				MIN=distance();
			}
			return;
		}
		if(cur>=ch) {
			return;
		}
		num[cnt]=cur;
		combi(cur+1,cnt+1);
		combi(cur+1,cnt);
	}
	
	static int distance() { //한 개의 집에서 조합으로 얻은 치킨집 모두 비교하기  
		int sum=0;
		for(int i=0; i<house; i++) {
			int min = Integer.MAX_VALUE;
			for(int j=0; j<M; j++) {
				if((int)(Math.abs(h_xy[i][0]-ch_xy[num[j]][0])+Math.abs(h_xy[i][1]-ch_xy[num[j]][1]))<min) {
					min =(int)(Math.abs(h_xy[i][0]-ch_xy[num[j]][0])+Math.abs(h_xy[i][1]-ch_xy[num[j]][1])); //치킨 거리
				}
			}
			sum+=min; //도시의 치킨 거리
		}
		return sum;
	}

}
