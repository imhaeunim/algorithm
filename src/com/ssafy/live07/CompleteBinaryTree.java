package com.ssafy.live07;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//완전 이진트리 : 1차원 배열 구현
public class CompleteBinaryTree<T> {
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
	public void add(T e) {
		if(isFull()) return;
		
		nodes[++lastIndex]=e;
	}
	
	public void dfs0() {
	//큐에는 탐색노드 번호 저장
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); //루트노드부터
	
	int current = 0;
	while(!queue.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
		current = queue.poll();
		System.out.print(nodes[current]+"\t");
		//현재 노드의 자식 노드들을 큐에 넣어 순서 기다리게 하기
		//완전 이진 트리 :  자식이 최대 2
			
		//왼쪽 자식
		if(current*2<=lastIndex) queue.offer(current*2);
		//오른쪽 자식
		if(current*2+1<=lastIndex) queue.offer(current*2+1);
	}

}
	
	public void bfs() {
		//큐에는 탐색노드 번호 저장
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.offer(1); //루트노드부터
		
		int current = 0,size, level=0;
		while(!queue.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
			
			size = queue.size();
			System.out.print("level "+level+" : ");
			while(--size>=0) {
				current = queue.poll();
				System.out.print(nodes[current]+"\t");
				//현재 노드의 자식 노드들을 큐에 넣어 순서 기다리게 하기
				//완전 이진 트리 :  자식이 최대 2
				
				//왼쪽 자식
				if(current*2<=lastIndex) queue.offer(current*2);
				//오른쪽 자식
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			level++;
			System.out.println();

		}
	}
	
	public void dfsByPreOrder() {
		System.out.print("PreOrder : ");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	public void dfsByPreOrder(int current) {
//		System.out.println("PreOrder : ");
		System.out.print(nodes[current]+" ");
		//왼쪽 자식
		if(current*2<=lastIndex) dfsByPreOrder(current*2);
		//오른쪽 자식
		if(current*2+1<=lastIndex) dfsByPreOrder(current*2+1);
	}
	
	public void dfsByInOrder() {
		System.out.print("PreOrder : ");
		dfsByInOrder(1);
		System.out.println();
	}
	
	
	public void dfsByInOrder(int current) {
//		System.out.println("InOrder : ");
		//왼쪽 자식
		if(current*2<=lastIndex) dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		//오른쪽 자식
		if(current*2+1<=lastIndex) dfsByInOrder(current*2+1);
	}
	
	public void dfsByPostOrder() {
		System.out.print("PostOrder : ");
		dfsByPostOrder(1);
		System.out.println();
	}
	
	
	public void dfsByPostOrder(int current) {
//		System.out.println("PreOrder : ");
		//왼쪽 자식
		if(current*2<=lastIndex) dfsByPostOrder(current*2);
		//오른쪽 자식
		if(current*2+1<=lastIndex) dfsByPostOrder(current*2+1);
		System.out.print(nodes[current]+" ");
	}
	
	public void dfs() {
		//큐에는 탐색노드 번호 저장
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1); //루트노드부터
		
		int current = 0;
		while(!stack.isEmpty()) { //큐에 대기하고 있는 순서대로 노드 처리
			current = stack.pop();
			System.out.print(nodes[current]+" ");
			//현재 노드의 자식 노드들을 큐에 넣어 순서 기다리게 하기
			//완전 이진 트리 :  자식이 최대 2
			
			//오른쪽 자식
			if(current*2+1<=lastIndex) stack.push(current*2+1);
			//왼쪽 자식
			if(current*2<=lastIndex) stack.push(current*2);
			
		}
	}
}
