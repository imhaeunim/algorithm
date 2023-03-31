package com.ssafy.recursive;

import java.util.Scanner;

public class RecursiveCallTest2 {
	static int N;
	static int start = 1;
	
//	//up -> down
//	public static int sum1(int n) {
//		if(n>1) return n*sum1(n-1);
//		return n;
//	}
//	public static int sum2(int n) {
//		if(n==1) return n;
//		return n*sum2(n-1);
//	}
//	//down -< up
//	public static int sum3(int n) {
//		if(n<N) return n*sum3(n+1);
//		return n;
//	}
//	public static int sum4(int n) {
//		if(n==N) return n;
//		return n*sum4(n+1);
//	}
	
	public static int fib1(int n) {
		if(n==2 ||n==1) return 1; //if(n<3)
		return fib1(n-1)+fib1(n-2);
	}
	public static int fib2(int n) {
		if(n>2) return fib2(n-1)+fib2(n-2);
		return 1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println(fib1(N));
		System.out.println(fib2(N));
		
//		System.out.println(sum1(N));
//		System.out.println(sum2(N));
//		System.out.println(sum3(1));
//		System.out.println(sum4(1));
		
//		int fac = 1;
//		for (int i = 1; i <=N; i ++) {
//			fac *= i;
//		}
//		System.out.printf(" 1부터 %d까지의 factorial : %d%n",N,fac);
//		
//		fac = 1;
//		for (int i = N; i >1; i --) {
//			fac *= i;
//		}
//		System.out.printf(" 1부터 %d까지의 factorial : %d%n",N,fac);
	}
}
