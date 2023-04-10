package com.ssafy.tree;

import java.util.Arrays;

public class FenwickTree {
	
	static int N;
	static int[] tree;
	public static void main(String[] args) {
//		int[] nums = {3,5,2,4,0,8,1,5,3,4,1,0,6,7,7,3}; 
		int[] nums = {1,2,3,4,5};
		N = nums.length;
		tree = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			update(i,nums[i-1]);
		}
		
		System.out.println(Arrays.toString(tree));
		System.out.println(sum(5));
		System.out.println(sum(3));
		System.out.println(subSum(5,3));
	}
	
	/**
	 * 입력 값으로  tree를 구성하는 함수
	 * 
	 */
	public static void update(int i, int num) {
		while(i<N+1) {
			tree[i] +=num;
			i+=(i & -i); //다음 위치에 데이터를 update 		다음 update할 위치 => index+k
		}
	}
	
	/**
	 * 1~N 까지 구간 합 구하기
	 */
	public static long sum(int i) {
		long ans = 0;
		while(i>0) {
			ans+=tree[i];
			i-=(i&-i);	//이전 구간의 합이 있는 위치로 이동		이전 구간합이 있는 위치 => index-k
		}
		return ans;
	}
	
	/**
	 * start~end 까지의 구간 합 구하기
	 */
	public static long subSum(int a, int b) {
		return (sum(a)-sum(b));
	}
	
}
