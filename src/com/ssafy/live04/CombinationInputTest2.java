package com.ssafy.live04;
//조합 : 부분집합에서 R개를 선택하면 조합이 됨!
public class CombinationInputTest2 {
	static int r = 3;
	static int[] combi;
	static int[] arr = {3,6,7,1,5};
		
	
	public static void main(String[] args) {
		int n = arr.length;
		combi = new int[n];
		int k =0;
		for(int i =0, size = 1<<n; i<size; i++) {
			k=0;
			for(int j = 0; j<n; j++) {
				if((i&1<<j) !=0) {
					combi[k++] = j;
				}
			}
			
			if(k==r) {
				for (int j=0; j<r; j++) {
					System.out.print(arr[combi[j]]+" ");
				}
				System.out.println();
			}
		}
		
		
	}

}
