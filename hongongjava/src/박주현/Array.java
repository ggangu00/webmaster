package 박주현;

import java.util.Arrays;

public class Array {

	public static void main(String[] args) {
		//1번
		int nums[] = new int[10];
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<10; i++) {
			int ranNum = (int)(Math.random() * 101) + 1;
			nums[i] = ranNum;
			sum += nums[i];
			if(max < nums[i])max = nums[i];
			if(min > nums[i])min = nums[i];	
		}
		System.out.println(Arrays.toString(nums));	
		System.out.printf("배열의 합 : %d \n", sum);
		System.out.printf("배열의 최소값 : %d \n", min);
		System.out.printf("배열의 최대값 : %d \n", max);
		System.out.println("--------------------------------");
		
		//2번
		int[][] array = {
				{1,2,3},
				{1,2},
				{1},
				{1,2,3}
		};
		
		for(int[] row : array) {
			for(int j : row) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------------------");
		
		//3번
		int[][] seat = new int[3][10];
		int seatCnt=0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<10; j++) {
				seat[i][j] = (int)(Math.random() * 2) + 0;
				System.out.print(seat[i][j]);
				
				if(seat[i][j] == 1) {
					seatCnt++;
				}
			}
			System.out.println();
		}
		System.out.println("현재 관객 수는 "+seatCnt+"명");
		System.out.println("--------------------------------");
		
		//4번
		int[][] test = new int[3][5];
		double avg = 0;
		
		for(int i=0; i<3; i++) {			
			for(int j=0; j<5; j++) {
				test[i][j] = (int)(Math.random() * 51) + 50;
				System.out.print(test[i][j]+"\t");
			}
			System.out.println();
		}
		
		for(int i=0; i<3; i++) {
			int sum2 = 0;
			
			for(int j=0; j<5; j++) {
				sum2 += test[i][j];
			}			
			avg = (double)sum2 / test[i].length;
			System.out.printf("%d번 학생 평균 = %.0f \n",i+1,avg);
		}
		System.out.println("--------------------------------");
		
		//5번
		String[] cardS = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] cardD = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
		int randS = 0;
		int randD = 0;
		for(int i=0; i<5; i++) {
			randS = (int)(Math.random() * 3);
			randD = (int)(Math.random() * 5);
			System.out.printf("%s의 %s \n", cardS[randS], cardD[randD]);
		}
		System.out.println("--------------------------------");
		
		//6번
		int[][] randArr = new int[3][5];
		int noCnt = 0;
		int randNo2 = 0;
		
		for(int i=0; i<randArr.length; i++) {
			for(int j=0; j<randArr[i].length; j++) {
				randNo2 = (int)(Math.random() * 2);
				if(randNo2 == 1) {
					noCnt++;
				}
				
				if(noCnt>5){
					randNo2 = 0;
				}
				System.out.print(randNo2+" ");
			}			
			System.out.println();
		}
	}

}
