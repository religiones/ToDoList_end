package com.ToDoList.model;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ToDoList.entity.userinfo;

public class User {
	private userinfo user = null;
	private Database myData = null;
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "数据库用户名";
	private String PassWord = "数据库密码";
	
	public userinfo getUser(String id,String name) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		String sql_search = "select * from userinfo where yiban_id = "+id;
		String sql_insert = "insert into userinfo (yiban_id,user_name) values ("+id+","+name+")";
		ResultSet res = myData.Search(sql_search);
		user = new userinfo();
		if(res == null) {
			/*用户不存在,插入数据*/
			boolean flag = myData.Database_works(sql_insert);
			if(flag) {
				user.Setyiban_id(id);
				user.Setuser_name(name);
			}else {
				return null;
			}
		}else {
			/*存在该用户*/
			while(res.next()) {
				user.Setyiban_id(res.getString("yiban_id"));
				user.Setuser_name(res.getString("user_name"));
			}
		}
		myData.closeAll();
		return user;
	}
	/*查询用户信息*/
	public String GetUserinfo(String user_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_search = "select * from userinfo where yiban_id="+user_id;
		ResultSet res = myData.Search(sql_search);
		user = new userinfo();
		user.Setyiban_id(user_id);
		while(res.next()) {
			user.Setuser_name(res.getString("user_name"));
			user.Setuser_nickname(res.getString("user_nickname"));
			user.Setuser_sex(res.getString("user_sex"));
		}
		String json = "{\"yiban_id\" : "+user.Getyiban_id()+",\"user_name\" : "+user.Getuser_name()+",\"user_nickname\" : "+user.Getuser_nickname()+",\"user_sex\" : "+user.Getuser_sex()+"}";
		return json;
	}
	/*修改用户信息*/
	public boolean update_user(String user_id,String user_name,String user_nickname,String user_sex) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		user = new userinfo();
		user.Setuser_name(user_name);
		user.Setuser_nickname(user_nickname);
		user.Setuser_sex(user_sex);
		String sql_update = "update userinfo set user_name='"+user.Getuser_name()+"',user_nickname='"+user.Getuser_nickname()+"',user_sex='"+user.Getuser_sex()+"'where yiban_id="+user_id;
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
}
