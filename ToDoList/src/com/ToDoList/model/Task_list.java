package com.ToDoList.model;
import java.sql.SQLException;
import com.ToDoList.entity.tasks_list;

public class Task_list {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Database myData = null;
	/*增*/
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
	/*删*/
	public boolean delete_list(String user_id,String list_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_delete_list ="delete from tasks_list where list_yiban_fk="+user_id+"and list_id="+list_id;
		boolean flag = myData.Database_works(sql_delete_list);
		myData.closeAll();
		return flag;
	}
	/*改*/
	public boolean update_list(String user_id,String list_id,String name) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_list newList = new tasks_list();
		newList.Setlist_name(name);
		
		String sql_update = "update tasks_list set list_name=\'"+newList.Getlist_name()+"\'"
				+"where list_yiban_fk="+user_id+"and list_id="+list_id;
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
	/*完成任务列表*/
	public boolean finish_list(String user_id,String list_id,int finish) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		tasks_list newList = new tasks_list();
		newList.Setlist_flag(finish);
		
		String sql_finish = "update tasks_set set list_flag=\'"+newList.Getlist_flag()+"\' where list_yiban_fk="+user_id+"and list_id="+list_id;
		boolean flag = myData.Database_works(sql_finish);
		myData.closeAll();
		return flag;
	}
}
