package com.ToDoList.model;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ToDoList.entity.userinfo;

public class User {
	private userinfo user = new userinfo();
	private Database myData = null;
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "自己的数据库用户名";
	private String PassWord = "自己的密码";
	
	public userinfo getUser(String id,String name) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		String sql_search = "select * from userinfo where yiban_id = "+id;
		String sql_insert = "insert into userinfo (yiban_id,user_name) values ("+id+","+name+")";
		ResultSet res = myData.Search(sql_search);
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
		return user;
	}
}
