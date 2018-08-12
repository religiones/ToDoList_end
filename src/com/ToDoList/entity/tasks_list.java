package com.ToDoList.entity;

public class tasks_list {
	private String list_name;
	private int list_flag;
	
	public void Setlist_name(String list_name) {
		this.list_name = list_name;
	}
	
	public String Getlist_name() {
		return list_name;
	}
	
	public void Setlist_flag(int list_flag) {
		this.list_flag = list_flag;
	}
	
	public int Getlist_flag() {
		return list_flag;
	}
}
