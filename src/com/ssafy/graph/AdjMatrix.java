package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrix {
	static boolean map[][];
	static boolean visited[];	//노드 개수만큼 만들기
	static int N;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/AdjMatrix.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());	//테스트케이스 수
		for(int tc =1; tc<=T; tc++) {
			N = Integer.parseInt(in.readLine());	//노드 수
			map = new boolean[N][N];
			visited = new boolean[N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine()," ");
				for(int j =0; j<N; j++) {
					if(Integer.parseInt(st.nextToken())==1) {
						map[i][j] = true;
					}
				}
			}
			
//			bfs(0);
			dfs(0);
			System.out.println();
		}
	}
	
	private static void dfs(int cur) {
		visited[cur] =true;	//방문체크를 재귀로 메소드에 들어왔을 때 한다.(꺼내올 때 방문처리)
		System.out.printf("%c -> ", cur+'A');
		for(int ad = 0; ad<N; ad++) {
			if(map[cur][ad]&&!visited[ad]) {
				dfs(ad);
			}
		}
	}
	
	private static void bfs(int cur) {
		Queue<Integer> queue = new LinkedList<Integer>();
		//root 노드부터 탐색
		queue.offer(cur);
		visited[cur] =  true; //방문 처리를 미리 안 하면 또 넣음 ->넣을 때 방문처리
		
		while(!queue.isEmpty()) {
			cur = queue.poll(); //현재 방문할 노드 꺼내올게
			System.out.printf("%c -> ",cur + 'A');
			
			//인접된 노드를 탐색
			for(int ad=0; ad<N; ad++) {
				// 인접됐고	방문한 적이 없다면
				if(map[cur][ad]&& !visited[ad]) {
					queue.offer(ad);
					visited[ad] = true;
				}
			}
		}
	}
}
