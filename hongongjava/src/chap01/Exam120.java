package chap01;
import java.util.Scanner;
public class Exam120 {

	public static void main(String[] args) {
		
		//문제1
		String name = "박주현";
		int age = 24;
		String tel1 = "010", tel2 = "5689", tel3 = "7704";
		System.out.println("이름 : "+name);
		System.out.print("나이 : "+age+"\n");
		System.out.printf("전화번호 : %s \n", tel1 + "-" + tel2 + "-" + tel3);
		System.out.println("------------------------------");
		
		//문제2
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 수:");
		String strNum1 = sc.nextLine();
		
		System.out.print("두번째 수:");
		String strNum2 = sc.nextLine();
		
		int num1 = Integer.parseInt(strNum1);
		int num2 = Integer.parseInt(strNum2);
		int result = num1+num2;
		System.out.println("덧셈 결과 : " + result);
		System.out.println("------------------------------");
		
		
		//문제3		
		System.out.print("이름 입력 > ");
		String name2;
		name2 = sc.nextLine();
		
		System.out.print("주민번호 앞 6자리 입력 > ");
		String num;
		num = sc.nextLine();
		
		System.out.print("전화번호 입력 > ");
		String tel;
		tel = sc.nextLine();
		
		System.out.println("1. 이름 : " + name2);
		System.out.println("2. 주민번호 앞 6자리 : " + num);
		System.out.println("3. 전화번호 : " + tel);
		System.out.println("------------------------------");

		
		//두 수를 입력 받아서 큰수 - 작은수
		System.out.print("첫번째 수:");
		int inNum1 = sc.nextInt();
		
		System.out.print("두번째 수:");
		int inNum2 = sc.nextInt();
		
		if(inNum1>inNum2) {
			System.out.printf("큰수 - 작은수: %d", inNum1-inNum2);
		}else if(inNum2>inNum1) {
			System.out.printf("큰수 - 작은수: %d", inNum2-inNum1);
		}else {
			System.out.printf("두 수는 같습니다.");
		}
		
		sc.close();
	}
}
