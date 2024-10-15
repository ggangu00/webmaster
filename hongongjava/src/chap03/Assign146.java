package chap03;

public class Assign146 {

	public static void main(String[] args) {
		int result = 0;
		
		result += 10;
		System.out.println("result = " + result);
		
		result -= 5;
		System.out.println("result = " + result);
		
		result *= 3;
		System.out.println("result = " + result);
		
		result /= 5;
		System.out.println("result = " + result);
		
		result %= 3;
		System.out.println("result = " + result);
		
		int su = 2;
		int su2 = 2;
		System.out.println(su & su2);
		System.out.println(su | su2);
		System.out.println(su ^ su2);
		
		/* &연산      |연산      ^연산
		 
		   0 1       0 1       0 1
		&) 1 0    |) 1 0    ^) 1 0
		 ------    ------    ------
		   0 0       1 1       1 1
		 */
		
		int x = 10;
		int y = 5;
		System.out.println((x>7)&&(y<=5));
	}

}
