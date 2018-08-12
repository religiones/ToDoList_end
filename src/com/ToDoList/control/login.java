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

@SuppressWarnings("serial")
public class login extends HttpServlet{
	private userinfo user;
	private String id;
	private String name;
	private User myuser = new User();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		name = request.getParameter("name");
		try {
			user = myuser.getUser(id,name);
			if(user == null) {
				/*用户不存在且注册失败*/
				response.setHeader("Access-Control-Allow-Origin", "*");
				response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE"); 
				response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization"); 
				response.setContentType("application/json; charset=utf-8");
				
				PrintWriter out = response.getWriter();
				String jsonStr =  "{\"error\":\"0x777\"}";
				out.write(jsonStr);
				out.close();
				
			}else {
				/*返回网页并传参*/
				response.sendRedirect("/ToDoList/index.html?name="+user.Getuser_name());
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
