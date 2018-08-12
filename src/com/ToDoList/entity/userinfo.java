package com.ToDoList.entity;

public class userinfo {
	private String yiban_id;
	private String user_name;
	private String user_nickname;
	private String user_sex;
	
	public void Setyiban_id(String yiban_id) {
		this.yiban_id = yiban_id;
	}
	
	public String Getyiban_id() {
		return yiban_id;
	}
	
	public void Setuser_name(String user_name) {
		this.user_name = user_name;
	}
	
	public String Getuser_name() {
		return user_name;
	}
	
	public void Setuser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	
	public String Getuser_nickname() {
		return user_nickname;
	}
	
	public void Setuser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	
	public String Getuser_sex() {
		return user_sex;
	}
}
