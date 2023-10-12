package com.ssafy.problem.BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_6588_S1_골드바흐의추측_임하은 {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		boolean[] primeCheck = new boolean[1000001];
		Arrays.fill(primeCheck, true);
		primeCheck[2]=false;
		
		for(int i=2; i<primeCheck.length; i++) {
			if(primeCheck[i]) {
				for(int j=i+i; j<primeCheck.length; j+=i) {
					primeCheck[j] = false;
					continue;
				}
			}
			
		}
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		while(n!=0) {

			for (int i=3; i<n; i++) {
				if(primeCheck[i] && primeCheck[n-i]) {
					System.out.println(n+" = "+i+" + "+(n-i));
					break;
				}
			}
			n = n = Integer.parseInt(br.readLine());
		}

	}

}
