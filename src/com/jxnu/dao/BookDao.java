package com.jxnu.dao;

import java.util.List;

import com.jxnu.model.Book;

public interface BookDao {
	
	public List<Book> getBookbyId(String Book_Id);
	
	public List<Book> getBookbyName(String Book_Name);
	
	public void updateBookInfo(String Book_Id,String Book_Info);
	
	public void updateBookImg(String Book_Id,String Book_Img);
}
