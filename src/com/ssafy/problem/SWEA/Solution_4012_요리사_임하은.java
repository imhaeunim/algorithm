package com.ssafy.problem.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_4012_요리사_임하은 {
    static int N;
    static boolean[] isSelected;
    static int[][] map;
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t=1; t<=T; t++) {
            N = sc.nextInt();
            isSelected = new boolean[N];
            map = new int[N][N];
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j]=sc.nextInt();
                }
            }
            min = Integer.MAX_VALUE;
            combi(0,0);
            System.out.printf("#%d ",t);
            System.out.println(min);
        }

    }
    private static void combi(int start, int cnt) {
        if(cnt==N/2) {
           int sum1=0;
           int sum2=0;
           for (int i=0; i<N; i++) {
        	   for(int j=0; j<N; j++) {
        		   if(isSelected[i]&&isSelected[j]) {
        			   sum1+=map[i][j];
        		   }else if(!isSelected[i]&&!isSelected[j]) {
        			   sum2+=map[i][j];
        		   }
        	   }
           }
           if(Math.abs(sum1-sum2)<min) {
        	   min=(int)Math.abs(sum1-sum2);
           }            
            return;
        }
        for(int i=start; i<N; i++) {
            isSelected[i]=true;
            combi(i+1, cnt+1);
            isSelected[i]=false;
        }
    }
    


}
