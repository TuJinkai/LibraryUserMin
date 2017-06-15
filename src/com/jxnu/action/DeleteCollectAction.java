package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.apache.struts2.ServletActionContext;

import test.Connecting_To_Database;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteCollectAction extends ActionSupport {
	
	private String page;
	private String book_id;
	@Override
	public String execute() throws Exception {
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "delete from collect_record where Book_Id=?  and User_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, book_id);
			ps.setString(2, ServletActionContext.getRequest().getSession().getAttribute("Id").toString());
			
			int row = ps.executeUpdate();
			if(row>0){
				ps.close();
				conn.close();
				


				if(page.equals("User_shoucang.jsp"))//跳转回原页面 User_shoucang.jsp
					return "User_shoucang";
				else if(page.equals("BookInfo.jsp"))//跳转回原页面 BookInfo.jsp
					return "BookInfo";

				
				
			}
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("取消收藏失败");
			
			e.printStackTrace();
			return ERROR;
		}
		
		
		return ERROR;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	

}
