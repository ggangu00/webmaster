package chap01;

public class Escape88 {

	public static void main(String[] args) { //static : 객체 없이 사용 가능, void : return 값 없음
		// TODO Auto-generated method stub
		System.out.println("번호\t이름\t작업");
		System.out.print("행 단위 출력\n");
		System.out.print("행 단위 출력\n");
		System.out.println("우리는 \"개발자\" 입니다.");
		System.out.print("봄\\여름\\가을\\겨울\n");
		
		//p.91
		//예제에 시작합니다 출력되도록 변경
		boolean stop = true;
		if(!stop){
			System.out.println("중지합니다.");
		}else {
			System.out.println("시작합니다.");
		}
		
		//p.103
		//타입 변환
		byte byteValue1 = 10;
		byte byteValue2 = 20;
		//byte byteValue3 = byteValue1 + byteValue2; 컴파일 에러
		int intValue1 = byteValue1 + byteValue2;
		System.out.println(intValue1);
		
		char charValue1 = 'A';
		char charValue2 = 1;
		//char byteValue3 = byteValue1 + byteValue2; 컴파일 에러
		int intValue2 = charValue1 + charValue2;
		System.out.println("유니코드 = "+intValue2);
		System.out.println("출력문자 = "+(char)intValue2);
		
		int intValue3 = 10;
		int intValue4 = intValue3/4;
		System.out.println(intValue4);
		
		int intValue5 = 10;
		//int intValue6 - 10/4.0; 컴파일 에러
		double doubleValue = intValue5 / 4.0;
		System.out.println(doubleValue);
		
		int x = 1;
		int y = 2;
		double result = (double)x/y;
		System.out.println(result);
		
		//p.106
		//문자열->숫자, 숫자->문자열 변환		
		
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true");
		
		//문자를 숫자로 출력
		System.out.println("value1: " + value1 + 100);
		System.out.println("value2: " + value2 + 100);
		System.out.println("value3: " + value3 + 100);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true);
		
		//숫자를 문자로 출력
		System.out.println("str1: " + str1 + 100);
		System.out.println("str2: " + str2 + 100);
		System.out.println("str3: " + str3 + 100);
		
		//확인문제5
		char c1='a';
		char c2 = (char)(c1+1);
		System.out.println((int)c2);
		
		String stri1 = ""+2+3;
		System.out.println(stri1);
		
		int x1= 5;
		int y1=2;
		double result1 = x1/y1;
		System.out.println(result1);
		
		long var11 = 2L;
		float var21 = 1.8f;
		double var31 = 2.5;
		String var4 = "3.9";
		int result2 = (int) var11 + (int)(var21 +var31) + (int)Double.parseDouble(var4); //int와 double이 연산되면 오류 = double을 int로 치환하여 연산
		System.out.println(result2);
		
		System.out.printf("이름 : %s 나이 : %d \n", "박주현", 25);
		
	} // end main
}
