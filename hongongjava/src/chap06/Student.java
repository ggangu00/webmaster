package chap06;

public class Student {
	//필드(속성)
	int stNo;
	String name;
	int kor;
	int eng;
	int math;
	
	//생성자(객체 생성) -> 객체의 속성을 초기화
	Student(int stNo, String name, int kor, int eng, int math){
		this.stNo = stNo;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드(기능)
	int total() {
		return this.kor + this.eng + this.math;
	}
	
	double avg() {
		return (double)total()/3;
	}
	
	String grade() {
		int num = (int)avg() / 10;
		switch(num) {
			case 10:
			case 9: return "A";
			case 8: return "B";
			case 7: return "C";
			case 6: return "D";
			default : return "F";
			
		}
	}
}
