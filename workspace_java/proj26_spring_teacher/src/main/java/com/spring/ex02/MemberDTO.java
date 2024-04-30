package com.spring.ex02;

public class MemberDTO {

	String userID;
	String userName;
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		System.out.println("setUserID 실행");
		this.userID = userID;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		System.out.println("setUserName 실행");
		this.userName = userName;
	}
	
	
	
}
