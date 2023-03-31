package com.ssafy;

import java.util.Arrays;

public class day0228 {
	
	static int[] list = {0,1,2,3,4};
	static boolean[] visited = new boolean[5];
	static int[] temp = new int[3];
	public static void main(String[] args) {
		
//		permutation(0);
//		combination(0, 0);
		subSet(0);
	}
	
	private static void permutation(int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for(int i=0; i<5; i++) {
			if(visited[i]) continue;
			temp[cnt] = list[i];
			visited[i]=true;
			permutation(cnt+1);
			visited[i]=false;
		}
	}
	
	private static void combination(int cur, int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=cur; i<5; i++) {
			temp[cnt]=list[i];
			combination(i+1, cnt+1);
		}
	}
	
	private static void subSet(int cur) {
		if(cur==5) {
			for(int i=0; i<5; i++) {
				if(visited[i]) {
					System.out.printf("%d ",i);
				}
			}
			System.out.println();
			return;
		}
		visited[cur]=true;
		subSet(cur+1);
		visited[cur]=false;
		subSet(cur+1);
		
	}

}
