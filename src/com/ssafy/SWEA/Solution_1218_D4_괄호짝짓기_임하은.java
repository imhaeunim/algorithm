package com.ssafy.SWEA;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1218_D4_괄호짝짓기_임하은 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack =  new Stack<>();
		
		for(int t=1; t<=10; t++) {
			int N = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			int out = 1;
			
			for(int i = 0; i<N; i++) {
				if(str.charAt(i)==')') {
					if(!stack.isEmpty()&&stack.peek()=='(') {
						stack.pop();
					}else{
						out=0;
						break;
					}
				}else if(!stack.isEmpty()&&str.charAt(i)=='}') {
					if(stack.peek()=='{') {
						stack.pop();
					}else{
						out=0;
						break;
					}
					
				}else if(!stack.isEmpty()&&str.charAt(i)==']') {
					if(stack.peek()=='[') {
						stack.pop();
					}else{
						out=0;
						break;
					}
				}else if(!stack.isEmpty()&&str.charAt(i)=='>') {
					if(stack.peek()=='<') {
						stack.pop();
					}else{
						out=0;
						break;
					}	
				}else {
					stack.push(str.charAt(i));
				}
				
			}
			if(!stack.isEmpty()) out=0;
			System.out.printf("#%d ",t);
			System.out.println(out);
		}
	}

}
