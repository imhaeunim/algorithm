package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *NextPermutation
	nPn 만들기, nPr은 못 만듦
	현재 순열 상태에서 사전순(오름차순)으로 나열했을 때, 다음 단계의 순열을 생성
   	⇒ 가장 작은  순열에서 시작해서 가장 큰 순열을 만들면 끝
 * */

public class PermutationNPTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
//		int[] input = new int[N];
//		
//		for(int i=0; i<N; i++) {
//			input[i] = sc.nextInt();
//		}
		int[] input = new int[] {1,2,3,4,5};
		
		//전처리 : 오름차순 정렬
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while (np(input));
	}

	private static boolean np(int[] input) {
		
		int n = input.length;
		//step1. 뒤쪽부터 꼭대기를 찾는다. (꼭대기 바로 앞이 교환할 자리)
		int i = n-1;
		while(i>0 && input[i-1]>=input[i]) --i;
		if(i==0) return false; //가장 큰 순열을 만들었기 때문에 false로 종료
		
		//step2. 꼭대기 바로 앞(i-1) 자리에 교환할 값을 뒤쪽부터 찾는다.
		int j = n-1;
		while(input[i-1]>=input[j]) --j;
		
		//step3. 꼭대기 바로 앞(i-1) 자리와 그 자리 값보다 한 단계 큰 자리 (j) 수와 교환
		swap(input, i-1, j);
		
		//step4. 꼭대기부터 맨 뒤까지 오름차순으로 정렬
		int k = n-1;
		while(i<k) {
			swap(input,i++,k--);
		}
		
		return true;
	}
	
	private static void swap(int[] input, int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

}
