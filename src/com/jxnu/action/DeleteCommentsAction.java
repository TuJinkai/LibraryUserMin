package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.Connecting_To_Database;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCommentsAction extends ActionSupport {
	
	private String Book_Id;
	private String book_id;
	private String User_Id;
	private String Comments_Id;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		Book_Id = book_id; 
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "delete from comments where Book_Id=?  and User_Id=? and Comments_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Book_Id);
			ps.setString(2, User_Id);
			ps.setString(3, Comments_Id);
			ps.executeUpdate();
			
			ps.close();
			conn.close();
			
			return  SUCCESS;
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("删除评论失败");
			return  SUCCESS;
		}
		
	
	}

	public String getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public String getUser_Id() {
		return User_Id;
	}

	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}

	public String getComments_Id() {
		return Comments_Id;
	}

	public void setComments_Id(String comments_Id) {
		Comments_Id = comments_Id;
	}
	
	
	

}
