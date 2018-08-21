package com.ToDoList.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ToDoList.model.Task_list;

public class newlist extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private Task_list task_list = null;
	private String set_id = null;
	private String user_id = null;
	private String name = null;
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("GBK"); //编码统一
		set_id = request.getParameter("set_id");
		user_id = request.getParameter("user_id");
		name = request.getParameter("name");
		/*设置回复格式*/
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		task_list = new Task_list();
		try {
			boolean result = task_list.add_list(user_id, name, set_id);
			if(result) {
				/*添加成功*/
				String jsonStr =  "{\"successfully\":\"001\"}";
				out.write(jsonStr);
				out.close();
			}else {
				/*添加失败*/
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
