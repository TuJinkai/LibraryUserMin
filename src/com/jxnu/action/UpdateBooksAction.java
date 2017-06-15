package com.jxnu.action;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import test.Connecting_To_Database;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateBooksAction extends ActionSupport {
	
	private int Book_Id;
	private String Book_Name;
	private String Author;
	private String Types_Of_Book;
	private int Borrowd;
	private String Date_Issued;
	private int Price;
	private String book_id;

	@Override
	public String execute() throws Exception {
		
		try {
			Connection conn = Connecting_To_Database.getConnection();
			String sql = "update tb_book_info set Book_Name=?,Author=?,Types_Of_Book=?,Price=?,Date_Issued=?, Borrowd=? where Book_Id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,Book_Name );
			ps.setString(2,Author);
			ps.setString(3,Types_Of_Book );
			ps.setString(4,Price+"");
			ps.setString(5,Date_Issued);
			ps.setString(6,Borrowd+"");
			ps.setString(7,book_id);
			ps.executeUpdate();
			ps.close();
			conn.close();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.sendRedirect("ShowBookInfo?book_id="+book_id);
			return SUCCESS;	
			
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ERROR;
	}

	public int getBook_Id() {
		return Book_Id;
	}

	public void setBook_Id(int book_Id) {
		Book_Id = book_Id;
	}

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


	public String getBook_id() {
		return book_id;
	}

	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	
	
	
	
	

}
