package com.jxnu.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	private String Comments_Id;
	private String Book_Id;
	private String User_Name;
	private String Comments_Info;
	private String Comments_Time;
	private String User_Img;
	
	@Id
	public String getComments_Id() {
		return Comments_Id;
	}
	public void setComments_Id(String comments_Id) {
		Comments_Id = comments_Id;
	}
	public String getBook_Id() {
		return Book_Id;
	}
	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getComments_Info() {
		return Comments_Info;
	}
	public void setComments_Info(String comments_Info) {
		Comments_Info = comments_Info;
	}
	public String getComments_Time() {
		return Comments_Time;
	}
	public void setComments_Time(String comments_Time) {
		Comments_Time = comments_Time;
	}
	public String getUser_Img() {
		return User_Img;
	}
	public void setUser_Img(String user_Img) {
		User_Img = user_Img;
	}
	
	

}
