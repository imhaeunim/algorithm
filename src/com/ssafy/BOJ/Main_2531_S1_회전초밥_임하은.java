package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2531_S1_회전초밥_임하은 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] list= new int[N];
		int[] pick= new int[k];
		boolean[] eat = new boolean[d+1];
		
		for(int i=0; i<N; i++) {
			list[i]=Integer.parseInt(br.readLine());
		}
		
		for(int i=0; i<k; i++) {
			pick[i]=list[i];
			eat[list[i]]=true;
		}
		
		eat[d]=true;
		int count=0;
		for(int i=0; i<=d; i++) {
			if(eat[i]) count++;
		}
		int max=count;
		System.out.println(max);
		
		int start=k; //start%8
		int idx=0;
		for(int i=0; i<N; i++) {
			eat[pick[idx]]=false;
			eat[d]=true;
			eat[list[start]]=true;
			pick[idx]=list[start];
			count=0;
			for(int j=0; j<=d; j++) {
				if(eat[j]) count++;
			}
			max=Math.max(max, count);
			start=(start++)%8;
			idx=(idx++)%4;
		}
		System.out.println(max);

	}

}
