package com.ToDoList.model;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import com.ToDoList.entity.task;


public class Task {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "root";
	private String PassWord = "Root.206814";
	private Database myData = null;
	private Date date = null;
	/*add*/
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
		
		String sql_add ="insert into task(task_yiban_fk,task_list_fk,task_name,task_description,task_begin_time,task_deadline,task_finish_flag,task_overdue,task_rewards,task_priority)"
				+"values('"+user_id+"','"+list_id+"','"+newTask.Gettask_name()+"','"+newTask.Gettask_description()+"','"+newTask.Gettask_begin_time()+"','"
				+newTask.Gettask_deadline()+"','"+newTask.Gettask_finish_flag()+"','"+newTask.Gettask_overdue()+"','"+newTask.Gettask_rewards()+"','"+newTask.Gettask_priority()+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
	/*delete*/
	public boolean delete_task(String user_id,String task_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_delete_task ="delete from task where task_yiban_fk='"+user_id+"'and task_id='"+task_id+"'";
		boolean flag = myData.Database_works(sql_delete_task);
		myData.closeAll();
		return flag;
	}
	/*update*/
	public boolean update_task(String user_id,String task_id,String name,String description,String begin_time,String deadline_time,String reward,String priority) throws ClassNotFoundException, SQLException {
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
		String sql_update = "update task set task_name='"+newTask.Gettask_name()+"',task_description='"+newTask.Gettask_description()+"',task_begin_time='"+newTask.Gettask_begin_time()+"',task_deadline='"
				+newTask.Gettask_deadline()+"',task_rewards='"+newTask.Gettask_rewards()+"',task_priority='"+newTask.Gettask_priority()+"'"
				+"where task_yiban_fk='"+user_id+"'and task_id='"+task_id+"'";
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
	/*finish*/
	public boolean finish_task(String user_id,String task_id,int finish,float score,String deadline_time) throws ClassNotFoundException, SQLException {
		String sql_finish = null;
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		date = new Date();
		Timestamp timecurr = new Timestamp(date.getTime());
		Timestamp timedead = Timestamp.valueOf(deadline_time);
		task newTask = new task();
		newTask.Settask_finish_flag(finish);
		newTask.Settask_finish_time(timecurr);
		newTask.Settask_score(score);
		if(timecurr.before(timedead)) {
			/*no overdue*/
			sql_finish = "update task set task_finish_flag ='"+newTask.Gettask_finish_flag()+"',task_finish_time ='"+newTask.Gettask_finish_time()+"',task_score ='"+newTask.Gettask_score()+"' where task_yiban_fk ='"+user_id+"'and task_id ='"+task_id+"'";
		}else {
			/*overdue*/
			newTask.Settask_overdue(1);
			sql_finish = "update task set task_finish_flag ='"+newTask.Gettask_finish_flag()+"',task_finish_time ='"+newTask.Gettask_finish_time()+"',task_overdue ='"+newTask.Gettask_overdue()+"',task_score ='"+newTask.Gettask_score()+"' where task_yiban_fk ='"+user_id+"'and task_id ='"+task_id+"'";
		}
		boolean flag = myData.Database_works(sql_finish);
		myData.closeAll();
		return flag;
	}
}
