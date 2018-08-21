package com.ToDoList.entity;
import java.util.Date;

public class tasks_set {
	private String set_name;
	private Date set_create_time;
	private String set_description;
	private int set_flag;
	
	public void Setset_name(String set_name) {
		this.set_name = set_name;
	}
	
	public String Getset_name() {
		return set_name;
	}
	
	public void Setset_create_time(Date set_create_time) {
		this.set_create_time = set_create_time;
	}
	
	public Date Getset_create_time() {
		return set_create_time;
	}
	
	public void Setset_description(String set_description) {
		this.set_description = set_description;
	}
	
	public String Getset_description() {
		return set_description;
	}
	
	public void Setset_flag(int set_flag) {
		this.set_flag = set_flag;
	}
	
	public int Getset_flag() {
		return set_flag;
	}
}
