package com.ToDoList.model;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import com.google.gson.Gson;

public class Get_Tasks {
	private static String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private static String UserName = "数据库用户名";
	private static String PassWord = "数据库密码";
	
	/*获取任务*/
	public String GetTasks(String id) throws ClassNotFoundException, SQLException {
		String sql_tasks_set = "select * from tasks_set where set_yiban_fk = "+id;
		String sql_tasks_list = "select * from tasks_list where list_yiban_fk = "+id;
		String sql_task = "select * from task where task_yiban_fk = "+id;
		String sql_subtask = "select * from subtask where subtask_yiban_fk = "+id;
			
		String Tasks_set = get_array(sql_tasks_set);
		String Tasks_list = get_array(sql_tasks_list);
		String Task = get_array(sql_task);
		String SubTask = get_array(sql_subtask);

		String json = "{\"Tasks_set\" : "+Tasks_set+", \"Tasks_list\" : "+Tasks_list+
				", \"Task\" : "+Task+", \"SubTask\" : "+SubTask+"}";

		return json;
	}
	
	/*以数组的方式存储json对象*/
	public static String get_array(String sql) throws ClassNotFoundException, SQLException {
		Database myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		ResultSet res = myData.Search(sql);
		String[] ColumnName = getColumnName(res);
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        //数据保存为JSON格式
        while(res.next()) {
            Map<String,String> map = new HashMap<String,String>();//要每次创建一个新的映射表，不然只会保存最后一组数据。
            for(int i=0;i<ColumnName.length;i++) {
            	map.put(ColumnName[i], res.getString(i+1));
            }
            list.add(map);//数据保存在list中
        }
        //用GSON包中的方法序列化json字符串
        Gson gson = new Gson();
        String jsonstr = gson.toJson(list); 
		myData.closeAll();
		return jsonstr;
	}
	
	/*获取列名 并存入数组*/
	public static String[] getColumnName(ResultSet res) throws SQLException {
		ResultSetMetaData rsmd = res.getMetaData();
		int count = rsmd.getColumnCount();
		String[] Column=new String[count];
		for(int i=0;i<count;i++)
		{
			Column[i]=rsmd.getColumnName(i+1);
		}
		return Column;	
	}
}
