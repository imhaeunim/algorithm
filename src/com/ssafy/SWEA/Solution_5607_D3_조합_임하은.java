package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_D3_조합_임하은 {

	static long p = 1234567891;
	static int N,R;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long N = Integer.parseInt(st.nextToken());
			long R = Integer.parseInt(st.nextToken());
			
			long result = 1;

			long sub=fac(N);
			result = sub%p;
			
			sub=fac(R);
			sub=power(sub,p-2)%p;
			result*=sub;
			result=result%p;
			
			sub=fac(N-R);
			sub=power(sub,p-2)%p;
			result*=sub;
			result=result%p;
			
			System.out.println("#"+t+" "+result);
		}
		

	}
	
	static long fac(long n) {
		long sum = 1L;
		for(int i=(int)n; i>0; i--) {
			sum*=i;
			sum=sum%p;
		}
		return sum;
	}
	
	static long power(long x, long y) {
		long sum = 1L;
		
		while(y>0) {
			if(y%2==1) sum =(sum*x)%p;
			y=y>>1;
			x=(x*x)%p;
		}
		
		return sum;
	}
	
}
