package chap01;

import java.io.IOException;


public class System117 {

	public static void main(String[] args){
		int keyCode;
		
		while(true) {
			try {
				System.out.print("키 입력 > ");
				keyCode = System.in.read();				
				
				if(keyCode == 113) { //q키를 입력할 경우
					break;
				}else {
					System.out.println("keyCode: "+keyCode);
				}
				
			} catch (IOException e) { //예외처리
				System.out.println("입력 오류 발생");
			}
			
		}
		System.out.println("종료");
	}//end main

}//end class