package com.ToDoList.entity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ToDoList.model.Task;

public class deletetask extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private String user_id = null;
	private String task_id = null;
	private Task newTask = null;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("GBK"); //编码统一
		user_id = request.getParameter("user_id");
		task_id = request.getParameter("task_id");
		/*设置回复格式*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setContentType("application/json; charList=utf-8");
		PrintWriter out = response.getWriter();
		newTask = new Task();
		try {
			boolean result = newTask.delete_task(user_id,task_id);
			if(result) {
				/*删除成功*/
				String jsonStr =  "{\"successfully\":\"001\"}";
				out.write(jsonStr);
				out.close();
			}else {
				/*删除失败*/
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
