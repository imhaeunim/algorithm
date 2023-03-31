package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_1541_S2_잃어버린괄호_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] input = sc.nextLine().split("-");
		
		boolean start = false;
		int sum = 0;
		for(String num:input) {
			if(!num.contains("+")) {
				if(!start) {					
					sum+=Integer.parseInt(num);
					start=true;
				}else {
					sum-=Integer.parseInt(num);
				}
				continue;
			}
			String temp[] = num.split("\\+");
			int sub_sum=0;
			for(String tm: temp) {
				if(tm.equals("+")) continue;
				sub_sum+=Integer.parseInt(tm);
			}
			if(!start) {
				sum+=sub_sum;
				start=true;
			}else {				
				sum-=sub_sum;
			}
		}
		
		System.out.println(sum);

	}

}