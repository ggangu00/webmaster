package chap06;

public class StudentMain {

	public static void main(String[] args) {
		//객체 생성
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균\t등급");
		String[] nameArr = {"김민진", "권나윤", "배서진", "표하연", "박주현"};
		for(int i=0; i<nameArr.length; i++) {
			
			int korNum = (int)( Math.random() * 100) + 1;
			int engNum = (int)( Math.random() * 100) + 1;
			int mathNum = (int)( Math.random() * 100) + 1;
			
			Student stu = new Student(i+1, nameArr[i], korNum, engNum, mathNum);
			
			System.out.println("------------------------------------------------------------");
			System.out.printf("%d번\t%S\t%d\t%d\t%d\t%d\t%.2f\t%s \n", stu.stNo, stu.name, stu.kor, stu.eng, stu.math, stu.total(), stu.avg(), stu.grade());
			
		}
	}
}