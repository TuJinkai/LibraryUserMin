package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.Connecting_To_Database;
import com.opensymphony.xwork2.ActionSupport;

public class AddBooksAction extends ActionSupport {
	
	
	private String Book_Name;
	private String Author;
	private String Types_Of_Book;
	private int Borrowd;
	private String Date_Issued;
	private int Price;
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTypes_Of_Book() {
		return Types_Of_Book;
	}
	public void setTypes_Of_Book(String types_Of_Book) {
		Types_Of_Book = types_Of_Book;
	}
	public int getBorrowd() {
		return Borrowd;
	}
	public void setBorrowd(int borrowd) {
		Borrowd = borrowd;
	}
	public String getDate_Issued() {
		return Date_Issued;
	}
	public void setDate_Issued(String date_Issued) {
		Date_Issued = date_Issued;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "insert into book_info(Book_Name,Author,Types_Of_Book,Price,Date_Issued, Borrowd) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Book_Name);
			ps.setString(2, Author);
			ps.setString(3, Types_Of_Book);
			ps.setLong(4, Price);
			ps.setString(5, Date_Issued);
			ps.setLong(6, Borrowd);
			
			int row = ps.executeUpdate();
			if(row>0){
				ps.close();
				conn.close();
				return SUCCESS;
			}
			ps.close();
			conn.close();
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			System.out.println("注册失败");
			e.printStackTrace();
		}
		return ERROR;
		
		
	}
	
	
	

}
