package com.ssafy.problem.JO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main_2247_bank_도서관_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<Integer>();
		
		int N = sc.nextInt();
		
		int[][] study = new int[N][2]; 
		
		for(int i=0; i<N; i++) {
			study[i][0]=sc.nextInt();
			study[i][1]=sc.nextInt();
		}
		
		Arrays.sort(study,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		stack.push(study[0][0]);
		stack.push(study[0][1]);
		
		for(int i=1; i<N; i++) {
			int end= stack.pop();
//			int start = stack.pop();
			
			if(study[i][0]<=end) {
				if(study[i][1]>end) {
					end = study[i][1];					
				}
				stack.push(end);
				
			}else {
				stack.push(end);
				stack.push(study[i][0]);
				stack.push(study[i][1]);
			}
			
		}
		int full = 0;
		int empty = 0;
		int end = 0;
		int start = stack.peek();
		while(!stack.isEmpty()) {
			
			end =stack.pop();
			if(start-end>empty) {
				empty=start-end;
			}
			start=stack.pop();
			if(end-start>full) {
				full=end-start;
			}
		}
		System.out.printf("%d ",full);
		System.out.print(empty);

	}


}
