package com.ToDoList.entity;
import java.util.Date;

public class memo {
	String memo_description;
	Date memo_time;
	
	public void Setmemo_description(String memo_description) {
		this.memo_description = memo_description;
	}
	
	public String Getmemo_description() {
		return memo_description;
	}
	
	public void Setmemo_time(Date memo_time) {
		this.memo_time = memo_time;
	}
	
	public Date Getmemo_time() {
		return memo_time;
	}
}
