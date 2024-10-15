package chap04;

public class Exam173 {

	public static void main(String[] args) {
		
		// 50에서 100까지 3의 배수 합 구하기
		// 3의 배수 출력, 마지막에 3의 배수합 출력
		// 3의 배수 갯수 출력
		int cnt = 0;
		int sum = 0;
		for(int i=50; i<=100; i++) {
			if(i % 3 == 0) {
				cnt++;
				sum += i;
				System.out.print(i+" ");
			}
		}
		System.out.println("\n50~100까지의 3의 배수 합은 "+sum+"입니다.");
		System.out.println("50~100까지의 3의 배수 갯수는 "+cnt+"개 입니다.");
		
		// 1에서 n까지의 합이 300이 넘는 순간 n값 구하기
		// 7의 배수의 합이 300이 넘는 순간의 7의 배수찾기 
		// while문
		int su = 0;
		int sum2 = 0;
		while(sum2<300) {
			su += 7;
			sum2 += su;			
		}
		System.out.println("300이 넘는 순간의 7의 배수는 "+su+"입니다.");
		
		//구구단
		for(int m=2; m<=9; m++) {
			System.out.println();
			System.out.println("**** "+m+"단 ****");			
			for(int n=1; n<=9; n++) {
				System.out.println(m+" x "+n+" = "+(m*n));
			}
		}
		
		
		System.out.println("***************************구구단을 외자!***************************");	
		
		//구구단2
		for(int gu=2; gu<=9; gu++) {
			System.out.printf("  %d단\t|", gu);	
		}
		for(int m=1; m<=9; m++) {	
			System.out.println();	
			for(int n=2; n<=9; n++) {
				System.out.printf("%dx%d=%2d\t|",n, m, (m*n));
			}
		}
		
		

	}//end main

}//end class
