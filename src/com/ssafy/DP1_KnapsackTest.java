package com.ssafy;

import java.util.Scanner;

//배낭채우기 : 보석개수 1개 버전
/**
 * @author taeheekim
 */
public class DP1_KnapsackTest {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weights = new int[N+1];
		int[] profits = new int[N+1];

		//뒤에서부터 채울게 
		//-> w-weights[i]는 직전 item까지 고려한 최대 가치가 저장되어 있어 같은 item을 두 번 사용하지 않는다.
		int[] results = new int[W+1]; //가치 저장 테이블
		
		// i=0은 0으로 그대로 둠.
		for (int i = 1; i <=N; i++) {
			weights[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int itemWeight = 0, itemBenefit = 0; 
		// 모든 아이템에 대해서 반복
		for (int item = 1; item <= N; item++) {
			itemWeight = weights[item]; // 현 아이템의 무게	
			itemBenefit = profits[item]; // 현 아이템의 가치
			
			// 가방 최대 무게부터 현재 아이템의 무게까지 시도
			for (int weight = W; weight >= weights[item]; weight--) {
				if(itemWeight <= weight){	
					results[weight] = Math.max(results[weight], itemBenefit+results[weight-itemWeight]);
				}
			}
		}
		
		System.out.println(results[W]);
		sc.close();
	}

}
