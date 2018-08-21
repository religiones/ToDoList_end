package com.ToDoList.control;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ToDoList.entity.userinfo;
import com.ToDoList.model.User;


public class login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private userinfo user = null;
	private String id = null;
	private String name = null;
	private User myuser = new User();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("GBK"); //编码统一
		id = request.getParameter("id");
		name = request.getParameter("name");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
		response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		try {
			user = myuser.getUser(id,name);
			if(user == null) {
				/*用户创建失败*/
				String jsonStr =  "{\"error\":\"0x777\"}";
				out.write(jsonStr);
				out.close();
			}else {
				/*登录成功*/
				response.sendRedirect("/ToDoList/index.html?name="+user.Getuser_name());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
