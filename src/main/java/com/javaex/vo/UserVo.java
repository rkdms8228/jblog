package com.javaex.vo;

public class UserVo {
	
	//필드
	private int userNo;
	private String id;
	private String password;
	private String userName;
	private String regDate;
	
	//생성자
	public UserVo() {}
	
	public UserVo(int userNo, String id, String password, String userName, String regDate) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.userName = userName;
		this.regDate = regDate;
	}
	
	//메소드-gs
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [userNo=" + userNo + ", id=" + id + ", password=" + password + ", userName=" + userName + ", regDate="
				+ regDate + "]";
	}

}
