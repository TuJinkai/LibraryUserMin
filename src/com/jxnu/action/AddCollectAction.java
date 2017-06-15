package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import test.Connecting_To_Database;

import com.jxnu.dao.impl.CollectDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddCollectAction extends ActionSupport {
	
	private String book_id;

	@Override
	public String execute() throws Exception {
		
		
		CollectDaoImpl collectDaoImpl = new CollectDaoImpl();
		String User_Id =ServletActionContext.getRequest().getSession().getAttribute("Id").toString();
		collectDaoImpl.AddCollect(book_id,User_Id);
		
		return SUCCESS;
		
		
		
		
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	
	
	

}
