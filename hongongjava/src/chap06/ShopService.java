package chap06;

public class ShopService {
	
	//싱글톤 기법 사용
	//필드 -> 자신의 객체 저장
	private static ShopService ss = new ShopService();
	
	//생성자
	private ShopService() {};
	
	//메소드
	static ShopService getInstance() {
		return ss;
	}
}
