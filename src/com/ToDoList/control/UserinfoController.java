package com.ToDoList.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ToDoList.entity.DatabaseContext;
import com.ToDoList.entity.userinfo;

public class UserinfoController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter wrt = response.getWriter();
		/*search database*/
		String Database = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		DatabaseContext Mydata = new DatabaseContext(Database, "root", "Root.206814");
		try {
			Mydata.DatabaseConnection();
			String sql = "select * from userinfo where yiban_id = "+request.getParameter("yiban_id");
			ResultSet res = Mydata.Search(sql);
			userinfo user = adapter(new userinfo(),res);
			wrt.println(user.Getuser_nickname());
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public userinfo adapter(userinfo user,ResultSet res) throws SQLException {
		while(res.next()) {
			user.Setyiban_id(res.getString("yiban_id"));
			user.Setuser_name(res.getString("user_name"));
			user.Setuser_nickname(res.getString("user_nickname"));
			user.Setuser_sex(res.getString("user_sex"));
		}
		return user;
	}
	
}
