package com.ToDoList.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ToDoList.model.Task;

public class newtask extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Task task = new Task();
	private String user_id = null;
	private String list_id = null;
	private String name = null;
	private String description = null;
	private String begin_time = null;
	private String deadline_time = null;
	private String reward = null;
	private String priority = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8"); 
		user_id = request.getParameter("id");
		list_id = request.getParameter("list_id");
		name = request.getParameter("name");
		description = request.getParameter("description");
		begin_time = request.getParameter("begin_time");
		deadline_time = request.getParameter("deadline_time");
		reward = request.getParameter("reward");
		priority = request.getParameter("priority");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		task = new Task();
		try {
			boolean result = task.add_task(user_id, list_id, name, description, begin_time, deadline_time, reward, priority);
			if(result) {
				/*successful*/
				String jsonStr =  "{\"successfully\":\"001\"}";
				out.write(jsonStr);
				out.close();
			}else {
				/*failed*/
				String jsonStr =  "{\"error\":\"0x777\"}";
				out.write(jsonStr);
				out.close();
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
