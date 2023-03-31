package com.ssafy.SWEA;

import java.util.Scanner;


public class Solution_1861_D4_정사각형방_임하은 {
    static int N;
    static int[][] map;
    static int[][] root;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Test = sc.nextInt();
        for(int t=1; t<=Test; t++) {
             
             
            N = sc.nextInt();
            map=new int[N][N];
            root=new int[N][N];
            visited = new boolean[N][N];
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j]=sc.nextInt();
                }
            }
             
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    dfs(i,j,1,i,j);
                }
            }
             
             
            int max=0;
            int mx = 0, my=0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(root[i][j]>max) {
                        max=root[i][j];
                        mx=i;
                        my=j;
                    }if(root[i][j]==max) {
                        if(map[i][j]<map[mx][my]) {
                            mx=i;
                            my=j;
                        }
                    }
                }
            }
             
            System.out.printf("#%d %d %d\n",t,map[mx][my],root[mx][my]);
 
        }
    }
     
    static void dfs(int cx,int cy,int sum, int sx,int sy) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
         
 
        if(visited[cx][cy]) {
            root[sx][sy]=sum+root[cx][cy]-1;
            return;
        } 
         
        root[sx][sy]=sum;
         
        visited[cx][cy]=true;
        for(int i=0; i<4; i++) {
            if(cx+dx[i]>=0&& cx+dx[i]<N&&cy+dy[i]>=0&&cy+dy[i]<N) {
 
                if(map[cx][cy]+1==map[cx+dx[i]][cy+dy[i]]) {
                    dfs(cx+dx[i],cy+dy[i],sum+1,sx, sy);
                }
            }
        }
 
         
    }
 
 
     
}
