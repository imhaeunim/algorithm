package com.ssafy;

public class day0331np {
	static int[] list = {1,2,3,4,5};
	static int[] parents=new int[5];
	
	public static void main(String[] args) {
		

	}
	
	public static void make() {
		for(int i=0; i<5; i++) {
			parents[i]=list[i];
		}
	}
	
	public static int find(int n) {
		if(parents[n]==n) {
			return n;
		}
		
		return parents[n]=find(parents[n]);
	}
	
	public static void union(int a, int b) {
		if(parents[a]==parents[b]) {
			return;
		}
		parents[b]=find(parents[a]);
		return;
	}

}
