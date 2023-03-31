package com.ssafy.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

//완전 이진트리 : 1차원 배열 구현
public class CompleteBinaryTree<E> {
	private Object[] nodes;
	private final int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new Object[size+1];
	}
	
	private boolean isFull() {
		return lastIndex == SIZE;
	}
	//완전 이진 트리로 추가하는 방법
	public void add(E e) {
		if(isFull()) {
			System.out.println("포 화 상 태");
			return;
		}
		
		nodes[++lastIndex]=e;
	}
	
	public void bfs() {
		//큐에는 탐색노드 번호 저장
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); //루트노드부터 (1번부터 쓸 거야)
		
		int current = 0;
		while(!queue.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
			current = queue.poll();
			System.out.println(nodes[current]);
			//현재 노드의 자식 노드들을 큐에 넣어 순서 기다리게 하기
			//완전 이진 트리 :  자식이 최대 2
			
			//왼쪽 자식
			if(current*2<=lastIndex) queue.offer(current*2);
			//오른쪽 자식
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
			
		}
	}
	
	//레벨별로 출력
	public void bfs2() {
		//큐에 노드의 index만 저장
		Queue<Integer> queue = new LinkedList<>();
		int current;
		int size;		//level에 저장된 노드의 수
		int level=0;	//level 표시를 위한 변수
		
		queue.offer(1);		//root 노드의 index를 queue에 저장
		while(!queue.isEmpty()) {	//모든 노드를 다 탐색
			size = queue.size();
			System.out.printf("level -%d: ", level);
			while(--size>=0) {	//level의 노드 수만큼 반복
				current = queue.poll();
				System.out.printf("%s ",nodes[current]);
				
				//왼쪽 노드 탐색
				if(current*2<=lastIndex) queue.offer(current*2);
				//오른쪽 노드 탐색
				if(current*2+1<=lastIndex) queue.offer(current*2+1)	;	
			}
			System.out.println();
			level++;
		}
	}
	

}
