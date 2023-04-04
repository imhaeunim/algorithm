package com.ssafy.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Floyd {

	static final int INF = Integer.MAX_VALUE>>2;
	static int N, map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		StringTokenizer st = null;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<N; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(i!=j && map[i][j]==0) {
					// 연결되지 않은 경로이므로 INF로 초기화
					map[i][j]=INF;
				}
			}
		}
		
		for(int k=0; k<N; k++) {	//경유지
			for(int i=0; i<N; i++) {	//출발지
//				if(k==i) continue;	//출발지와 경유지가 같다면 다음 경유지로
				for(int j=0; j<N; j++) { //도착지
					//출발지와 도착지가 같은 경우/ 경유지와 도착지가 같은 경우
//					if(i==j ||k==j) continue;
					//직접 가는 비용이 경유지를 거쳐서 가는 비용보다 크다면
					if(map[i][j] > map[i][k]+map[k][j]) {
						map[i][j] = map[i][k]+map[k][j];
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		
	}

}
