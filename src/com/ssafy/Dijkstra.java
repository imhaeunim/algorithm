package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
 * 
6 11
0 1 4
0 2 2 
0 5 25
1 3 8
1 4 7
2 1 1
2 4 4
3 5 6
4 0 3
4 3 5
4 5 12 
 */
public class Dijkstra {
	
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return w-o.w;
		}
		@Override
		public String toString() {
			return "Edge [v=" + v + ", w=" + w + "]";
		}
		
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		List<Edge>[] adj = new ArrayList[V];
		for(int i=0; i<V; i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0; i<E; i++) {
			adj[sc.nextInt()].add(new Edge(sc.nextInt(),sc.nextInt()));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		for(int i=0; i<V; i++) {
			if(i==0) {
				D[i]=new Edge(i, 0);
			}else {
				D[i]=new Edge(i,Integer.MAX_VALUE);
			}
			pq.add(D[i]);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			for(Edge next: adj[edge.v]) {
				if(!check[next.v]&&D[next.v].w>D[edge.v].w+next.w) {
					D[next.v].w=D[edge.v].w+next.w;
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v]=true;
		}

		System.out.println(Arrays.toString(D));
	}

}
