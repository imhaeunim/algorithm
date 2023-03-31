package com.ssafy.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_17406_G4_배열돌리기4_임하은 {
    
    static int N,M,K;
    static int[][] map;
    static int[][] temp;
    static int[][] rcs;

    static int[] per;
    static boolean[] Selected;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        
        map = new int[N][M];
        temp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                map[i][j]=sc.nextInt();
            }
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<M; j++) {
        		temp[i][j]=map[i][j];
        	}
        }


//        for(int i=0; i<N; i++) {
//            System.out.println(Arrays.toString(temp[i]));
//        }
        rcs = new int[K][3];
        for(int i=0; i<K; i++) {
            for(int j=0; j<3; j++) {
                rcs[i][j]=sc.nextInt();
            }    
        }
        
        per=new int[K];
        Selected = new boolean[K];

//        permutation(0);
        turn(3,4,2);
    
        
        
    }
    
    static void permutation(int cnt) {
        if(cnt==K) {
            temp=map.clone();
//            System.out.println(Arrays.toString(per));
            for(int i=0; i<per.length; i++) {
                //turn map
//                temp=map.clone();
                int r =rcs[i][0];
                int c =rcs[i][1];
                int s =rcs[i][2];
                        
                turn(r,c,s);
            }
            
            return;
        }
        
        for(int i=0; i<K; i++) {
            if(!Selected[i]) {
                Selected[i] = true;
                per[cnt]=i;
                permutation(cnt+1);
                Selected[i] = false;    
                
            }
            
        }    
    }
    
    static void turn(int r, int c,int s) {
        int[] dx= {1,0,-1,0};
        int[] dy= {0,1,0,-1};
        int d=0;
        int x1 = r-s-1;
        int y1 = c-s-1;
        int x2 = r+s-1;
        int y2 = c+s-1;
        
        System.out.printf("%d %d %d %d",x1,x2,y1,y2);
        int len=x2-x1+1;
        if(len<=1) {
            //find row
            for(int i=0; i<N; i++) {
                System.out.println(Arrays.toString(temp[i]));
            }
            return;
        }
        
        for(int rec=0; rec<len/2; rec++) {
            int j=len*4-4;
            int xy=temp[x1][y1];
            while(j>0){
                if(x1+dx[d]<x1||x1+dx[d]>x2||
                        y1+dy[d]<y1||y1+dy[d]>y2) {
                    d=(d+1)%4;
                }
                if(x1+dx[d]>=x1&&x1+dx[d]<=x2&&y1+dy[d]>=y1&&y1+dy[d]<=y2) {
                    temp[x1][y1]=temp[x1+dx[d]][y1+dy[d]];
                    x1+=dx[d];
                    y1+=dy[d];
                    j--;                
                }                
            }
            temp[x1][y1-1]=xy;
            x1--;
            x2--;
            y2--;
        }
        
    }
}