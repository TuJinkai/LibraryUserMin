package com.jxnu.dao;

import java.util.List;

import com.jxnu.model.Book;
import com.jxnu.model.Collect;

public interface CollectDao {
	
	public List<Book> getCollectBooksByUserId(String User_Id);
	
	public String  AddCollect(String book_id,String User_Id) throws Exception;

}
