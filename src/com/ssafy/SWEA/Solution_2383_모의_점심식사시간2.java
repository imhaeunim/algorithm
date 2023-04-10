package com.ssafy.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2383_모의_점심식사시간2 {
	
	static int N,cnt,ans;
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;

	
	
	static class Person implements Comparable<Person>{
		int r;
		int c;
		int arrivalTime;
		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.arrivalTime, o.arrivalTime);
		}	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			pList = new ArrayList<Person>();
			sList = new int[2][];
			ans = Integer.MAX_VALUE;
			for(int i=0, k=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int c=Integer.parseInt(st.nextToken());
					if(c==1) {
						pList.add(new Person(i,j));
					}
					else if(c==0) continue;
					else {
						sList[k++]=new int[] {i,j,c};
					}
				}
			}
			cnt=pList.size();
			selected = new int[cnt];	//선택한 계단 인덱스
			divide(0);
			
			System.out.println("#"+t+" "+ans);
		}

	}
	
	//power set
	private static void divide(int index) {
		if(index==cnt) {
			int res=calculate();
			ans = Math.min(ans, res);
			return;
		}
		selected[index] = 0;
		divide(index+1);
		selected[index] = 1;
		divide(index+1);
	}
	
	// 선택된 계단아ㅔ 따라 사람들의 리스트 만들고 내려가기 처리 후 소요된 시간 리턴
	private static int calculate() {
		ArrayList<Person>[] list = new ArrayList[] {new ArrayList<Person>(),new ArrayList<Person>()};
		
		for(int i=0; i<cnt; i++) {
			Person p = pList.get(i);
			int no = selected[i];
			p.arrivalTime=Math.abs(p.r-sList[no][0])+Math.abs(p.c-sList[no][1]);
			list[no].add(p);
		}
		
		int timeA=0, timeB=0;
		if(list[0].size()>0) {
			timeA=processDown(list[0], sList[0][2]);
		}
		if(list[1].size()>0) {
			timeB=processDown(list[1], sList[1][2]);
		}
		
		return timeA>timeB?timeA:timeB; //둘 중 더 큰거 줌
	}
	
	
	private static int processDown(ArrayList<Person> list, int height) {
		
		Collections.sort(list); //계단 입구까지 도착 시간이 빠른 순으로 정렬
		int size = list.size()+3;
		int[] D = new int[size];
		for(int i=3; i<size; i++) {
			Person p = list.get(i-3);
			if(D[i-3]<=p.arrivalTime+1) { //바로 내려갈 수 있음
				 D[i]=p.arrivalTime+1+height;
			}else { //대기해야해
				D[i]=D[i-3]+height;
			}
		}
		
		return D[size-1];
	}

}
