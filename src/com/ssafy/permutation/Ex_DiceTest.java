package com.ssafy.permutation;

import java.util.Arrays;
import java.util.Scanner;

//입력으로 주사위 던지기 모드를 받는다(1,2,,4)
//던지는 주사위 수도 입력받는다.(1<=N<=10)

public class Ex_DiceTest {
	
	static int N;	//던지는 주사위 수
	static int[] numbers;	//각각의 주사위의 눈
	static int totalCnt;	//경우의 수
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mode = sc.nextInt();
		N = sc.nextInt();
		
		numbers = new int[N];
		
		switch(mode) {
		case 1:
			dice1(0);
			break;
			
		case 2:
			isSelected = new boolean[7];	//자동 초기화 : false
			dice2(0);
			break;
		
		case 3:
			dice3(0,1);
			break;
			
		case 4:
			dice4(0,1);
			break;
		}
		System.out.println("총 경우싀 수 : "+totalCnt);

	}
	
	private static void dice1(int cnt) {	
		//cnt : 기존까지 던져진 주사위 수 => 현재 주사위 수를 기록하기 위한 인덱스로 사용
		
		if(cnt==N) {	//기저조건 : 던져진 주사위가 목표수가 되면 더이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		//주사위의 눈은 1~6
		for (int i =1; i<=6; i++) {
			numbers[cnt]=i;
			//다음 주사위 던지러 가기
			dice1(cnt+1);
		}
	}
	
	private static void dice2(int cnt) {	
		//cnt : 기존까지 던져진 주사위 수 => 현재 주사위 수를 기록하기 위한 인덱스로 사용
		
		if(cnt==N) {	//기저조건 : 던져진 주사위가 목표수가 되면 더이상 던질 주사위 없음
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		//주사위의 눈은 1~6
		for (int i =1; i<=6; i++) {
			//중복 체크
			if(isSelected[i]) continue;
			numbers[cnt]=i;
			isSelected[i]=true;
			//다음 주사위 던지러 가기
			dice2(cnt+1);
			isSelected[i]=false;
		}
	}
	
	private static void dice3(int idx,int put) {
		if(idx==N) {
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		for(int i=put; i<=6;i++) {
			numbers[idx]=i;
			dice3(idx+1,i);
		}
	}	

	private static void dice4(int idx,int put) {
		if(idx==N) {
			System.out.print("완성 : "+Arrays.toString(numbers)+"\n");
			totalCnt++;
			return;
		}
		
		for(int i=put; i<=6;i++) {
			numbers[idx]=i;
//			System.out.println(Arrays.toString(numbers));
			dice4(idx+1,i+1);
		}
	}
}
