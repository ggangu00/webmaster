package chap06;

public class Library {
	//필드
	private String name;
	private String num;
	private int price;
	
	public String getName() {
		return name;
	}
	public String getNum() {
		return num;
	}
	public int getPrice() {
		return price;
	}
	
	Library(String name, String num, int price){
		this.name = name;
		this.num = num;
		this.price = price;
	}
	
	
}
