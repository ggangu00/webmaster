package chap03;

public class Exam150 {

	public static void main(String[] args) {
		
		//문제4
		int pencils = 534;
		int students = 30;
		
		//학생 1명이 가지는 연필 개수
		int pencilsPerStudnt = pencils/students;
		System.out.println(pencilsPerStudnt);
		
		//남은 연필 개수
		int perncilsLeft = pencils%students;
		System.out.println(perncilsLeft);
	}
}
