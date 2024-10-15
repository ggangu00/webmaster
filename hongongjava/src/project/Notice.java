package project;

public class Notice {
	private String code;
	private String title;
	private String reg_date;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	//생성자
	public Notice() {}
	
	public Notice(String code, String title, String phone, String reg_date) {
		this.code = code;
		this.title = title;
		this.reg_date = reg_date;	
	}
	
	//메소드
	@Override
	public String toString() {
		return code + "\t" + title + "\t" + reg_date;
	}	
}
