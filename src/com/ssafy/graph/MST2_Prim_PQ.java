package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import com.ssafy.graph.MST_Kruskal.Edge;

public class MST2_Prim_PQ {
	
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
	}
	
	//시간 복잡도 O(V^3)
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//데이터 입력 받기
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		ArrayList<Edge>[] adj = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[N];	//노드의 방문 처리
		
		for (int i = 0; i < E; i++) {
			st= new StringTokenizer(in.readLine()," ");
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			int c=Integer.parseInt(st.nextToken());
			adj[a].add(new Edge(a,b,c));
			adj[b].add(new Edge(b,a,c));
		}
		
		//선택된 정점들에서 갈 수 있는 모든 Edge를 저장할 PQ
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		
		int cnt=1;			//선택된 정점 수를 count
		int result = 0;		//MST 값
		
		//선택된 임의의 정점에서 갈 수 있는 모든 정점의 Edge를 PQ에 담기
		queue.addAll(adj[0]); 	//선택한 0번 정점의 모든 edge를 저장
		visited[0]=true;		//0번 정점을 방문 체크
		
		//모든 정점을 반복하면서
		while(cnt!=N) {
			//갈 수 있는 모든 Edge들을 방문하면서 최소 비용의 Edge를 선택
			Edge min = queue.poll();//갈 수 있는 정점의 edge중 최소 edge 추출
			if(visited[min.to]) {
				continue;
			}
			//안 가본 정점중에 최소 edge를 추출했기 때문에
			result+=min.weight;			//선택된 최소 비용을 누적해주기
			//선택한 정점에서 갈 수 있는 모든 Edge를 PQ에 넣기
			queue.addAll(adj[min.to]);
			visited[min.to] =true;	//선택했기 때문에 방문 표시
			cnt++;		//선택한 정점의 count 증가
		}
		System.out.println("min : "+result);

	}

}
