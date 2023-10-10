package com.ssafy.problem.SWEA;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_1228_D3_암호문1_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int t=1; t<=10;t++) {
			LinkedList<Integer> password =  new LinkedList<Integer>();	//linkedList 생성
			int N = sc.nextInt();
			for(int i =0; i<N; i++) {
				password.add(sc.nextInt());	//linkedList 입력
			}
			
			N = sc.nextInt();
			for(int i =0; i<N; i++) {
				sc.next();
				int idx = sc.nextInt();
				int num = sc.nextInt();
				for(int j = 0; j<num; j++) {
					password.add(idx,sc.nextInt());	//원하는 자리에 넣어주기
					idx++;
				}
			}
			System.out.printf("#%d",t);
			for(int i = 0; i<10; i++) {
				System.out.printf(" "+password.get(i));
			}
			System.out.println();
		}	
	}
}
