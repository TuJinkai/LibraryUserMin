package com.jxnu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jxnu.dao.BookDao;
import com.jxnu.hibernate.HibernateSessionFactory;
import com.jxnu.model.Book;
import com.jxnu.model.User;

public class BookDaoImpl implements BookDao {

	@Override
	public List<Book> getBookbyId(String Book_Id) {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();
		String sql = "Select * from tb_book_info where Book_Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(Book.class);
		query.setString(0, Book_Id);
		List<Book> book = query.list();
		transaction.commit();
		System.out.println("访问了"+Book_Id);
		session.clear();
		HibernateSessionFactory.closeSession();
		return book;

	}

	@Override
	public List<Book> getBookbyName(String Book_Name) {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		String sql = "Select * from tb_book_info where Book_Name like ?";
		Query query = session.createSQLQuery(sql).addEntity(Book.class);
		query.setString(0, "%"+Book_Name+"%");
		List<Book> book =  query.list();
		transaction.commit();
		System.out.println("BOOK FIND SUCCESS");
		System.out.println(book);
		session.clear();
		HibernateSessionFactory.closeSession();
		return book;
	}

	@Override
	public void updateBookInfo(String Book_Id, String Book_Info) {
		// TODO 自动生成的方法存根
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql = "update tb_book_info set  Book_Info = ?  where Book_Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(Book.class);
		query.setString(0, Book_Info);
		query.setString(1, Book_Id );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改图书："+Book_Id);
		session.clear();
		HibernateSessionFactory.closeSession();
		
	}

	@Override
	public void updateBookImg(String Book_Id, String Book_Img) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql = "update tb_book_info set  Book_Img = ?  where Book_Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(Book.class);
		query.setString(0, Book_Img);
		query.setString(1, Book_Id );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改图书："+Book_Id);
		session.clear();
		HibernateSessionFactory.closeSession();
		
	}

}
