package com.jxnu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.UserDaoImpl;
import com.jxnu.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class ShowUserInfoAction extends ActionSupport {
	
	private List<User>user;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		user = userDaoImpl.getUserList(ServletActionContext.getRequest().getSession().getAttribute("Id").toString());
		return SUCCESS;
		
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}
	
	

}
