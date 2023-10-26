package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_G4_공유기설치_임하은 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int[] house = new int[N];
		
		for(int i=0; i<N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(house);
		
		int low = 1;
		int high = house[N-1]-house[0];
		
		while(low <= high) {
			int mid = (high+low)/2;
			
			int preInx = 0;
			int count = 1; //첫번째 집에 설치
			
			for(int i=1; i<N; i++) {
				if( house[i] - house[preInx] >= mid) {
					count++;
					preInx = i;
				}
			}
			if(count<C) high = mid-1;
			else low = mid+1;
			
		}


		System.out.println(low-1);
	}

}
