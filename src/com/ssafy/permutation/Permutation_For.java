package com.ssafy.permutation;

public class Permutation_For {

	public static void main(String[] args) {
		int n = 3;
		int cnt = 0;
		System.out.println("============중복 순열=============");
		
		for (int i = 1; i<=n; i++) {			//첫번째 원소 뽑기
			for(int j = 1; j<=n; j++) {			//두번째 원소 뽑기
				if(i!=j) {	//중복 제거
					for(int k = 1; k<=n;k++) {		//세 번째 원소 뽑기
						if(k!=i && k!=j) {	//중복 제거
							cnt++;
							System.out.printf("%d %d %d\n",i,j,k);
						}
					}
				}
			}
		}
		System.out.println("중복 순열 개수 :"+cnt);
	}
}
