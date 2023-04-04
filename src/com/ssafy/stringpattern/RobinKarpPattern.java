package com.ssafy.stringpattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;


/**
 * 
2
68432124321
4321
ABACABAABB
ABAAB
 * 
 */
public class RobinKarpPattern {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int t=1; t<=T; t++) {
			char[] text = in.readLine().trim().toCharArray();
			char[] pattern = in.readLine().trim().toCharArray();
		
			long pHash=0, tHash=0, power=1;
			long base=26;
			long mod = 1000000009;
			int tlen = text.length;
			int plen = pattern.length;
			
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
			System.out.println("size : "+list.size());
			for(int index: list) {
				System.out.println(index+" ");
			}
			System.out.println();
		}

	}

}
