package com.ssafy.problem.SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_2383_모의_점심식사시간 {
	
	static int N,cnt,ans;
	static final int M=1,W=2,D=3,C=4;
	static ArrayList<Person> pList;
	static int[][] sList;
	static int[] selected;

	
	
	static class Person implements Comparable<Person>{
		int r;
		int c;
		int arrivalTime;
		int downCnt;
		int status;
		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public void init() {
			arrivalTime=downCnt=0;
			status=M;
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
			p.init(); //사람들 상태를 초기화
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
		int time = list.get(0).arrivalTime;	//먼저 도착한 사람의 시간부터 흘러가게 함
		int size = list.size();
		
		int ingCnt=0, cCnt=0; //내려가는 사람 수, 완료 사람 수
		Person p = null;
		while(true) {
			for(int i=0; i<size; i++) {
				p=list.get(i);
				if(p.status==C) { //계단 다 내려간 사람
					continue;
				}else if(p.arrivalTime==time) { //계단에 도착
					p.status=W;
				}else if(p.status==W && ingCnt<3) { //대기상태이고 내려가는 사람 수가 3보다 작음 =>내려갈 수 있음
					p.status=D;
					p.downCnt=1; //내려가기 시작
					ingCnt++;
				}else if(p.status==D) { //내려가고 있는 사람
					if(p.downCnt==height) { //이동이 다 끝난 사람
						p.status = C;
						ingCnt--;
						cCnt++;
					}else { //아직 계단 높이까지 못 내려간 사람
						p.downCnt++;
					}
				}
			} //해당 시간에 모든 사람에 대해 처리
			if(cCnt==size) break;
			time+=1;
		}
		return time;
	}

}
