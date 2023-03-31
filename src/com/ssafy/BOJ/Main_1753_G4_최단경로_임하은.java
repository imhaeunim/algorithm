package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1753_G4_최단경로_임하은 {

	static public class Edge{
		int to;
		int weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		boolean[] visited = new boolean[V];
		int[] distance = new int[V];
		
		Arrays.fill(distance,Integer.MAX_VALUE);

		int start = Integer.parseInt(br.readLine())-1;
		ArrayList<Edge>[] adj = new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			adj[i]=new ArrayList<>();
		}
		
		for(int i=0; i<E; i++) {
			st=new StringTokenizer(br.readLine()," ");
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			int k = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v,k));
		}

		distance[start] = 0;
		
		int INF = Integer.MAX_VALUE;
		
		for(int c=0; c<V; c++) {
			int min = INF;
			int idx=-1;
			
			for(int i=0; i<V; i++) {
				if(!visited[i]&&min>distance[i]) {
					min = distance[i];
					idx = i;
				}
			}
			
			if(idx==-1) break;
			visited[idx]=true;
			
			for(Edge edge: adj[idx]) {
				if(!visited[edge.to] && edge.weight!=0 && distance[edge.to]>min+edge.weight) {
					distance[edge.to] = min+edge.weight;
				}
			}
		}
		
		for(int i=0; i<V; i++) {
			sb.append(distance[i]==INF? "INF": distance[i]);
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	
}
