package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3307_D3_최장증가부분수열_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test = Integer.parseInt(br.readLine());
		for(int t=1; t<=test; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] dp= new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				arr[i]=Integer.parseInt(st.nextToken());
			}
			
			int max=0;
			for(int i=0; i<N; i++) {
				dp[i]=1;
				for(int j=0; j<i; j++) {
					if(arr[i]<arr[j]) continue;
					dp[i]=Math.max(dp[i],dp[j]+1);
				}
				max = Math.max(max, dp[i]);
			}
			System.out.printf("#%d %d\n",t,max);
			
		}

	}

}
