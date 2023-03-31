package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_5644_모의_무선충전_임하은 {
	static int M,A;
	static int[] user1, user2;
	static int[][] bc;
	static int[] dx = {0,-1,0,1,0}; //제자리,상, 우 , 하 , 좌
	static int[] dy = {0,0,1,0,-1};
	static int max=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		for(int t=1; t<=T; t++) {
			max=0;
			M = sc.nextInt();
			A = sc.nextInt();
			user1 = new int[M];
			user2 = new int[M];
			for(int i=0; i<M; i++) {
				user1[i]=sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				user2[i]=sc.nextInt();
			}
			
			bc = new int[A][4];
			for(int i=0; i<A; i++) {
				for(int j=0; j<4; j++) {
					bc[i][j]=sc.nextInt(); //x,y 바꿔서 담김
				}
			}
			Arrays.sort(bc,(o1,o2)->{
				return o2[3]-o1[3];
			});
			charge(0, 0, 9, 9);
			System.out.printf("#%d ",t);
			System.out.print(max);
			System.out.println();
			
		}

	}
	private static void charge(int x1, int y1, int x2, int y2) {
		int cx1=0, cy1=0, cx2=9, cy2=9;
		find_charge(x1, y1, x2, y2);
		for(int i=0; i<M; i++) {
			cx1+=dx[user1[i]];
			cy1+=dy[user1[i]];
			cx2+=dx[user2[i]];
			cy2+=dy[user2[i]];
			
			find_charge(cx1, cy1, cx2, cy2);
		}
	}
	private static void find_charge(int x1, int y1, int x2, int y2) {
		int Amax = 0;
		int Bmax = 0;
		boolean Acount=false; //A와 겹친 BC를 더해준 경우
		boolean Bcount=false; //B와 겹친 BC를 더해준경우
		int count=0; //총 더해준 경우
		for(int i=0; i<A; i++) {
			if(count==2) return;
			if(Math.abs(x1-(bc[i][1]-1))+Math.abs(y1-(bc[i][0]-1))<=bc[i][2]) {
				if(!Acount){ //이미 A를 더하지 않았다면
					Amax=bc[i][3];
				}
			}
			if(Math.abs(x2-(bc[i][1]-1))+Math.abs(y2-(bc[i][0]-1))<=bc[i][2]) {
				if(!Bcount) { //이미 B를 더하지 않았다면
					Bmax=bc[i][3];
				}
				
			}
		
			if(Amax!=0 && Amax==Bmax) { //만약 같은 BC를 넣는다면
				max+=Amax;
				Amax=0; Bmax=0;
				count++;
				continue;
			}
			if(Amax>0||Bmax>0) {
				if(Amax>0) {
					max+=Amax;
					Acount=true; //A가 또 담지 못하게
					count++;
				}else {
					max+=Bmax;
					Bcount=true; //B
					count++;
				}
				Amax=0; Bmax=0;
			}
			
		}
		
	}

}
