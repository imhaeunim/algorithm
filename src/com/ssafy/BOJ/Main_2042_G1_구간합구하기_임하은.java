package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2042_G1_구간합구하기_임하은 {
	
	static int N;
	static long[] tree;
	static long[] nums;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		nums = new long[N];
		tree = new long[N+1];
		for(int i=0; i<N; i++) {
			nums[i]=Long.parseLong(br.readLine());
		}
		
		for(int i=1; i<=N; i++) {
			update(i,nums[i-1]);
		}
		
		
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a==1) { //b번째 수를 c로 바꾸기
				change(b,c);
				nums[b-1]=c;
				continue;
			}else { //b번부터 c번까지 수의 합 출력
				System.out.println(subSum((int)c, b-1));
			}
		}
		
	}
	
	/**
	 * 입력 값으로  tree를 구성하는 함수
	 * 
	 */
	public static void update(int i, long num) {
		while(i<N+1) {
			tree[i] +=num;
			i+=(i & -i); //다음 위치에 데이터를 update 		다음 update할 위치 => index+k
		}
	}
	
	public static void change(int i, long num) {
		long pre = nums[i-1];
		while(i<N+1) {
			tree[i] -=pre;
			tree[i] +=num;
			i+=(i & -i);
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
	public static long subSum(int a, int b) { // 큰 거, 작은 거
		return (sum(a)-sum(b));
	}
	
}
