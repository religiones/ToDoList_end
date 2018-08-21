package com.ToDoList.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
	private String username;
	private String password;
	private String Database;
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstm;
	private ResultSet result;

	public Database(String Database,String username,String password) {
		this.username = username;
		this.password = password;
		this.Database = Database;
		this.conn = null;
		this.stmt = null;
		this.pstm = null;
		this.result = null;
	}
	
	/*Connect to the database*/
	public void DatabaseConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(Database, username, password);
	}
	
	/*Close all*/
    public void closeAll() throws SQLException {
        if(result!=null) {
            result.close();
        }
        if(stmt!=null) {
            stmt.close();
        }
        if(conn!=null) {
            conn.close();
        }
        if(pstm!=null) {
        	pstm.close();
        }
    }
    
	/*Search information*/
	public ResultSet Search(String sql) throws SQLException {
		stmt = conn.createStatement();
		result = stmt.executeQuery(sql);
		return result;
	}
	
	/*Insert or Delete or Update information,return how many messages have been updated*/
	public boolean Database_works(String sql){
		boolean flag = false;
		try {
			pstm = conn.prepareStatement(sql); 
			pstm.executeUpdate();
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
