package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class MST2_Prim1 {

	//시간 복잡도 O(V^3)
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//데이터 입력 받기
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		boolean[] visited = new boolean[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st= new StringTokenizer(in.readLine()," ");
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//선택된 정점을 저장하는 list
		ArrayList<Integer> selected = new ArrayList<>(N);
		int index;
		int min;		//갈 수 있는 Edge 중에서 최소값
		int result = 0;		//MST 값
		
		//임의의 정점 하나 선택
		selected.add(0);
		visited[0]=true;
		
		//모든 정점을 반복하면서
		for (int i = 0; i < N-1; i++) {	//임의의 정점을 하나 선택했기 때문에 N-1 반복
			min = Integer.MAX_VALUE;
			index = 0;
			
			//갈 수 있는  모든 Edge들을 반복하면서 최소 비용의 Edge를 선택
			//1.선택한 정점을 반복하면서
			for(Integer v : selected) {
				//2. 인접된 노드 중에 안 가본 노드 중 최소 비용을 찾기
				for(int j=0; j<N; j++) {
					if(map[v][j]!=0 && !visited[j] && map[v][j]<min) {
						min=map[v][j];
						index = j;
					}
				}
			}
			
			//최소 비용의 노드를 찾았다면 해당 노드 방문 표시하고, 선택한 노드 처리, 최소값 갱신
			result+=min;			//선택된 최소 비용을 누적해주기
			selected.add(index);	//최소 값으로 선택된 정점
			visited[index] =true;	//선택했기 때문에 방문 표시
			
		}
		System.out.println("min : "+result);
		System.out.println(selected);

	}

}
