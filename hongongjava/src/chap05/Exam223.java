package chap05;

import java.util.Scanner;

public class Exam223 {

	public static void main(String[] args) {
		
		//확인문제 6번
		boolean run = true;
		int stuNo = 0;
		int[] scores = null;
		int sum=0;
		int max=0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스터 | 4. 분석 | 5. 종료");
			System.out.print("선택> ");
			
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
				case 1:
					System.out.print("학생수> ");
					stuNo = Integer.parseInt(sc.nextLine());
					scores = new int[stuNo];
					break;
				case 2: 
					for(int i=0; i<stuNo; i++) {
						System.out.print("scores["+i+"]> ");
						scores[i] = Integer.parseInt(sc.nextLine());
						sum += scores[i];
						if(max < scores[i])max = scores[i];		
					}
					avg = (double)sum / scores.length;
					break;
				case 3: 
					for(int i=0; i<stuNo; i++) {
						System.out.printf("scores[%d]> %d \n", i, scores[i]);
					}
					break;
				case 4: 					
					System.out.println("최고점수 : " + max);
					System.out.println("평균 : " + avg);
					break;
				case 5: 
					run = false;
					break;
				default:
					System.out.println("잘못된 값을 입력하였습니다.");
			}			
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
}
