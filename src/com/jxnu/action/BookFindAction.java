package com.jxnu.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import test.Connecting_To_Database;

import com.jxnu.dao.impl.BookDaoImpl;
import com.jxnu.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class BookFindAction extends ActionSupport {
	private String bookname;
	private Book book;
	private List<Book>books;

	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		System.out.println("bookname="+bookname);
		if(bookname == null)
			return "emptly";
		BookDaoImpl daoImpl = new BookDaoImpl();
		books = daoImpl.getBookbyName(bookname);
		for(Book book:books){
			System.out.println(book.getBook_Name());
		}
		return SUCCESS;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
	//�����жϸ����Ƿ��ղأ�������һ��String���� 0����1 ��ʾ�Ƿ��ղ�
	private static String UseCollect(String Id,String Book_Id){
		
		String collect="0";
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from collect_record where Book_Id = '"+Book_Id+"' and User_Id = '"+Id+"'";
			ResultSet ps = stmt.executeQuery(sql);
			if(ps.next())
				collect="1";
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return collect;	
	}
	

	
	

}
