package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_1954_D2_달팽이숫자_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test = 1; test<=T; test++) {
			int N = sc.nextInt();
			int[][] map = new int[N][N];
			int x=0;	//지금 인덱스
			int y=0;	//지금 인덱스
			map[0][0]=1;
			int num=2; //넣을 수 : 2부터 시작할 거야
			int[] dr = {0,1,0,-1};	//가는 방향(우,하,왼,상)
			int[] dc = {1,0,-1,0};	//가는 방향 
			int d =0; //지금 방향
			while(true) {
				if(num==N*N+1) { //숫자 다 넣으면 끝!
					break;
				}
				if(x+dr[d]>=0 && x+dr[d]<N && y+dc[d]>=0 && y+dc[d]<N){	//다음 인덱스가 범위가 넘어가지 않으면
					if(map[x+dr[d]][y+dc[d]]==0) {	//처음 온 곳이라면
						map[x+dr[d]][y+dc[d]]=num;	

						x+=dr[d];	//인덱스 이동
						y+=dc[d];	
						num++;	//넣을 수 증가
					}else {	//이미 방문한 곳이라면 방향 바꾸기
						d=(d+1)%4; //가는 방향 바꿔주기 (0,1,2,3)

					}
				}else {	//지도를 벗어난다면 방향 바꾸기
					d=(d+1)%4;
				}
			}
			System.out.printf("#%d\n",test);
			for(int i =0; i<N;i++) {
				for(int j=0; j<N; j++) {
					System.out.printf(map[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}

}
