package com.jxnu.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.BookDao;
import com.jxnu.dao.impl.BookDaoImpl;

import test.Connecting_To_Database;

import com.jxnu.model.Book;
import com.opensymphony.xwork2.ActionSupport;

public class ShowBookMain extends ActionSupport {
	
	private String book_id;
	private List<Book> book;
	private String collectd;
	private String bookurl;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		System.out.println("访问的图书id为："+book_id);
		BookDaoImpl bookDaoImpl = new BookDaoImpl();
		book = bookDaoImpl.getBookbyId(book_id);
		System.out.println("bookurl="+bookurl);
		collectd = "0";
		try {
			collectd = UseCollect(ServletActionContext.getRequest().getSession().getAttribute("Id").toString(),book_id);
			System.out.println("来自登录用户的访问");
			return SUCCESS;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("来自未登录用户的访问");
		}
		
			return SUCCESS;
		
	}

	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public String getCollectd() {
		return collectd;
	}

	public void setCollectd(String collectd) {
		this.collectd = collectd;
	}


	public String getBookurl() {
		return bookurl;
	}

	public void setBookurl(String bookurl) {
		this.bookurl = bookurl;
	}

	//用于判断该书是否被收藏，并返回一个String类型 0或者1 表示是否被收藏
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
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return collect;	
	}
	
	
	

}
