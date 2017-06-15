package com.jxnu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.CacheMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import test.Connecting_To_Database;

import com.jxnu.dao.CollectDao;
import com.jxnu.hibernate.HibernateSessionFactory;
import com.jxnu.model.Book;
import com.jxnu.model.Collect;

public class CollectDaoImpl implements CollectDao {

	@Override
	public List<Book> getCollectBooksByUserId(String User_Id) {
		// TODO 自动生成的方法存根

		List<Book> collects = getCollectBooksByUserIdStatic(User_Id);
		
		return collects;
		
		
	}
	
	public static List<Book> getCollectBooksByUserIdStatic(String User_Id){
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		List<Book> collects = null;
		Session session = HibernateSessionFactory.getSession();
		session.clear();
		session.flush();
		String sql = "select * from tb_book_info a where a.Book_Id in(select b.Book_Id from collect_record b where b.User_Id = ?) ";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(Book.class);
		query.setCacheMode(CacheMode.IGNORE);//防止读取缓存
		query.setString(0, User_Id);
		transaction.commit();
		
		 collects = query.list();
		 
			if(!collects.isEmpty())
				System.out.println("成功返回收藏的书");
			for(Book list :collects){
				System.out.println(list.getBook_Name());
				
			}
		
			session.flush();
			session.close();
		
		return collects;
		
	}

	@Override
	public String AddCollect(String book_id,String User_Id)throws Exception {
		try {
			Date time = new Date();
			String Time = time.toString();//提取系统时间
			
			
			
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			Session session = HibernateSessionFactory.getSession();
			
			Transaction transaction = session.beginTransaction();
			
			Collect collect = new Collect();
			collect.setRecord_Id(10001);
			collect.setBook_Id(book_id);
			collect.setUser_Id(User_Id);
			collect.setRecord_Time(Time);
			
			
			session.save(collect);
			transaction.commit();
			session.close();
			System.out.println("收藏成功");
			return "SUCCESS";
			
		} catch (Exception e) {
			System.out.println("收藏失败");
			e.printStackTrace();
			return "ERROR";
			
		}
		
		
	}



}
