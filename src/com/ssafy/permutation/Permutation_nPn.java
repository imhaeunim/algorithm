package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation_nPn {
	static int N;			//원소 개수
	static int R;			//뽑을 개수
	static int[] numbers;	//뽑은 원소를 저장할 배열 => 순열 배열
	static int testcase;	//순열의 수
	static boolean[] selected;		//N+1개 공간을 이용해서 배열의 index가 뽑을 순열의 숫자. 순열의 사용 여부를 판단.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		numbers =  new int[R];
		selected = new boolean[N+1];
		
		long start = System.currentTimeMillis();
		permutation(0);
		long end = System.currentTimeMillis();
		System.out.printf("%dP%d 순열 개수 :  %d\n",N,R,testcase);
		System.out.printf("dP%d 순열 수행 시간  : %dms\n",N,R,end-start);
		
		System.out.println("===========================");
		start = System.currentTimeMillis();
		permutation2(0,0);
		end = System.currentTimeMillis();
		System.out.printf("%dP%d 순열 개수 :  %d\n",N,R,testcase);
		System.out.printf("dP%d 순열 수행 시간  : %dms\n",N,R,end-start);
		
		System.out.println("===========================");
		start = System.currentTimeMillis();
		permutation1(0);
		end = System.currentTimeMillis();
		System.out.printf("%dP%d 순열 개수 :  %d\n",N,R,testcase);
		System.out.printf("dP%d 순열 수행 시간  : %dms\n",N,R,end-start);

	}
	
	/*
	 * bit mask로 구현
	 * cnt : 뽑은 원소를 저장한 배열의 index
	 * flag : 사용한 수를 1로 유지하는 bit mask flag
	 * */
	private static void permutation2(int cnt, int flag) {
		if(cnt==R) { //0번부터 R-1번까지 순열을 뽑기 때문에 종료
			testcase++;
//			System.out.println(Arrays.toString(numbers));	
			return;
		}
		for(int i=1; i<=N; i++) {
			//bit mask를 잉해서 중복 체크 	1:사용 0:사용하지 않음
			//i 숫자가 이미 사용했는지 여부를 알기 위해 1을 i번 bit 이동시킨 후 & 연산
			if((flag & 1<<i)==0) {
				numbers[cnt] = i;
				//flag|1<<i		i숫자가 순열을 만드는데 사용됐기 때문에 표시
				permutation2(cnt+1, flag|1<<i);
			}
		}
	}
	
	/*
	 * selected로 구현
	 * */
	private static void permutation(int cnt) {
		if(cnt == R) {	//0번부터 R-1번까지 순열을 뽑기 때문에 종료
			testcase ++;
//			System.out.println(Arrays.toString(numbers));	
			return;
		}

		for(int i=1; i<=N; i++) {	//cnt 번째에 올 수 있는 모든 수를 반복해서 뽑자(1~N까지의) 
			if(selected[i]) continue;	//순열 i 숫자가 사용됐는지 체크
			//중복되지 않은 경우, cnt 번째에 i  데이터를 저장
			numbers[cnt] = i;
			selected[i]=true;
			//다음 순열 뽑기
			permutation(cnt+1);
			selected[i]=false;
		}
	}
	
	/*
	 * for문으로 구현
	 * */
	private static void permutation1(int cnt) {
		if(cnt == R) {	//0번부터 R-1번까지 순열을 뽑기 때문에 종료
			testcase ++;
//			System.out.println(Arrays.toString(numbers));	
			return;
		}
		top:
		for(int i=1; i<=N; i++) {	//cnt 번째에 올 수 있는 모든 수를 반복해서 뽑자(1~N까지의) 
			//중복 검사 : 앞자리에서 선택된 수는 배제
			for(int j=0; j<cnt;j++) {
				if(numbers[j]==i) {	//중복된 경우
					continue top;
				}
			}
			//중복되지 않은 경우, cnt 번째에 i  데이터를 저장
			numbers[cnt] = i;
			//다음 순열 뽑기
			permutation1(cnt+1);
		}
	}
	
}
