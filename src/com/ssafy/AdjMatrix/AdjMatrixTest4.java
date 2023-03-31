package com.ssafy.AdjMatrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest4 {
	static int V;
	static ArrayList<Integer>[] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix =  new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			adjMatrix[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for(int i=0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			adjMatrix[from].add(to);
			adjMatrix[to].add(from);
		}
		bfs(0);
	}
	private static void bfs(int start) {
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		
		int current = 0;
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println((char)(current+65));
			
			for(int vertex:adjMatrix[current]) {
				if(!visited[vertex]) {
					queue.offer(vertex);
					visited[vertex] = true;
				}
			}
		}
	}

}
