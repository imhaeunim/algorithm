package com.ssafy.live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * 시간 복잡도  :NlogN
 * C[k] 배열 : 길이 N의 LIS에 대하여
 *			k 길이에 올 수 있는 가장 작은 값을 저장한다.
 *
 * 동적 배열 C[k]에 가능한 LIS를 저장한 상태로 담아 놓는다. ->LIS 배열이 아님
 * C[K] 배열에 저장한 데이터의 길이가 LIS이다.
 */
public class LISTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] C = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int k = 0;	//LIS size
		C[k++]=arr[0]; //첫번째 수열 저장
		for(int i=1; i<N; i++) {
			//i번째 원소가 위치할 곳을 이진 탐색으로 찾는다.
			//arr[i] : 탐색키
			//=> 찾으면 찾은 데이터의  index를 리턴 / 못 찾으면 마지막 찾은 (위치 -1)을 음수로 전달
			//=> i번째 원소가 C[]에 저장되어야 할 위치
			int temp = Arrays.binarySearch(C, 0,k,arr[i]);
			temp = Math.abs(temp)-1; //=> i번째 원소가 C[]에 저장되어야 할 위치
			C[temp] = arr[i];
			if(k==temp) {	//맨 끝에 추가된 상황
				k++;
			}
		}
		System.out.println("LIS : "+k);
	}

}
