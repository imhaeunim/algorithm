package com.ssafy.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158_S4_요세푸스문제_임하은 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		for(int i=1; i<N+1; i++) {
			queue.add(i);
		}
		System.out.printf("<");
		int temp;
		while(true) {
			for(int i=0; i<K-1; i++) { //K전까지는
				queue.add(queue.poll()); //빼내고 다시 넣음
			}
			if(queue.size()==1) {	//만약 사이즈가 1이면 빼고 끝
				temp=queue.poll();
				break;
			}
			temp = queue.peek(); //k번째 : 빼기
			queue.poll();
			System.out.printf("%d, ",temp);
		}
		System.out.print(temp);
		System.out.printf(">");
	}
}
