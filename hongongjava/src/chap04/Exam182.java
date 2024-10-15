package chap04;

import java.util.Scanner;

public class Exam182 {

	public static void main(String[] args) {
		
		//4번
		for(int x=1; x<=10; x++) {
			for(int y=1; y<=10; y++) {
				if((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}			
		}
		
		//5번
		String str = "";
		for(int i=0; i<5; i++) {
			str += "*";
			System.out.println(str);
		}
		
		//6번
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if(i>=j) {
					System.out.print("*");
				}else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}		
		
		
		String stars = "";
		for(int i=1; i<5; i++) {
			stars += "*";
			System.out.printf("%4S\n", stars);
		}
		
		//7번
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-----------------------------");
			System.out.print("선택> ");
			int atm = Integer.parseInt(scanner.nextLine());
			
			switch(atm) {
				case 1:
					System.out.print("예금액> ");
					balance += Integer.parseInt(scanner.nextLine());
					break;
				case 2:
					System.out.print("출금액> ");
					int outM = Integer.parseInt(scanner.nextLine());
					if(outM > balance) {
						System.out.println("잔액이 부족합니다\n출금 가능액 : "+balance);
					}else {
						balance -= outM;
					}
					break;
				case 3:
					System.out.println("잔고> "+balance);
					break;
				case 4:
					run = false;
					break;
				default:
					System.out.println("잘못된 값이 입력되었습니다.");
			}			
		}
		System.out.println("프로그램 종료");
		scanner.close();		
	}

}
