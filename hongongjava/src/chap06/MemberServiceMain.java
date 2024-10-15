package chap06;

public class MemberServiceMain {

	public static void main(String[] args) {
		MemberService myMember = new MemberService();
		
		boolean result = myMember.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 성공!");		
			myMember.logout("hong");	
		}else {
			System.out.println("로그인 정보가 일치하지 않습니다.");
		}
	}
}
