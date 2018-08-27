package com.ToDoList.model;
import java.sql.SQLException;
import java.sql.Timestamp;
import com.ToDoList.entity.memo;
import com.ToDoList.model.Get_Tasks;

public class Memo {
	private String DataName = "jdbc:mysql://localhost:3306/ToDoList?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=GMT";
	private String UserName = "root";
	private String PassWord = "Root.206814";
	private Database myData = null;
	/*add*/
	public boolean add_memo(String user_id,String description,String time) throws ClassNotFoundException, SQLException {
		Timestamp crt_time = Timestamp.valueOf(time);
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();

		memo newMemo = new memo();
		
		newMemo.Setmemo_description(description);
		newMemo.Setmemo_time(crt_time);

		String sql_add ="insert into memo(memo_description,memo_time,memo_yiban_fk)"
				+ "values('"+newMemo.Getmemo_description()+"','"+newMemo.Getmemo_time()+"','"+user_id+"')";
		boolean flag = myData.Database_works(sql_add);
		myData.closeAll();
		return flag;
	}
	/*delete*/
	public boolean delete_memo(String user_id,String memo_id) throws ClassNotFoundException, SQLException {
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		String sql_delete_memo ="delete from memo where memo_yiban_fk='"+user_id+"'and memo_id='"+memo_id+"'";
		boolean flag = myData.Database_works(sql_delete_memo);
		myData.closeAll();
		return flag;
	}
	/*search*/
	public String Get_memo(String user_id) throws ClassNotFoundException, SQLException{
		String sql = "select * from memo where memo_yiban_fk='"+user_id+"'";
		String memo = Get_Tasks.get_array(sql);
		String json = "{\"memo\" : "+memo+"}";
		return json;
	}
	/*update*/
	public boolean update_memo(String user_id,String memo_id,String description,String time) throws ClassNotFoundException, SQLException {
		Timestamp crt_time = Timestamp.valueOf(time);
		myData = new Database(DataName, UserName, PassWord);
		myData.DatabaseConnection();
		
		memo newMemo = new memo();
		newMemo.Setmemo_description(description);
		newMemo.Setmemo_time(crt_time);
		
		String sql_update = "update memo set memo_description='"+newMemo.Getmemo_description()+"',memo_time='"+newMemo.Getmemo_time()
				+"'where memo_yiban_fk='"+user_id+"' and memo_id='"+memo_id+"'";
		boolean flag = myData.Database_works(sql_update);
		myData.closeAll();
		return flag;
	}
}
