package com.ssafy.AdjMatrix;

import java.util.Arrays;
import java.util.Scanner;

public class AdjMatrixTest2 {
	static int[][] adjMatrix;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		adjMatrix =  new int[V][V];
		
		int from, to;
		for(int i=0; i<E; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			adjMatrix[to][from] = adjMatrix[from][to]=1;
		}
		print();

	}
	static void print() {
		for(int[] am: adjMatrix) {
			System.out.println(Arrays.toString(am));
		}
		
	}

}
