package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2239_G4_스도쿠 {
	static int[][] map;
    static int[][] copy = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        
        map = new int[9][9];
        
        StringTokenizer st;
        for(int i=0; i<9; i++) {
        	String input = br.readLine();
            for(int j=0; j<9; j++) {
                map[i][j]=input.charAt(j)-'0';
                copy[i][j]=map[i][j];
            }
        }

        dfs(0,-1);
        
    }
    public static void printMap() {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {                    
                System.out.print(copy[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        System.exit(0);
    }

    public static void dfs(int x, int y) {
        if(x==8&&y==8) {
        	printMap();
            return;
        }
        
        int nx=x;
        int ny=y+1;
        if(ny==9) {
            ny=0;
            nx++;
        }
        
        while(true) {	        	
        	if(nx==9&&ny==0) {
        		printMap();
        		return;
        	}
        	if(map[nx][ny]!=0) {
        		ny++;
        		if(ny==9) {
        			ny=0;
        			nx++;
        		}
        	}else break;

        }
        
        outer:
        for(int i=1; i<=9; i++) {
            for(int j=0; j<9; j++) {
                if(i==copy[nx][j]) continue outer;
                if(i==copy[j][ny]) continue outer;
            }
            for(int ii=((int)nx/3)*3; ii<((int)nx/3)*3+3; ii++) {
            	for(int jj=((int)ny/3)*3; jj<((int)ny/3)*3+3; jj++) {                    
            		if(copy[ii][jj]==i) continue outer;
            	}
            }
            copy[nx][ny]=i;
            dfs(nx,ny);
            copy[nx][ny]=0;
        }
    }
}

