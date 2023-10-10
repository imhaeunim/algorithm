package com.ssafy.problem.BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1697_S1_숨바꼭질_임하은 {

	static int N, M;
	static boolean[] visited =  new boolean[100001];
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		bfs();
		System.out.println(count);
	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		queue.offer(count);
		while(!queue.isEmpty()) {
			int x=queue.poll();
			count = queue.poll();
			if(x==M) return;
			int temp[] = {x-1, x+1,x*2};
			for(int i=0; i<3; i++) {
				int cx=temp[i];
				if(cx<0||cx>=visited.length) continue;
				if(!visited[cx]) {
					queue.offer(cx);
					queue.offer(count+1);
					visited[cx]=true;
				}
				
			}
			
		}
	}

}
