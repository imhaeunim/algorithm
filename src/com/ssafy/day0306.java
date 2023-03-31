package com.ssafy;

import java.util.Arrays;

public class day0306 {
	
	static int[] list = {0,1,2,3,4,5};
	static boolean[] visited = new boolean[6];
	static int[] selec = new int[3];
	static int[] parent = new int[7];
	
	public static void main(String[] args) {
		
//		permutation(0);
//		combination(0, 0);
//		subSet(0);
		
//		Arrays.sort(list);
//		do {
//			System.out.println(Arrays.toString(list));
//		} while (np(list));
		
		for(int i=0; i<7; i++) {
			make(i);
		}
		
		union(4, 3);
		union(6, 5);
		union(5,4);
		for(int i=0; i<7; i++) {
			find(i);
		}
		System.out.println(Arrays.toString(parent));

	}
	
	private static void make(int i) {
		parent[i] = i;
		
	}
	
	private static int find(int i) {
		if(parent[i]==i) return i;
		
		return parent[i]=find(parent[i]);
		
	}
	
	private static void union(int i, int j) {
		
		parent[find(i)] = find(j);
		return;
		
	}

	private static boolean np(int[] list) {
		int n = list.length;
		
		int i=n-1; //꼭대기 찾기
		while(i>0 && list[i-1]>=list[i]) --i;
		if(i==0) return false;
		
		int j=n-1; //꼭대기랑 바꿀 자리 뒤에서 찾기
		while(list[i-1]>=list[j]) --j;
		
		swap(list,i-1,j);
		
		int k=n-1;
		while(i<k) {
			swap(list,i++,k--);
		}
		return true;
	}

	private static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
		
	}

	private static void subSet(int cur) {
		if(cur==6) {
			for(int i=0; i<6; i++) {
				if(visited[i]) {
					System.out.printf("%d ",list[i]);
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
	
	private static void combination(int cur, int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(selec));
			return;
		}
		for(int i=cur; i<6; i++) {
			selec[cnt] = list[i];
			combination(i+1, cnt+1);
		}
	}
	
	private static void permutation(int cnt) {
		if(cnt==3) {
			System.out.println(Arrays.toString(selec));
			return;
		}
		for(int i=0; i<6; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selec[cnt] = list[i];
			permutation(cnt+1);
			visited[i] = false;
		}
	}
	
	
	
}
