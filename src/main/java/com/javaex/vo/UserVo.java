package com.javaex.vo;

public class UserVo {
	
	//필드
	private int no;
	private String id;
	private String password;
	private String userName;
	
	//생성자
	public UserVo() {}
	
	public UserVo(int no, String id, String password, String userName) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.userName = userName;
	}
	
	//메소드-gs
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	
	//메소드-일반
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", id=" + id + ", password=" + password + ", userName=" + userName + "]";
	}

}
