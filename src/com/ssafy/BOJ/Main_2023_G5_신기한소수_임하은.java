package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_2023_G5_신기한소수_임하은 {
	static int N;
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    int start=(int)Math.pow(10, N-1)*2;	//N자리수 가장 작은 값: 앞자리 2부터 시작
	    int end=(int)Math.pow(10, N)-1;		//N자리수 가장 큰 값
	    for(int i=start*2; i<=end; i++) {
	    	findNumber(i,N-1);
	    }
	}
	
	static void findNumber(int n,int idx) {	//한 자리씩 잘라서 소수 체크
		if(idx<0) {
			System.out.println(n);
			return;
		}
		if(checkNumber(n/(int)Math.pow(10, idx))) { //소수인지 체크
			findNumber(n,idx-1);			//숫자 하나 더 추가
		}else return;
	}
	static boolean checkNumber(int n) {
		for(int i=2; i<=Math.sqrt(n);i++) {	//2부터 제곱근까지만 검사하면 됨
			if(n%i==0) {
				return false;				//나머가 없으면 소수가 아니다
			}
		}
		return true;	//다 딱 떨어지게 나눠지지 않았기 때문에 소수다.
	}
}