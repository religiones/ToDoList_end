package com.ToDoList.model;
import java.sql.SQLException;
import com.ToDoList.entity.tasks_list;

public class Add_Task_list {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Database myData = null;
	
	public boolean add_list(String user_id,String name,String set_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_list newList = new tasks_list();
		newList.Setlist_flag(0);
		newList.Setlist_name(name);

		String sql_add ="insert into tasks_list(list_name,list_yiban_fk,list_set_fk,list_flag)"
				+ "values('"+newList.Getlist_name()+"','"+user_id+"','"+set_id+"','"+newList.Getlist_flag()+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
}
