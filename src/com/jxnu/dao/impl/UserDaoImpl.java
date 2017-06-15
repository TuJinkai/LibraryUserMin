package com.jxnu.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jxnu.dao.UserDao;
import com.jxnu.hibernate.HibernateSessionFactory;
import com.jxnu.model.Book;
import com.jxnu.model.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUser(String Id) {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();
		session.flush();
		Transaction transaction = session.beginTransaction();
		User users =  (User) session.get(User.class, Id);
		System.out.println("成功返回users");
		transaction.commit();
		session.clear();
		
		HibernateSessionFactory.closeSession();
		return users;
	}

	@Override
	public List<User> getUserList(String Id) {
		// TODO 自动生成的方法存根
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		String sql = "Select * from user where id = ?";
		Query query = session.createSQLQuery(sql).addEntity(User.class);
		query.setString(0, Id);
		transaction.commit();
		List<User> user = query.list();
		System.out.println("成功返回List<User> use");
		session.clear();
		HibernateSessionFactory.closeSession();
		return user;
	}

	@Override
	public void updateUserNameAndTel(String id,String name, String Tel) {
		// TODO 自动生成的方法存根
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql  = "update user set Name = ? , Tel = ?  where Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(User.class);
		query.setString(0, name);
		query.setString(1, Tel );
		query.setString(2, id  );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改用户Name和Tel："+id);
		session.clear();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void updateUserPassword(String id, String password) {
		// TODO 自动生成的方法存根
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql = "update user set  Password = ?  where id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(User.class);
		query.setString(0, password);
		query.setString(1, id );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改用户密码："+id);
		session.clear();
		HibernateSessionFactory.closeSession();
		
	}

	@Override
	public void updateUserInfo(String id, String user_info) {
		// TODO 自动生成的方法存根
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql = "update user set  User_Info = ?  where Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(User.class);
		query.setString(0, user_info);
		query.setString(1, id );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改用户简介："+id);
		session.clear();
		HibernateSessionFactory.closeSession();
		
	}

	@Override
	public void updateUserImgSrc(String id, String path) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		String sql = "update user set  Img = ?  where Id = ?";
		Transaction transaction = session.beginTransaction();
		Query query = session.createSQLQuery(sql).addEntity(User.class);
		query.setString(0, path);
		query.setString(1, id );
		query.executeUpdate();
		transaction.commit();
		System.out.println("成功修改用户图片："+id);
		session.clear();
		HibernateSessionFactory.closeSession();
		
	}

}
