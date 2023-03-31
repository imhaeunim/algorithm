package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution_5658_모의_보물상자비밀번호_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {

			ArrayList<Integer> make = new ArrayList<>();
			ArrayList<Integer> dicMake = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] number = new int[N];
			String input = br.readLine();
			for(int i=0; i<N; i++) {
				number[i] = Integer.parseInt(String.valueOf(input.charAt(i)),16);
			}
			
			for(int r=0; r<3; r++) {
				int sub_n= N/4;
				for(int i=1; i<=4; i++) {
					int makeNumber=0;
					int hex=1;
					for(int j=1; j<=sub_n; j++) {
						System.out.println(i*sub_n-j);
						System.out.println(number[i*sub_n-j]);
						makeNumber+=((int)number[i*sub_n-j])*hex;
						hex *=16;
					}
					System.out.println();
					make.add(makeNumber);
					
	
				
				}
				
				int temp = number[N-1];
				for(int j=0; j<N-1; j++) {
					number[j]=number[j+1];
				}
				number[0]=temp;
			}
			
			for(int m: make) {
				if(!dicMake.contains(m)) {
					dicMake.add(m);
				}
			}
			System.out.println(dicMake);
			Collections.sort(dicMake);
			sb.append("#").append("t").append(" ").append(dicMake.get(K-1)).append("\n");
		}
		System.out.println(sb);
	}

}
