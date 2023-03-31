package com.ssafy.recursive;

public class RecursiveCallTest1 {
	/**Top -> down
	 * 
	 * @param n
	 * @return
	 * */
	static int N=10;
	public static int sum1(int n) {
		if(n==1)return 1;
		return n+sum1(n-1);
	}
	
	/**Top -> down
	 * 
	 * @param n
	 * @return
	 * */
	public static int sum2(int n) {
		if (n>1) return n+sum2(n-1);
		return 1;
	}
	
	/**
	 * Button -> up
	 * */
	public static int sum3(int n) {
		if(n==N) return N;
		return n+sum3(n+1);
	}
	
	/**
	 * Button -> up
	 * */
	public static int sum4(int n) {
		if (n<N) return n+sum4(n+1);
		return N;
	}
	
	public static void main(String[] args) {
		System.out.println("Button -> up : sum -"+sum1(N));
		System.out.println("Button -> up : sum -"+sum2(N));
		System.out.println("Button -> up : sum -"+sum3(1));
		System.out.println("Button -> up : sum -"+sum4(1));
		int sum = 0;
		for (int i=1; i<=N; i ++) {
			sum +=i;
		}
		System.out.println("Button -> up : sum -"+sum);
		
		sum = 0;
		for(int i =N; i>0; i--) {
			sum +=i;
		}
		System.out.println("Top -> down : sum -"+sum);
	}

}
