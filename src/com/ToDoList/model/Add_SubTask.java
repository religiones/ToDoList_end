package com.ToDoList.model;
import java.sql.SQLException;
import com.ToDoList.entity.subtask;

public class Add_SubTask {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Database myData = null;
	
	public boolean add_subtask(String user_id,String task_id,String name) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		subtask newSubtask = new subtask();
		newSubtask.Setsubtask_name(name);
		newSubtask.Setsubtask_flag(0);
		
		String sql_add ="insert into subtask(subtask_name,subtask_yiban_fk,subtask_task_fk,subtask_flag)"
				+ "values('"+newSubtask.Getsubtask_name()+"','"+user_id+"','"+task_id+"','"+newSubtask.Getsubtask_flag()+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
}
