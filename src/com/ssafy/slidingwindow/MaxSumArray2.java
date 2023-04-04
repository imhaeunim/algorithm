package com.ssafy.slidingwindow;

/**
 * 정수로 이루어진 배열에서 길이가 4인 sub 배열의 합계가 가장 큰 서브 배열 구하기
 * ex)
 * {2,4,7,10,8,4,5,6,7,1}
 * 
 * 시간 복잡도 (n-k+1) => 시간이 초과할 수도 있음
 * 
 */

public class MaxSumArray2 {
	public static void main(String[] args) {
		int[] nums = {2,4,7,10,8,4,5,6,7,1};
		int max=0, sum=0;
		int k=4, n=nums.length;
		for(int i=0; i<n-k; i++) {
			sum=0;
			for(int j=i; j<i+k; j++) {
				sum+=nums[j];
			}
			max=Math.max(max, sum);
		}
		System.out.println(max);
	}

}
