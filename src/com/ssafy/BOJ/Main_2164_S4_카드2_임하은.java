package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164_S4_카드2_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int last=2;
		int N = sc.nextInt();
		if(N==1) {
			System.out.println(1);
			return;
		}
		for(int i=1; i<=N; i++) {
			if(i%2==1) continue; //홀수면 버림
			queue.add(i);
		}
		if(N%2==1) { //N이 홀수면 한 사이클 돌고 뒤로 보내기부터 시작
//			if(queue.isEmpty()) return;
			last=queue.poll();
			queue.add(last);
		}
		while(true) {
			if(queue.isEmpty()) break; //비어있으면 끝
			last=queue.poll();	//버리고
			if(queue.isEmpty()) break;
			last=queue.poll();
			queue.add(last);	//뒤로 보내기

		}
		System.out.println(last);
	}

}
