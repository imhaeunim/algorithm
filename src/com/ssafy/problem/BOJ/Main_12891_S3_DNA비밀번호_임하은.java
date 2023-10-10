package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;



public class Main_12891_S3_DNA비밀번호_임하은 {

	public static void main(String[] args) throws IOException{

		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();	
//		String[] text=bf.readLine().split(" ");
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		
		
		String[] TempDNA =br.readLine().split("");  
//		System.out.println(Arrays.toString(TempDNA));
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
//		System.out.printf("%d, %d, %d, %d",A,C,G,T);
		int password = 0;
	
		for(int i =0; i<S-P+1; i++) {
			int[] count= {0,0,0,0};
			int a=0;
			int c=0;
			int g=0;
			int t=0;
			for(int j=0; j<P;j++) {
				if(TempDNA[i+j].equals("A")) {
					count[0]++;
				}else if(TempDNA[i+j].equals("C")) {
					count[1]++;
				}else if(TempDNA[i+j].equals("G")) {
					count[2]++;
				}else{
					count[3]++;
				}
//				if(count[0]>=A && count[1]>=C
//						&& count[2]>=G && count[3]>=T) {
//					password++;
//					break;
//				}
				if(a==A && c==C && g==G && t==T) {
					password++;
					break;
				}
			}
		}
		sb.append(password);
		System.out.println(sb.toString());

	}
}
