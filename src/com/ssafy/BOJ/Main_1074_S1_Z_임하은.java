package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_1074_S1_Z_임하은 {
	static int r,c;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		System.out.println(findNum((int)Math.pow(2, N),0,0,0));
	}
	
	private static int findNum(int len, int x, int y,int sum) {
		int mid = len/2;
		if(mid==0) {
			return sum;
		}
		if(r<x+mid&&c<y+mid) {	//좌상
			return findNum(mid,x,y,sum);
		}else if(r<x+mid && c>=y+mid) {	//우상
			return findNum(mid, x,y+mid, sum+mid*mid);
		}else if(r>=x+mid&&c<y+mid) {	//좌하
			return findNum(mid, x+mid,y,sum+mid*mid*2);
		}else {	//우하
			return findNum(mid, x+mid,y+mid,sum+mid*mid*3);
		}
		
	}

}
