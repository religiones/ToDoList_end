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

public class Tasks_setController extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter wrt = response.getWriter();
		/*search database*/
		String Database = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
		DatabaseContext Mydata = new DatabaseContext(Database, "root", "Root.206814");
		try {
			Mydata.DatabaseConnection();
			String sql = "select * from tasks_set where set_yiban_fk = "+request.getParameter("yiban_id");
			ResultSet res = Mydata.Search(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
