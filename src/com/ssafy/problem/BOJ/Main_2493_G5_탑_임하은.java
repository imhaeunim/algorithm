package com.ssafy.problem.BOJ;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main_2493_G5_탑_임하은 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();	
		int N = sc.nextInt();
		int[] KOI = new int[N];
		Stack<Integer> out = new Stack<>();

		for(int i=0; i<N; i++) {
			KOI[i]=sc.nextInt();
		}
		for(int i=N-1; i>=0; i--) {
			int temp=0;
			for(int j=i-1; j>=0; j--) {
				if(KOI[i]<KOI[j]) {
					out.push(j+1);
					temp=1;
					break;
				}
			}
			if(temp==0) {
				out.push(0);
			}
		}
		for(int i=0; i<N; i++) {
			sb.append(out.pop()+" ");
//			System.out.printf("%d ",out.pop());
		}
		System.out.println(sb);
		
//		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//
//		Stack<Integer> stack = new Stack<>();
//		for(int i=0; i<N; i++) {
//			stack.push(sc.nextInt());
//		}
//		
//		Stack<Integer> temp = new Stack<>();
//		for(int i=0; i<N; i++) {
//			int check=stack.pop();
//			int top = stack.peek();
//			for(int j=0; j<N-j-1; j++) {
//				if(top<check) {
//					temp.push(stack.pop());
//					for(int t =0; t<temp.size();t++) {
//						stack.push(temp.pop());
//					}
//				}
//				if(stack.isEmpty()) {
//					for(int t =0; t<temp.size();t++) {
//						stack.push(temp.pop());
//					}
//				}
//			}
//			
//		}
//		for(int i=0; i<N; i++) {
//			System.out.printf("%d ",temp.pop());
//		}
		
	}
}
