package com.ToDoList.entity;
import java.util.Date;

public class task {
	private String task_name;
	private String task_description;
	private Date task_begin_time;
	private Date task_deadline;
	private Date task_finish_time;
	private int task_finish_flag;
	private int task_overdue;
	private float task_score;
	private String task_rewards;
	private String task_priority;
	
	public void Settask_name(String task_name) {
		this.task_name = task_name;
	}
	
	public String Gettask_name() {
		return task_name;
	}
	
	public void Settask_description(String task_description) {
		this.task_description = task_description;
	}
	
	public String Gettask_description() {
		return task_description;
	}
	
	public void Settask_begin_time(Date task_begin_time) {
		this.task_begin_time = task_begin_time;
	}
	
	public Date Gettask_begin_time() {
		return task_begin_time;
	}
	
	public void Settask_deadline(Date task_deadline) {
		this.task_deadline = task_deadline;
	}
	
	public Date Gettask_deadline() {
		return task_deadline;
	}
	
	public void Settask_finish_time(Date task_finish_time) {
		this.task_finish_time = task_finish_time;
	}
	
	public Date Gettask_finish_time() {
		return task_finish_time;
	}
	
	public void Settask_finish_flag(int task_finish_flag) {
		this.task_finish_flag = task_finish_flag;
	}
	
	public int Gettask_finish_flag() {
		return task_finish_flag;
	}
	
	public void Settask_overdue(int task_overdue) {
		this.task_overdue = task_overdue;
	}
	
	public int Gettask_overdue() {
		return task_overdue;
	}
	
	public void Settask_score(float task_score) {
		this.task_score = task_score;
	}
	
	public float Gettask_score() {
		return task_score;
	}
	
	public void Settask_rewards(String task_rewards) {
		this.task_rewards = task_rewards;
	}
	
	public String Gettask_rewards() {
		return task_rewards;
	}
	
	public void Settask_priority(String task_priority) {
		this.task_priority = task_priority;
	}
	
	public String Gettask_priority() {
		return task_priority;
	}
}
