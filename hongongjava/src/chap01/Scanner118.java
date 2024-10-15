package chap01;

import java.util.Scanner;

public class Scanner118 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strin;
		
		//문자열
		System.out.print("문자열 입력 > ");
		strin = sc.nextLine();
		System.out.println("입력받은 문자열 \"" + strin+"\"");
		
		//숫자
		System.out.print("숫자 입력 > ");
		int valInt = sc.nextInt();
		System.out.println("입력받은 숫자 \"" + valInt+"\"");
		
		//문자열 재입력 : 남은 공백을 가지고 오기 때문에 입력할 새도 없이 입력/출력 끝나버림
		/*
		strin = sc.nextLine(); 
		System.out.println("입력받은 문자열 \"" + strin+"\"");
		*/
		strin = sc.nextLine(); //위 주석과 같은 오류 발생 방지용으로 입력창 초기화한 후 재입력
		System.out.print("문자열 입력 > ");
		strin = sc.nextLine(); 
		
		if(strin.equals("q")) { //strin == "q" 형식으로 비교할 경우 주소까지 일치하지 않기 때문에 오류발생
			System.out.println("Q 입력됨");
			
		}else {
			System.out.println("입력받은 문자열 \"" + strin+"\"");
		}
		
		//숫자
		System.out.print("숫자 입력 > ");
		valInt = Integer.parseInt(sc.nextLine());
		System.out.println("입력받은 숫자 + 100: " + (valInt+100));
		
		sc.close();		
	}

}
