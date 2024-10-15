package chap06;

public class CalcMain {

	public static void main(String[] args) {
		Calculator myCalcu = new Calculator();
		
		//정사각형의 넓이 구하기
		double result1 = myCalcu.areaRectangle(10);
		
		
		//직사각형의 넓이 구하기
		double result2 = myCalcu.areaRectangle(10,20);
		
		System.out.println("각변의 길이가 10cm인 정사각형의 넓이는 "+result1+" 입니다.");
		System.out.println("가로 길이가 10cm, 세로 길이가 20cm인 직사각형의 넓이는 "+result2+" 입니다.");

	}

}
