package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10971_S2_외판원순회2_임하은 {
	static int N;
	static int[][] map;
	static boolean[] visited;
	static int[] sel;
	static int result=Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		sel = new int[N-1];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation(0);
		System.out.println(result);
	}
	
	private static void permutation(int cnt) {
		if(cnt==N-1) {
//			System.out.println(Arrays.toString(sel));
			result = Math.min(result, cango(sel));
			return;
		}
		
		for(int i=1; i<N;i++) {
			if(visited[i]) continue;
			visited[i]=true;
			sel[cnt]=i;
			permutation(cnt+1);
			visited[i]=false;
		}
	}
	
	private static int cango(int[] sel) {
		if(map[0][sel[0]]==0) {
			return Integer.MAX_VALUE;
		}
		int sum= map[0][sel[0]];
		for(int i=0; i<N-2; i++) {
			if(map[sel[i]][sel[i+1]]==0) {
				return Integer.MAX_VALUE;
			}
			sum+=map[sel[i]][sel[i+1]];
		}
		if(map[sel[N-2]][0]==0) {
			return Integer.MAX_VALUE;
		}
		sum+=map[sel[N-2]][0];
		return sum;
	}

}
