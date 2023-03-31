package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_bit {
	static int N;			//원소 개수
	static int R;			//뽑을 개수
	static int[] numbers, input;	//뽑은 원소를 저장할 배열 => 순열 배열
	static boolean[] isSelected;		//N+1개 공간을 이용해서 배열의 index가 뽑을 순열의 숫자. 순열의 사용 여부를 판단.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers =  new int[R];
		input = new int[N];
		isSelected = new boolean[N+1];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
//		permutation(0);
		permutationBit(0, 0);


	}
	
	private static void permutation(int cnt) {
		if(cnt ==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			numbers[cnt] = input[i];
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	private static void permutationBit(int cnt, int flag) {
		if(cnt ==R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((flag&(1<<i))!=0) continue;
			numbers[cnt] = input[i];

			permutationBit(cnt+1,flag|(1<<i));

		}
		
	}


	


}
