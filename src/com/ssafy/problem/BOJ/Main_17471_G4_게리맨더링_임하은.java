package com.ssafy.problem.BOJ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17471_G4_게리맨더링_임하은 {

    static int N;
    static boolean[][] connected; 
    static boolean[] select;
    static boolean[] visited;
    static int[] people;
    static int min  = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        people = new int[N+1];
        select = new boolean[N+1];
        connected=new boolean[N+1][N+1];
        for(int i=1; i<=N; i++) {
            people[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++) {
            int num = sc.nextInt();
            for(int j=0; j<num; j++) {
                int node = sc.nextInt();
                connected[i][node] = true;
            }
        }

        subset(1);
        if(min==Integer.MAX_VALUE) min=-1;
        System.out.println(min);

	}
	
	private static void subset(int cur) {
	    if(cur==N+1) {
	        ArrayList<Integer> groupA = new ArrayList<Integer>();
	        ArrayList<Integer> groupB = new ArrayList<Integer>();
	        for(int i=1; i<=N; i++) {
	            if(select[i]) {
	                groupA.add(i);
	            }else {
	                groupB.add(i);
	            }
	        }
	        if(groupA.size()==0 || groupB.size()==0) return;                
	        
	        visited = new boolean[N+1];
	        bfs(groupA);
	        int countA =0;
	        for(int i=0; i<groupA.size(); i++) {
	            if(!visited[groupA.get(i)]) return;
	            countA+=people[groupA.get(i)];
	        }
	        visited = new boolean[N+1];
	        bfs(groupB);
	        int countB=0;
	        for(int i=0; i<groupB.size(); i++) {
	            if(!visited[groupB.get(i)]) return;
	            countB+=people[groupB.get(i)];
	        }
	        
	        min = Math.min(min, Math.abs(countA-countB));
	        
	        return;
	    }
	    select[cur] = true;
	    subset(cur+1);
	    select[cur] =false;
	    subset(cur+1);
	}
	
	private static void bfs(ArrayList<Integer> group) {
	    Queue<Integer> queue = new LinkedList<Integer>();
	    visited[group.get(0)]=true;
	    queue.add(group.get(0));
	    
	    while(!queue.isEmpty()) {
	        int start = queue.poll();
	        for(int i : group) {
	            if(visited[i]) continue;
	            if(connected[start][i]) {
	                visited[i]=true;
	                queue.offer(i);
	            }
	        }
	    }
	    return;
	    
	}
}
