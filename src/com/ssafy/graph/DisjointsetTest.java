package com.ssafy.graph;

import java.util.Arrays;

public class DisjointsetTest {
	static int[] parents;
	/*
	 * 서로소의 초기화 단계
	 * - 아직  union 하기 전 단계이므로 자기 자신을 부모로 설정한다.
	 * */
	public static void makeSet(int v) {
		parents[v] = v;
	}
	
	
	/*
	 * 원소의 대표 원소를 찾는 기능
	 * @param v : 원소
	 * @return	: 대표자
	 * */
	
	public static int findSet(int v) {
		if(v==parents[v]) {		//root를 찾은 경우
			return v;
		}
		//v가 root가 아니라면 v의 부모를 이용해서 root를 찾으러 간다.
		//문제점 : path가 길어지면 root를 찾는데 시간이 오래 걸림 => path compression 필요
//		return findSet(parents[v]); 
		
		//root를 나의 부모로  => 길었던 path가 무조건 root 아래 원소가 자리잡게 되서 path compression가 됨 
		return parents[v]=findSet(parents[v]);	//root
	}
	
	public static void union(int u, int v) {
		parents[findSet(u)] = findSet(v);	//u의 그룹을 v그룹에 넣기
	}
	

	public static void main(String[] args) {
		int N = 6;
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			makeSet(i);
		}
		
		union(4,3);
		union(6,5);
		union(5,4);
		
		System.out.println((char)(findSet(6)+'a'-1));
		System.out.println((char)(findSet(4)+'a'-1));
		System.out.println(Arrays.toString(parents));
		
	}
}
