package chap06;

public class Computer {
	//메소드
	int sum1(int[] values) {
		int sum =0;
		for (int i=0; i<values.length; i++) {
			sum += values [i];
		}
		return sum;
	}
	
	int sum2(int ... values) {
		int sum = 0;
		for(int j : values) {
			sum += j;
		}
		return sum;
	}
	
	
	//생성자
	
	//메소드

}
