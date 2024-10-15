package 박주현;

public class Account {
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 10000000;
	
	private String no;
	private String owner;
	private int balence;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getBalence() {
		return balence;
	}
	public void setBalence(int balence) {
		if(balence < Account.MIN_BALANCE) {
			this.balence = Account.MIN_BALANCE;
		}else if(balence>Account.MAX_BALANCE) {
			this.balence = Account.MAX_BALANCE;
		}else {
			this.balence = balence;
		}
	}
	
	Account(){};
	Account(String no, String owner, int balence){
		this.no = no;
		this.owner = owner;
		this.balence = balence;
	}
	
	void InMoney(String no, int balence){
		this.no = no;
		this.balence = balence;		
	}
	 
}
