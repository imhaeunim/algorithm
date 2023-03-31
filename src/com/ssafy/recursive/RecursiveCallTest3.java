package com.ssafy.recursive;

public class RecursiveCallTest3 {
	
	public static int fibo1(int n) {
		if(n<=2) return 1;
		return fibo1(n-1)+fibo1(n-2);
	}
	public static int fibo2(int n) {
		if(n>2) return fibo1(n-1)+fibo1(n-2);
		return 1;
	}
	
	
	public static void main(String[] args) {
		int n=7	;
		System.out.printf("%d번째 피보나치 순열 : %d\n",n,fibo1(n));
		System.out.printf("%d번째 피보나치 순열 : %d\n",n,fibo2(n));
		
		int[] memo = new int[n+1];
		memo[1]=1;
		memo[2]=1;
		for (int i=2; i<=n; i++) {
			memo[i]=memo[i-1]+memo[i-2];
		}
		System.out.printf("%d번째 피보나치 순열 : %d\n",n,memo[n]);
	}

}
