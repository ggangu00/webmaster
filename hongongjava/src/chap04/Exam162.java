package chap04;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 2개를 던져서 합이 5가 되면 종료 - game over
		// 5가 아니면 (1,3) 주사위 눈 표시
		// 몇 번만에 나왔는지?
		
		int num = 0;
		while(true) {
			num++;
			int dice1 = (int)( Math.random() * 6) + 1;	
			int dice2 = (int)( Math.random() * 6) + 1;
			System.out.printf("(%d, %d) ", dice1, dice2);
			
			if(dice1 + dice2 == 5) {
				System.out.printf("\n%d번째만에 game over \n",num);
				break;
			}
		}
		
		// 주사위 눈이 1이면 1등 ... 6이면 6등이라고 출력
		int dice_num = (int)( Math.random() * 6) + 1;
		switch(dice_num) {
			case 1:	System.out.println("1등"); break;	
			case 2: System.out.println("2등"); break;	
			case 3:	System.out.println("3등"); break;	
			case 4: System.out.println("4등"); break;	
			case 5:	System.out.println("5등"); break;	
			case 6:	System.out.println("6등"); break;
			default: System.out.println("잘못된 값 입력");	
		}
		
		// 50에서 100까지 수를 발생 (곱수 = 최종값 - 초기값 + 1)
		// 90이상이면 A, 80이상이면 B, ... 60이상이면 D, 나머지 F
		int score = (int)( Math.random() * 51) + 50;
		
		switch(score/10) {
			case 10:
			case 9:System.out.println("A"); break;	
			case 8: System.out.println("B"); break;	
			case 7:System.out.println("C"); break;	
			case 6: System.out.println("D"); break;	
			default: System.out.println("F");	
		}
		
	}
}
