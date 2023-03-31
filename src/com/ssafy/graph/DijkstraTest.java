package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[][] adjMatrix = new int[V][V];
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int j=0; j<V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		final int INF = Integer.MAX_VALUE;
		int[] distance = new int[V];	//출발 정점에서 자신까지 오는 최소 비용
		boolean[] visited = new boolean[V]; //경우지로 고려된 정점 여부
		
		Arrays.fill(distance, INF);		//최소값 갱신 로직을 반영해야 하므로 큰값으로 초기화
		distance[start] = 0;
		
		int min, current;
		for(int c=0; c<V; c++) {
			//step1 : 경유지로 처리되지 않은 정점 중 출발지에서 가장 가까운 정점 선택
			current=-1;
			min = INF;
			
			for(int i=0; i<V; i++) {
				if(!visited[i]&&min>distance[i]) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current==-1) break;
			visited[current] =true;
			
			//선택된 정점이 문제에서 요구하는 정점이면 끝내기
			//if(current==end) break;
			
			//step2 : 위에서 선택된 정점을 경우지로 해서 갈 수 있는 다른 미방문 인접 정점과의 비용 최소값 갱신
			for(int j=0; j<V; j++) {
				if(!visited[j] && adjMatrix[current][j]!=0 
						&& distance[j]>min+adjMatrix[current][j]) {
					distance[j]=min+adjMatrix[current][j];
				}
			}
			
		}
		System.out.println(distance[end]!=INF? distance[end]:-1);
	}

}
