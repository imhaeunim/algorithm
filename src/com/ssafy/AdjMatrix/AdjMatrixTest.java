package com.ssafy.AdjMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest {
	static ArrayList<Integer>[] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix =  new ArrayList[V];
		
		for(int i=0; i<V; i++) {
			adjMatrix[i] = new ArrayList<Integer>();
		}
		
		int from, to;
		for(int i=0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			adjMatrix[from].add(to);
			adjMatrix[to].add(from);
		}
		print();

	}
	static void print() {
		for(ArrayList<Integer> list: adjMatrix) {
			System.out.println(list);
		}
		
	}

}
