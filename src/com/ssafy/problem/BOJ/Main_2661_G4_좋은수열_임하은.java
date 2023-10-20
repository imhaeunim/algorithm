package com.ssafy.problem.BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2661_G4_좋은수열_임하은 {

	static int N;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		String per="";
		make(per);
		
		
	}

	public static void make(String str) {
		if(str.length()==N) {
			System.out.println(str);
			System.exit(0);
		}
		for(int i=1; i<=3; i++) {
			if(check(str+i)) {
				make(str+i);
			}
			
		}
	}
	
	
	public static boolean check(String str) {		
		for(int i=1; i<str.length()/2+1; i++) {
			if(str.substring(str.length()-i, str.length()).equals(str.substring(str.length()-(i*2), str.length()-i))) return false;
		}

		return true;
	}
}
