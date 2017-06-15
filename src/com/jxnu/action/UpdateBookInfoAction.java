package com.jxnu.action;

import com.jxnu.dao.impl.BookDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateBookInfoAction extends ActionSupport {
	
	private String book_id;
	private String Book_Info;
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getBook_Info() {
		return Book_Info;
	}
	public void setBook_Info(String book_Info) {
		Book_Info = book_Info;
	}
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		bookDaoImpl.updateBookInfo(book_id, Book_Info);
		return SUCCESS;
	}
	

}
