package com.jxnu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="collect_record")
public class Collect {
	
	private int Record_Id;
	private String Book_Id;
	private String User_Id;
	private String Record_Time;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getRecord_Id() {
		return Record_Id;
	}
	public void setRecord_Id(int record_Id) {
		Record_Id = record_Id;
	}
	public String getBook_Id() {
		return Book_Id;
	}
	public void setBook_Id(String book_Id) {
		Book_Id = book_Id;
	}
	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getRecord_Time() {
		return Record_Time;
	}
	public void setRecord_Time(String record_Time) {
		Record_Time = record_Time;
	}
	
	
	
	

}
