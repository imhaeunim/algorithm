package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15961_G4_회전초밥_임하은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list= new int[N];
		int[] pick= new int[k];
		int[] eat = new int[d+1];
		
		for(int i=0; i<N; i++) {
			list[i]=Integer.parseInt(br.readLine());
		}
		
		int count=0;
		for(int i=0; i<k; i++) {
			pick[i]=list[i];
			if(eat[pick[i]]==0) count++;
			eat[pick[i]]++;
		}
		int max=count;
		int start=k; //start%8
		int idx=0;
		for(int i=0; i<N; i++) {
			eat[pick[idx]]--;
			if(eat[pick[idx]]==0) count--;
			pick[idx]=list[start];
			if(eat[pick[idx]]==0) count++;
			eat[pick[idx]]++;
			if(eat[c]==0) {
				count++;
				max=Math.max(max, count);
				count--;
			}else {
				max=Math.max(max, count);
			}
			
			start=(start+1)%N;
			idx=(idx+1)%k;
		}
		System.out.println(max);

	}

}
