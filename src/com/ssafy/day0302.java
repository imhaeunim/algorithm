package com.ssafy;

import java.util.Arrays;

public class day0302 {
	
	static int[] list = {1,2,3,4,5};
	static boolean[] visited = new boolean[5];
	static int[] temp = new int[3];
	public static void main(String[] args) {
		
//		permutatoin(0);
//		combination(0, 0);
//		subSet(0);
		
		Arrays.sort(list);
		do {
			System.out.println(Arrays.toString(list));
		}while(np());
	}
	
	
	
	
	private static boolean np() {
		int n = list.length;
		
		int i=n-1;
		while(i>0 & list[i-1]>=list[i]) --i;
		if(i==0) return false;
		return false;
	}




	private static void permutatoin(int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(temp));
			return;
			
		}
		for(int i=0; i<5; i++) {
			visited[i] = true;
			temp[cnt] = list[i];
			permutatoin(cnt+1);
			visited[i] = false;
		}
	}
	
	private static void combination(int cur, int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=cur; i<5; i++) {
			temp[cnt] = list[i];
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
		visited[cur] = true;
		subSet(cur+1);
		visited[cur] = false;
		subSet(cur+1);
	}

}
