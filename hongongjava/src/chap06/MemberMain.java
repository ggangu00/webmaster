package chap06;

public class MemberMain {
	public static void main(String[] args) {
		Member member = new Member();
		Member member2 = new Member("홍길동", "hong");
		
		System.out.println("이름 : "+member.name+"\t나이 : "+member.age);
		System.out.println("이름 : "+member2.name+"\t아이디 : "+member2.id);
	}
}
