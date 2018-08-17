package com.ToDoList.model;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.ToDoList.entity.task;

public class Add_Task {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Database myData = null;
	
	public boolean add_task(String user_id,String list_id,String name,String description,String begin_time,String deadline_time,String reward,String priority) throws ClassNotFoundException, SQLException {
		Timestamp timeStamp_begin = Timestamp.valueOf(begin_time); 
		Timestamp timeStamp_deadline = Timestamp.valueOf(deadline_time);
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		task newTask = new task();
		newTask.Settask_name(name);
		newTask.Settask_description(description);
		newTask.Settask_begin_time(timeStamp_begin);
		newTask.Settask_deadline(timeStamp_deadline);
		newTask.Settask_rewards(reward);
		newTask.Settask_priority(priority);
		newTask.Settask_finish_flag(0);
		newTask.Settask_overdue(0);
		
		String sql_add ="insert into task(task_yiban_fk,task_list_fk,task_name,task_description,task_begin_time,task_deadline,task_finish_flag,task_overdue)"
				+"values('"+user_id+"','"+list_id+"','"+newTask.Gettask_name()+"','"+newTask.Gettask_description()+"','"+newTask.Gettask_begin_time()+"','"
				+newTask.Gettask_deadline()+"','"+newTask.Gettask_finish_flag()+"','"+newTask.Gettask_overdue()+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
}
