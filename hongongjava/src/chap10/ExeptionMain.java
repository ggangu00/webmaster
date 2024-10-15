package chap10;

public class ExeptionMain {

	public static void main(String[] args) {
		//예외처리
		try {
			Class clazz = Class.forName("java.lang.String2");
			System.out.println(clazz);
		} catch (ClassNotFoundException e) {
			System.out.println("class를 찾을 수 없습니다.");
		}
		
		try {
			String strNum = "123";
			int num = Integer.parseInt(strNum);
			System.out.println(num);
		} catch (Exception e) {
			e.printStackTrace();
//			System.out.println("변경 못함");
		}

	}

}
