package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main_17472_G1_다리만들기2_임하은 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N, M;
	static int[][] map, bridge;
	static boolean[][] visited;
	static int num=0;
	
	static class Number{
		int x;
		int y;
		int d;
		int c;
		public Number(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}
	}
	
	
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
	}
	
	
	static int V,E;
	static Edge[] edgeList;
	static int[] parents;
	
	static void makeSet() {
		parents = new int[V];
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}
	static int findSet(int a) {
		if(parents[a]==a) return a;
		
		return parents[a]=findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot==bRoot) return false;
		
		parents[bRoot]=aRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		bridge = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]) continue;
				if(map[i][j]==1) {
					num++;
					Queue<Integer> queue = new LinkedList<Integer>();
					queue.offer(i);
					queue.offer(j);
					map[i][j]=num;
					visited[i][j]=false;
					while(!queue.isEmpty()) {
						int x=queue.poll();
						int y=queue.poll();
						for(int d=0; d<4; d++) {
							int nx=x+dx[d];
							int ny=y+dy[d];
							if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
							if(visited[nx][ny]) continue;
							if(map[nx][ny]==0) continue;
							queue.offer(nx);
							queue.offer(ny);
							visited[nx][ny]=true;
							map[nx][ny]=num;
						}
					}
				}
			}
		}
		
		
		Queue<Edge> pq = new PriorityQueue<Edge>();
		int ii=1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new boolean[N][M];
				if(map[i][j]!=0) {
					Queue<Number> queue = new LinkedList<>();
					int number = map[i][j]; // 섬 번호
					for(int d=0; d<4; d++) {
						int nx = i+dx[d];
						int ny = j+dy[d];
						if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
						visited[nx][ny]=true;
						if(map[nx][ny]!=0) continue;
						queue.offer(new Number(nx,ny,d,1));	
					}
					while(!queue.isEmpty()) {
						Number n = queue.poll();
						int nx=n.x+dx[n.d];
						int ny=n.y+dy[n.d];
						if(nx<0|| ny<0|| nx>=N|| ny>=M) continue;
						if(visited[nx][ny]) continue;
						visited[nx][ny]=true;
						if(map[nx][ny]==0) {
							queue.offer(new Number(nx,ny,n.d,n.c+1));
						}else {
							if(n.c>1) {
								pq.add(new Edge(number-1,map[nx][ny]-1,n.c));
							}
						}
				}
					
					
				}
			}
		}
		
		V=num;
		
		makeSet();
		int result=0, count=0;
		boolean[] check = new boolean[V];
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(union(edge.from, edge.to)) {
				check[edge.from]=true;
				check[edge.to]=true;
				result +=edge.weight;
				if(++count==V-1) break;
			}
		}
		int p = findSet(parents[0]);
		for(int i=1; i<V; i++) {
			if(p!=findSet(parents[i])) {
				result=-1;
				break;
			}
		}
		System.out.println(result);
		
		
	}


}
