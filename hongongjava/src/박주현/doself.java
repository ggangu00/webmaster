package 박주현;

import java.util.Scanner;

public class doself {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		/*
		// 1번
		System.out.print("####년도 입력 : ");
		int year = Integer.parseInt(sc.nextLine());
		if(year%4 == 0 && year%100 != 0) {
			System.out.printf("%d년은 윤년입니다.", year);
		}else {
			System.out.printf("%d년은 평년입니다.", year);
		}
		System.out.println();
		
		//2번
		System.out.print("교환할 금액 : ");
		int firstMoney = Integer.parseInt(sc.nextLine());
		int money = firstMoney;
		System.out.println("500원 짜리 : "+money/500);
		money %= 500;
		System.out.println("100원 짜리 : "+money/100);
		money %= 100;
		System.out.println("50원 짜리 : "+money/50);
		money %= 50;
		System.out.println("10원 짜리 : "+money/10);
		money %= 10;
		System.out.println("남은 금액 : "+money);
		
		//3번
		System.out.println();
		int ranNum = (int)( Math.random() * 100) + 1;
		
		while(true) {
			System.out.print("숫자입력 : ");
			int inNum = Integer.parseInt(sc.nextLine());
			if(ranNum > inNum) {
				System.out.println("UP하세요!!");
			}else if(ranNum < inNum) {
				System.out.println("Down하세요!!");
			}else {
				System.out.println("축하합니다!!");
				break;
			}			
		}
		
		//4번
		for(int gu=2; gu<=9; gu++) {
			System.out.printf("  %d단\t|", gu);	
		}
		for(int m=1; m<=9; m++) {	
			System.out.println();	
			for(int n=2; n<=9; n++) {
				System.out.printf("%dx%d=%2d\t|",n, m, (m*n));
			}
		}

		
		//5번
		boolean run = true;
		
		while(run) {			
			System.out.println("-------------");
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("-------------");
			System.out.print("▶ 번호 선택 : ");
			int temp = sc.nextInt();
			
			switch(temp) {
				case 1:
					System.out.print("화씨 온도 입력> ");
					double tempC = 5.0/9*(sc.nextInt()-32);
					System.out.printf("섭씨온도 = %.6f \n",tempC);
					break;
				case 2:
					System.out.print("섭씨 온도 입력> ");
					double tempF = 9.0/5*sc.nextInt()+32;
					System.out.printf("화씨온도 = %.6f \n",tempF);
					break;
				case 3:
					run = false;
					break;
				default:
					System.out.println("잘못된 값이 입력되었습니다.");
			}	
			
		}
		System.out.println("program end");

		//6번
		boolean run2 = true;
		
		while(run2) {			
			int ranSu = (int)( Math.random() * 3) + 0;
			System.out.print("가위(0) 바위(1) 보(2) : ");
			int rsp = sc.nextInt();
			String result = "";
			
			if(rsp > 3) {
				result = "잘못된 값이 입력되었습니다.";
			} else if(rsp == 3) {
				run2 = false;		
			} else {
				result += "사람" + rsp + ", 컴" + ranSu;
			
				if(ranSu == 2 && rsp == 0) {
					rsp = 9;
				}else if(ranSu == 0 && rsp == 2) {
					ranSu = 9;
				}
			
				if(ranSu > rsp) {
					result += " 졌음";
				}else if(ranSu < rsp) {
					result += " 이겼음";
				}else if(ranSu == rsp) {
					result += " 비겼음";
				}		
			}
			
			System.out.println(result);
		}
		System.out.println("program end");

		while(run) {
			System.out.print("##가위바위보 : ");
			int my = Integer.parseInt(sc.nextLine());
			int com = (int)(Math.random()*2);
			
			if(my > 2) {
				run = false;
				break;
			}
			
			if(my == com) {
				System.out.printf("com = %d, my = %d 비겼음 \n", com, my);
			}else if((my+1)%3 == com) {
				System.out.printf("com = %d, my = %d com이 이겼음 \n", com, my);
			}else {
				System.out.printf("com = %d, my = %d my가 이겼음 \n", com, my);
			}
		}*/
		
		
		//7번
		int num = 0;
		for(int i=0; i<5; i++) {
			for(int j=0; j<10; j++) {
				num++;
				int heart = 0;
				String str = "";
				
				if(num%10 == 3 || num%10 == 6 || num%10 == 9) {
					heart++;
					str = "♥";
				}
				if(num/10 == 3 || num/10 == 6 || num/10 == 9) {
					heart++;
					str += "♥";
				}
				
				if(heart<1) {
					str += num;
				}
				
				str += "\t";
				
				System.out.print(str);
			}
			System.out.println();
		}
		sc.close();
			
	}

}
