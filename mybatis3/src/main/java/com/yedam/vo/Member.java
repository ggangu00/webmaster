package com.yedam.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// lombok활용.
// 1.eclipse 설치 2.라이브러리

@Getter
@Setter	
@ToString

public class Member {
	
	private String memberId;
	private String password;
	private String memberName;
	private String phone;
	private String responsibility;
	private Date creationDate;
	
}
