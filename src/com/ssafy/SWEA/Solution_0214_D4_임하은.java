package com.ssafy.SWEA;

import java.util.Arrays;
import java.util.Scanner;

import sun.security.util.Length;

public class Solution_0214_D4_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t=1; t<=10; t++) {
			int result = 1;
			int N = sc.nextInt();
			sc.nextLine();
			if(N%2==0) {
				for(int i=0; i<N; i++) {
					result=0;	//짝수면 유효하지 않아
					sc.nextLine();
				}
				System.out.printf("#%d %d\n",t,result);
				continue;
			}else{
				for(int i=0; i<N;i++) {
					String[] str = sc.nextLine().split(" ");
					if(str.length==4) {	//부모노드
						if(!str[1].equals("-")&&!str[1].equals("+")&&!str[1].equals("*")&&!str[1].equals("/")) {//부모노드가 숫자면 유효하지 않아
							result=0;

						}
					}else if(str.length==2) {	//자식노드
						if(str[1].equals("-")||str[1].equals("+")||str[1].equals("*")||str[1].equals("/")) {//자식노드가 숫자가 아니면 유효하지 않아
							result=0;

						}
					}
				}
				System.out.printf("#%d %d\n",t,result);	
			}
		}
	}
}
