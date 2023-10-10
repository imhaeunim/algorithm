package com.ssafy.problem.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_3124_D4_최소스패닝트리_임하은 {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int Weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.Weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.Weight, o.Weight);
		}
	}
	
	static int V, E;
	static int[] parents;
	static Edge[] EdgeList;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			V = sc.nextInt();
			E = sc.nextInt();
			
			parents = new int[V+1];
			EdgeList = new Edge[E];
			
			for(int i=1; i<=V; i++) {
				makeSet(i);
			}
			
			
			for(int i=0; i<E; i++) {
				EdgeList[i] = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
			}
			
			Arrays.sort(EdgeList);
			
			int count=0;
			long result = 0;
			
			for(Edge edge: EdgeList) {
				if(union(edge.from, edge.to)) {
					result+=edge.Weight;
					if(++count==V-1) {
						break;
					}
				}
			}
			System.out.printf("#%d ",t);
			System.out.println(result);
		}
	}
	
	private static void makeSet(int a) {
		parents[a]=a;
	}
	
	private static int find(int a) {
		if(a==parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA == rootB) return false;
		
		parents[rootB]=rootA;
		return true;
	}
}
