package chap06;

public class MemberService {
	//필드
	String id = "hong";
	String password = "12345";
	
	
	//생성자
	
	//메소드
	boolean login(String n, String m) {
		if(id.equals(n) && password.equals(m)) {			
			return true;
		}else {
			return false;
		}
	}
	
	void logout(String n) {
		System.out.println(n+"님 로그아웃되었습니다.");
	}
}
