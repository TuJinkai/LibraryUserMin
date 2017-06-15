package com.jxnu.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.jxnu.dao.SystemMessageDao;
import com.jxnu.hibernate.HibernateSessionFactory;
import com.jxnu.model.SystemMessage;

public class SystemMessageDaoImpl implements SystemMessageDao {

	@Override
	public List<SystemMessage> getSystemMessage() {
		// TODO 自动生成的方法存根
		
		List<SystemMessage> list = null;
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		String hql = "select * from tb_system_message"; 
		Query query = session.createSQLQuery(hql).addEntity(SystemMessage.class);
		list = query.list();
		transaction.commit();
//		System.out.println(list.get(1).getInfo().toString());

		return list;
	}

	@Override
	public void updateSystemMessage( String Info) {
		// TODO 自动生成的方法存根
		
		Date time = new Date();
		String Time = time.toString();//提取系统时间
		
		
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		SystemMessage systemMessage = new SystemMessage();
		systemMessage.setId(11111);
		systemMessage.setInfo(Info);
		systemMessage.setTime(Time);
		session.save(systemMessage);
		transaction.commit();
		
		HibernateSessionFactory.closeSession();
		
	}

	@Override
	public void deleteSystemMessage(String Id) {
		// TODO 自动生成的方法存根
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		Session session = HibernateSessionFactory.getSession();
		
		Transaction transaction = session.beginTransaction();
		
		String hql = "delete from tb_system_message where Id = ?"; 
		
		Query query = session.createSQLQuery(hql).addEntity(SystemMessage.class);
		query.setString(0, Id);
		query.executeUpdate();
		
		transaction.commit();
		HibernateSessionFactory.closeSession();
	}

}
