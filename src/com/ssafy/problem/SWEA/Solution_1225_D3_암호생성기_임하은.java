package com.ssafy.problem.SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_D3_암호생성기_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			sc.next();
			Queue<Integer> queue = new LinkedList<>();
			for(int i=0; i<8; i++) {
				queue.add(sc.nextInt());
			}
			int num=1;
			while(true) {
				int n=0;
				if(num==6) num=1; //1~5까지 반복
				n=queue.poll()-num;	//조건에 맞게 수 조작
				if(n>0) {
					queue.add(n);
					num++;
				}else {			//프로그램 종료
					queue.add(0); 
					break;
				}
				
			}
			System.out.printf("#%d",t);
			for(int i=0; i<8; i++) {
				System.out.print(" "+queue.poll());
			}
			System.out.println();
			
		}

	}

}
