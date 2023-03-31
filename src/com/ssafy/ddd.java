package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;


public class ddd {
	
	static int[] number = {1,2,3,4,5};
	static int[] temp;
	static boolean[] selected;
	static int n;
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		n= sc.nextInt();
		temp=new int[n];
		selected=new boolean[5];
//		permutation(0);
//		combination(0, 0);
		subset(0);
		

	}
	private static void subset(int cur) {
		if(cur==number.length) {
			for(int i=0; i<number.length; i++) {
				if(selected[i]) {
					System.out.printf("%d ",i);
				}
			}
			System.out.println();
			return;
		}
		
		selected[cur]=false;
		subset(cur+1);
		selected[cur]=true;
		subset(cur+1);
	}
	
	private static void permutation(int cnt) {
		if(cnt==n) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		for(int i=0; i<number.length; i++) {
			if(selected[i]==true)  continue;
			selected[i]=true;
			temp[cnt]=number[i];
			permutation(cnt+1);
			selected[i]=false;
		}
	}
	
	private static void combination(int cur, int cnt) {
		if(cnt==n) {
			System.out.println(Arrays.toString(temp));
			return;
		}
		
		for(int i=cur; i<number.length; i++) {
			temp[cnt]=number[i];
			combination(i+1, cnt+1);
		}
	}
	
	
//	private static void permutation(int cnt) {
//		if(cnt==n) {
//			System.out.println(Arrays.toString(temp));
//			return;
//		}
//		
//		for(int i=0; i<5; i++) {
//			if(!selected[i]) {
//				temp[cnt]=number[i];
//				selected[i]=true;
//				permutation(cnt+1);
//				selected[i]=false;
//			}
//		}
//	}
	
//	private static void combination(int start, int cnt) {
//		if(cnt==n) {
//			System.out.println(Arrays.toString(temp));
//			return;
//		}
//		for(int i=start; i<5; i++) {
//			temp[cnt]=number[i];
//			combination(i+1, cnt+1);
//		}
//		
//	}
	
//	private static void subset(int cur) {
//		if(cur==5) {
//			System.out.println(Arrays.toString(temp));
//			return;
//		}
//		selected[cur]=true;
//		subset(cur+1);
//		selected[cur]=false;
//		subset(cur+1);
//	}

}
