package com.ssafy.problem.JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1277_IM_배낭채우기1_임하은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] v = new int[N+1];
		int[] w = new int[N+1];		
		
		for(int i=1; i<=N; i++) {
			st=new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

//		int[][] dp = new int[N+1][W+1];
		int[] dp = new int[W+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=W; j++) {
				if(w[i]>j) {
//					dp[i][j]=dp[i-1][j];
//					dp[j]=dp[j-w[i]];
					continue;
				}

				dp[j]=Math.max(dp[j], v[i]+dp[j-w[i]]);
			}	
		}

		System.out.println(dp[W]);

	}

}
