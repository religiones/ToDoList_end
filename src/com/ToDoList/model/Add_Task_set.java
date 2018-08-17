package com.ToDoList.model;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import com.ToDoList.entity.tasks_set;

public class Add_Task_set {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Date date = null;
	private Database myData = null;
	
	public boolean add_set(String user_id,String name,String description) throws ClassNotFoundException, SQLException {
		date = new Date();
		Timestamp timeStamp = new Timestamp(date.getTime());
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_set newSet = new tasks_set();
		newSet.Setset_name(name);
		newSet.Setset_description(description);
		newSet.Setset_create_time(timeStamp);
		newSet.Setset_flag(0);
		
		String sql_add ="insert into tasks_set(set_name,set_yiban_fk,set_create_time,set_description,set_flag)"
				+ "values('"+newSet.Getset_name()+"','"+user_id+"','"+newSet.Getset_create_time()+"','"+newSet.Getset_description()+"','"+newSet.Getset_flag()+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
}
