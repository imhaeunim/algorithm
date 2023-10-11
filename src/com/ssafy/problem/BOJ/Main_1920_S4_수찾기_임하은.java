package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_S4_수찾기_임하은 {
	
	static int[] listN;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		listN = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<N; i++) {
			listN[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(listN);
		
		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine()," ");
		for (int i=0; i<M; i++) {
			int m = Integer.parseInt(st.nextToken());
			
			sb.append(binarySearch(m, 0, N-1)+"\n");
			
		}
		
		System.out.println(sb);
		
		
	}
	
	private static int binarySearch(int m, int start, int end) {
		
		if(start>end) {
			return 0;
		}
		
		int mid = (start + end) / 2;
		
		if(listN[mid]<m) {
			return binarySearch(m, mid+1, end);
		}
		else if(listN[mid]>m) {
			return binarySearch(m, start, mid-1);
		}
		else {
			return 1;
		}
		
	}

}
