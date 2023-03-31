package com.ssafy.BOJ;

import java.util.Scanner;

public class Main_17478_S5_재귀함수가뭔가요_임하은 {
//	static int N;
//	
//	
//	public static void QnA(int n) {
//		
//		String Q = "재귀함수가 뭔가요?\n";
//		String A1= "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\r";
//		String A2= "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\r";
//		String A3= "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.";
//		
//		if(n>0) {
//			System.out.print("____");
//			System.out.println(Q);
//			QnA(n-1);
//		}
//		
//
////		System.out.println(plus+A1+plus+A2+plus+A3);
//	}
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt();
//		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
//		QnA(N);
//
	static String line = "";
	
	static void QnA(int n) {
		String Q ="\"재귀함수가 뭔가요?\"";
		String A1="\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		String A2="마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		String A3="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String temp = line;
		if(n==0) {
			System.out.println(temp+Q);
			System.out.println(temp +"\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.println(temp+"라고 답변하였지.");		
//			return;
		}else {
			System.out.println(temp+Q);
			System.out.println(temp+A1);
			System.out.println(temp+A2);
			System.out.println(temp+A3);
			line = line+"____";
			QnA(n-1);
			System.out.println(temp+"라고 답변하였지.");		
		}
	}
		

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");

			QnA(N);
	}
}
