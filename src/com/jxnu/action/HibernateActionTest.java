package com.jxnu.action;


import java.util.List;

import com.jxnu.hibernate.HibernateSessionFactory;
import com.jxnu.model.*;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.opensymphony.xwork2.ActionSupport;

public class HibernateActionTest extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Employee>Employees;
	
	public String execute(){
		
		try {
			list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	
	public String list(){
		//º”‘ÿ≈‰÷√Œƒº˛
		Configuration cfg = new Configuration();

		cfg.configure("hibernate.cfg.xml");
		
		Session session = HibernateSessionFactory.getSession();

		String sql = "Select * from tb_employee where firstName like ?";
		String sql2 = "Select * from tb_employee ";
		Query query = session.createSQLQuery(sql2).addEntity(Employee.class);
//		query.setString(0, "%¡ı%");
		Employees = query.list();
//		HibernateSessionFactory.closeSession();
//		Employees = session.createCriteria(Employee.class).list();
		System.out.println("SUCCESS");
		return SUCCESS;
		
	}
	
	public List<Employee> getEmployees(){
		return Employees;
	}
	
	public void Employees(List<Employee>Employees){
		this.Employees = Employees;
	}

}
