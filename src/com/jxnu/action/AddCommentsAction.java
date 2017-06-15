package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import test.Connecting_To_Database;

import com.opensymphony.xwork2.ActionSupport;

public class AddCommentsAction extends ActionSupport {
	
	private String Book_Id;
	private String book_id;
	private String Comments_Info;

	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		
		Date time = new Date();
		String Time = time.toString();//��ȡϵͳʱ��
		Book_Id = book_id; 
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "insert into comments (Book_Id,User_Id,Comments_Time,Comments_Info,User_Name,User_Img) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Book_Id);
			ps.setString(2, ServletActionContext.getRequest().getSession().getAttribute("Id").toString());
			ps.setString(3, Time);
			ps.setString(4, Comments_Info);
			ps.setString(5, ServletActionContext.getRequest().getSession().getAttribute("Name").toString());
			ps.setString(6, FindUserImg(ServletActionContext.getRequest().getSession().getAttribute("Id").toString()));
			
			int row = ps.executeUpdate();
			if(row>0){
				ps.close();
				conn.close();
				return SUCCESS;
			}
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			System.out.println("����ʧ��");
			e.printStackTrace();
			return ERROR;
		}
		
		return ERROR;
	}

	public String getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}

	public String getComments_Info() {
		return Comments_Info;
	}

	public void setComments_Info(String comments_Info) {
		Comments_Info = comments_Info;
	}
	
	
	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	//��������ͷ�񲢷���
	protected String FindUserImg(String User_Id){
		
		String User_Img = "images/Book_Main_imgs/demo.jpg";
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "select * from user where Id='"+User_Id+"'";
			Statement stmt = conn.createStatement();//��ȡStatement����
			ResultSet rs = stmt.executeQuery(sql);
			
			
			while(rs.next()){
				User_Img = rs.getString("Img");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
			
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return User_Img;
		
		
		
	}
	

}
