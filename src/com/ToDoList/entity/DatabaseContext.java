package com.ToDoList.entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseContext {
	private String username;
	private String password;
	private String Database;
	private Connection conn;
	private Statement stmt;
	private ResultSet result;

	public DatabaseContext(String Database,String username,String password) {
		this.username = username;
		this.password = password;
		this.Database = Database;
		this.conn = null;
		this.stmt = null;
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
    }
    
	/*Search information*/
	public ResultSet Search(String sql) throws SQLException {
		stmt = conn.createStatement();
		result = stmt.executeQuery(sql);
		return result;
	}
	
	/*Insert or Delete or Update information,return how many messages have been updated*/
	public int Database_works(String sql) throws SQLException {
		stmt = conn.createStatement();
		int count = stmt.executeUpdate(sql);
		return count;
	}
}
