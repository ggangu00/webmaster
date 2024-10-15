package project;

public class Product {
	private String code;
	private String cate;
	private String name;
	private int price;
	private String cnt;
	private int avg;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	
	public int getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public Product() {}
	
	
	public Product(String code, String cate, String name, int price, String cnt) {
		this.code = code;
		this.cate = cate;
		this.name = name;
		this.price = price;	
		this.cnt = cnt;
	}
	
	//메소드
	@Override
	public String toString() {
		String star = "";
		for(int i=0; i<=avg; i++) {
			star += "★";
		}
		return code + "\t|" + cate + "\t|" + name + "\t|" + price + "\t|" + cnt + "\t"+ star;
	}	
}
