package com.ToDoList.model;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import com.ToDoList.entity.tasks_set;

public class Task_set {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "root";
	private String PassWord = "Root.206814";
	private Date date = null;
	private Database myData = null;
	/*add*/
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
	/*delete*/
	public boolean delete_set(String user_id,String set_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_delete_set ="delete from tasks_set where set_yiban_fk= '"+user_id+"' and set_id= '"+set_id+"'";
		boolean flag = myData.Database_works(sql_delete_set);
		myData.closeAll();
		return flag;
	}
	/*update*/
	public boolean update_set(String user_id,String set_id,String name,String description) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_set newSet = new tasks_set();
		newSet.Setset_name(name);
		newSet.Setset_description(description);
		
		String sql_update = "update tasks_set set set_name='"+newSet.Getset_name()+"',set_description='"+newSet.Getset_description()+"'"
				+"where set_yiban_fk='"+user_id+"'and set_id='"+set_id+"'";
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
	/*finish*/
	public boolean finish_set(String user_id,String set_id,int finish) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_set newSet = new tasks_set();
		newSet.Setset_flag(finish);
		
		String sql_finish = "update tasks_set set set_flag='"+newSet.Getset_flag()+"' where set_yiban_fk='"+user_id+"'and set_id='"+set_id+"'";
		boolean flag = myData.Database_works(sql_finish);
		myData.closeAll();
		return flag;
	}
}
