package com.ToDoList.model;
import java.sql.SQLException;
import com.ToDoList.entity.subtask;

public class SubTask {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	private Database myData = null;
	/*增*/
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
	/*删*/
	public boolean delete_subtask(String user_id,String subtask_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_delete_subtask ="delete from sub_task where subtask_yiban_fk="+user_id+"and subtask_id="+subtask_id;
		boolean flag = myData.Database_works(sql_delete_subtask);
		myData.closeAll();
		return flag;
	}
	/*改*/
	public boolean update_subtask(String user_id,String subtask_id,String name) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		subtask newSubtask = new subtask();
		newSubtask.Setsubtask_name(name);
		
		String sql_update = "update subtask set subtask_name='"+newSubtask.Getsubtask_name()+"'"
				+"where subtask_yiban_fk="+user_id+"and subtask_id="+subtask_id;
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
	/*完成子任务*/
	public boolean finish_list(String user_id,String subtask_id,int finish) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		subtask newSubtask = new subtask();
		newSubtask.Setsubtask_flag(finish);
		
		String sql_finish = "update subtask set subtask_flag=\'"+newSubtask.Getsubtask_flag()+"\' where subtask_yiban_fk="+user_id+"and subtask_id="+subtask_id;
		boolean flag = myData.Database_works(sql_finish);
		myData.closeAll();
		return flag;
	}
}
