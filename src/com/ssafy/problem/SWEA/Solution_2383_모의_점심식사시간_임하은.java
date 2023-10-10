package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2383_모의_점심식사시간_임하은 {
	
	static int N;
	static int[][] map;
	static boolean[] isSelected;
	static ArrayList<int[]> people = new ArrayList<>();
	static ArrayList<int[]> stair = new ArrayList<>();
	
	
	static class Person implements Comparable<Person>{
		int x;
		int y;
		int d;
		int s; //0이면 첫번째 계단, 1이면 두 번째 계단
		public Person(int x, int y, int d, int s) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.s = s;
			
		}
		@Override
		public int compareTo(Person o) {
			return d-o.d;
		}	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
					if(map[i][j]==1) {
						people.add(new int[] {i,j});
					}
					else if(map[i][j]==0) continue;
					else {
						stair.add(new int[] {i,j,map[i][j]});
					}
				}
			}
			
			isSelected = new boolean[people.size()];
			
			
			
			
		}

	}
	private static void sebset(int cnt) {
		if(cnt==people.size()) {
			calculate();
			return;
		}
		isSelected[cnt] = true;
		sebset(cnt+1);
		isSelected[cnt] = false;
		sebset(cnt+1);
	}
	
	private static void calculate() {
		PriorityQueue<Person> p1 = new PriorityQueue<>();
		PriorityQueue<Person> p2 = new PriorityQueue<>();
		for(int i=0; i<isSelected.length; i++) {
			if(isSelected[i]) { //첫번째 계단
				p1.add(new Person(people.get(i)[0],people.get(i)[1],
						Math.abs(stair.get(0)[0]-people.get(i)[0])+Math.abs(stair.get(0)[0]-people.get(i)[0]),0));			
			}else{ //두번째 계단
				p2.add(new Person(people.get(i)[0],people.get(i)[1],
						Math.abs(stair.get(1)[0]-people.get(i)[0])+Math.abs(stair.get(1)[0]-people.get(i)[0]),1));			
			}
		}
		
		int time=0;
		int count = 0;
		while(!p1.isEmpty()) {			
			Person person = p1.poll();
			time+=person.d;
			count++;
			
		}
	}
}
