package com.ssafy.live04;

import java.util.Scanner;

public class SubSetSumTest {

	static int N, S, totalCnt;
	static int[] input;	// 입력 받은 수들
	static boolean[] isSelected;	//각 원소가 부분집합의 구성에 포함되어 있는지 여부
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i = 0; i<N; i++) {
			input[i]=sc.nextInt();
		}
		generateSubSet(0,0);
		System.out.println("총 경우의 수 : "+totalCnt);
	}
	
//	private static void generateSubSet(int cnt) { //직전까지 고려된 원소 수
//		
//		if(cnt == N) {
//			// 부분집합의 요소들의 합 구하기
//			int sum = 0;
//			for(int i =0; i<N; i++) {
//				if(isSelected[i]) sum+=input[i];
//			}
//			if(sum==S) {
//				totalCnt++;
//				for (int i = 0; i < input.length; i++) {
////					System.out.print((isSelected[i]?input[i]:"X")+"\t");
//					if(isSelected[i])System.out.print(input[i]+"\t");
//				
//				}
//				System.out.println();
//			}
//			return;
//		}
//		
//		//현재 원소를 부분집합의 구성에 포함
//		isSelected[cnt] =  true;
//		generateSubSet(cnt+1);
//		
//		//현재 원소를 부분집합의 구성에 비포함
//		isSelected[cnt] = false;
//		generateSubSet(cnt+1);
//	}
	
	private static void gen(int cnt) {
		
		if(cnt==N) {
	//		System.out.println();
			return;
		}
		
		isSelected[cnt]=true;
		gen(cnt +1);
		isSelected[cnt]=false;
		gen(cnt+1);
	
	}
	
	
	
	
	
	
	
	
	
	private static void generateSubSet(int cnt, int sum) {	//cnt : 직전까지 고려된 원소 수
														//sum  :직전가지 선택된 원소들의 합
		
		if(cnt == N) {
			// 부분집합의 요소들의 합 구하기
			if(sum==S) {
				totalCnt++;
				for (int i = 0; i < input.length; i++) {
//					System.out.print((isSelected[i]?input[i]:"X")+"\t");
					if(isSelected[i])System.out.print(input[i]+"\t");
				
				}
				System.out.println();
			}
			return;
		}
		
		//현재 원소를 부분집합의 구성에 포함
		isSelected[cnt] =  true;
		generateSubSet(cnt+1,sum+input[cnt]);
		
		//현재 원소를 부분집합의 구성에 비포함
		isSelected[cnt] = false;
		generateSubSet(cnt+1,sum);
	}
}
