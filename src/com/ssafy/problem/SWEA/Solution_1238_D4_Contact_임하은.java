package com.ssafy.problem.SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1238_D4_Contact_임하은 {

	static int[] visited;
	static boolean[][] connected;
	static int N, start;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			visited = new int[101];
			connected=new boolean[101][101];
			N = sc.nextInt();
			start = sc.nextInt();
			for(int i=0; i<N/2; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				connected[from][to] = true;
			}
		
		bfs();
		int max = 0;
		int max_idx=start;
		for(int i=1; i<=100; i++) {
			if(visited[i]>max) {
				max = visited[i];
				max_idx = i;
			}else if(visited[i]==max) {
				max_idx=Math.max(max_idx, i);
			}
		}
		System.out.printf("#%d ",t);
		System.out.println(max_idx);
			
			
			
		}

	}
	
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		int count=1;
		visited[start] = count;
		
		while(!queue.isEmpty()) {
			start = queue.poll();
			for(int i=1; i<=100; i++) {
				if(visited[i]!=0) continue;
				if(connected[start][i]) {
					visited[i] = visited[start]+1;
					queue.offer(i);
				}
			}
		}
	}

}
