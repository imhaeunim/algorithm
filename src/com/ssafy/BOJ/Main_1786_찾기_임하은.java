package com.ssafy.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main_1786_찾기_임하은 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
	
		long pHash=0, tHash=0, power=1;
		long base=26;
		long mod = 1000000009;
		int tlen = text.length;
		int plen = pattern.length;
		
		
		if(tlen<plen) {
			System.out.println(0);
			return;
		}
		
		Deque<Integer> list = new ArrayDeque();
		
		//pattern의 개수만큼  본문의 hash와 pattern의 hash 구하기 <=K개를 미리 구하기
		for(int i=0; i<plen; i++) {
			pHash = (pHash*base)%mod;
			pHash = (pHash+pattern[i])%mod;
			tHash = (tHash*base)%mod;
			tHash = (tHash+text[i])%mod;
			
			if(i<plen-1) power = (power*base)%mod;
		}
		if(pHash==tHash) {
			list.add(1);
		}
		
		for(int i=1; i<=tlen-plen;i++) {
			//본문의 새로운 hash 만들기
			//				윈도우의 맨 앞부분을 빼주고
			tHash=(((tHash-(text[i-1]*power)%mod+mod)%mod*base)
					+text[i+plen-1])%mod;	//윈도우의 맨 뒷 부분에 추가
			if(pHash==tHash) {
				list.add(i+1);
				//만약 hash 충돌이 된 경우 문자열을 하나씩 비교
			}
		}
//		System.out.println(list.size());
		sb.append(list.size()).append("\n");
		for(int index: list) {
//			System.out.println(index+" ");
			sb.append(index).append(" ");
		}
		System.out.println(sb);
	}
}
