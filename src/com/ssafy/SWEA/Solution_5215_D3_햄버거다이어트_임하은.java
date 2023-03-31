package com.ssafy.SWEA;

import java.util.Scanner;

public class Solution_5215_D3_햄버거다이어트_임하은 {
	static boolean[] isSelected;
	static int[][] list;
	static int N;
	static int L;
	static int MAX;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {

			N = sc.nextInt();
			L = sc.nextInt();
			isSelected = new boolean[N];

			list = new int[N][2];
			for (int i = 0; i < N; i++) {
				list[i][0] = sc.nextInt();
				list[i][1] = sc.nextInt();
			}

			MAX = 0;
			SubSet(0, 0, 0);
			System.out.printf("#%d %d\n",t,MAX);

		}

	}

	static void SubSet(int cur, int Csum, int Tsum) {
		if (Csum > L) {
			return;
		}
		if (cur == N) {
			if (Tsum > MAX) {
				MAX = Tsum;
			}
			return;
		}
		SubSet(cur + 1, Csum + list[cur][1], Tsum + list[cur][0]);

		SubSet(cur + 1, Csum, Tsum);

	}

}
