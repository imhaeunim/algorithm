package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;



public class day0227 {
	static int[] list = { 0,1,2,3,4,5};
	static int[] temp;
 	static boolean[] visited = new boolean[6];
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		temp = new int[N];
		per(0);
//		combi(0,0);
//		subset(0);
	}

	private static void per(int cnt) {
		if(cnt == N) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=0; i<6; i++) {
			if (visited[i]) continue;
			visited[i]=true;
			temp[cnt]=list[i];
			per(cnt+1);
			visited[i]=false;
		}
	}
	
	private static void combi(int start, int cnt) {
		if(cnt==N) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i = start; i<6; i++) {
			temp[cnt] = list[i];
			combi(i+1, cnt+1);
		}
	}
	
	private static void subset(int cur) {
		if(cur==6) {
			for(int i=0; i<6; i++) {
				if (visited[i]) {
					System.out.printf("%d ",i);
				}
			}
			System.out.println();
			return;
		}
		visited[cur] = true;
		subset(cur+1);
		visited[cur] = false;
		subset(cur+1);
		
	}
}
