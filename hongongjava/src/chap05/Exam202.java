package chap05;

import java.util.Arrays;

public class Exam202 {

	public static void main(String[] args) {
		
		// 배열을 생성
		// 배열을 이용하는 방법
		int[] scores = {83,90,87};
		
		System.out.println("scores[0] : "+scores[0]);
		System.out.println("scores[1] : "+scores[1]);
		System.out.println("scores[2] : "+scores[2]);
		
		int sum=0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.printf("평균 : %.3f", avg);
		System.out.println();
		
		// 배열에 1에서 100까지의 임의의 수 10개를 저장
		// 배열의 합과 평균(소수 첫째자리까지 나타냄),
		// 최대값, 최소값을 구하세요
		
		int nums[] = new int[10];		
		
		for(int i=0; i<10; i++) {
			int ranSu = (int)(Math.random() * 101) + 1;
			nums[i] = ranSu;
		}
		
		int sum2 = 0;
		int max = 0;
		int min = 100;
		for(int i=0; i<nums.length; i++) {
			System.out.println(nums[i]+" ");
			sum2 += nums[i];
			if(max < nums[i])max = nums[i];
			if(min > nums[i])min = nums[i];			
		}
		double avg2 = (double)sum2 / nums.length;
		
		System.out.println(Arrays.toString(nums));		
		System.out.printf("배열의 합 : %d \n", sum2);
		System.out.printf("배열의 평균 : %f \n",avg2);
		System.out.printf("배열의 최소값 : %d \n", min);
		System.out.printf("배열의 최대값 : %d \n", max);
	}

}
