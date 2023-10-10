package com.ssafy.problem.SWEA;

import java.util.Scanner;

public class Solution_2001_D2_파리퇴치_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		
		for(int t=1; t<=test; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map= new int[N][N];
			int[][] sub=new int[M][M];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j]=sc.nextInt();					
				}
			}

			
			int max=0;
			for(int i=0; i<N-M+1; i++) {	//map 내에서 파리채 움직이ㅣ
				for(int j=0; j<N-M+1; j++) {
					int sum=0;
					//파리채 합 구하기
					for(int x=0; x<M; x++) { //파리채 행
						for(int y=0; y<M; y++) {	//파리채 열
							sum+=map[i+x][j+y]; //map에서 i를 기준으로 파리채의 크기M 더해줌
						}
					}
					if(sum>max) {
						max=sum;
					}
					
				}
			}
			
			System.out.printf("#%d ",t);
			System.out.println(max);
			
			
			
		}

	}

}
