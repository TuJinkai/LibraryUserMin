package com.jxnu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.CollectDaoImpl;
import com.jxnu.model.Book;


import com.opensymphony.xwork2.ActionSupport;

public class ShowCollectAction extends ActionSupport {
	
	private List<Book>book;
	
	 @Override
	public String execute() throws Exception {
		 book = null;
		 String User_Id = ServletActionContext.getRequest().getSession().getAttribute("Id").toString();
		 CollectDaoImpl collectDaoImpl = new CollectDaoImpl();
		 book = collectDaoImpl.getCollectBooksByUserId(User_Id);
		// TODO 自动生成的方法存根
		return SUCCESS;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}


	 
	 
	 

}
