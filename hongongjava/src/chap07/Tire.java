package chap07;

public class Tire {
	//필드
	public int maxRotation;
	public int accRotation; //최대회전수
	public String location; //위치
	
	//생성자
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}
	
	//메소드
	public boolean roll() {
		accRotation++;
		if(accRotation < maxRotation) {
			System.out.println(location + "Tire 수명" + (maxRotation - accRotation) + "회 남음");
			return true;
		}else{
			System.out.println("***" + location + "Tire 펑크 ***");
			return false;
		}
	}
}
