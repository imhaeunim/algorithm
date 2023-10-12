package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_5430_G5_AC_임하은 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		while(T>0) {
			T-=1;
			String temp=br.readLine();
			
			char[] rdList = new char[temp.length()];
			
			for(int i = 0; i<temp.length(); i++) {
				rdList[i] = temp.charAt(i);
			}
			
			int n = Integer.parseInt(br.readLine());
//			int[] list = new int[n];
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			temp = br.readLine();
			
			st = new StringTokenizer(temp,"[],");

			for(int i=0; i<n; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			
			boolean left = true;
			
			for(int i=0; i<rdList.length; i++) {
				if(rdList[i] == 'R') {
					left = false;
				}else if(rdList[i] == 'D') {
					if(queue.size()==0) {
						sb.append("error\n");
						break;
					}else {
						if(left) {
							queue.pollFirst();
						}else {
							queue.pollLast();
						}
					}
				}
			}
			
			if(!queue.isEmpty()) {
				sb.append("[");
				for(int i=0; i<queue.size(); i++) {
					if(left) sb.append(queue.pollFirst());
					else sb.append(queue.pollLast());
				}
				sb.append("]");
			}
			T--;
			
			
		}
		System.out.println(sb);
	}

}
