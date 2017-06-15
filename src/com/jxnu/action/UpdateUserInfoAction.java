package com.jxnu.action;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserInfoAction extends ActionSupport {
	
	private String User_Info;
	
	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		String id = ServletActionContext.getRequest().getSession().getAttribute("Id").toString();
		UserDaoImpl impl = new UserDaoImpl();
		impl.updateUserInfo(id, User_Info);
		
		return SUCCESS;
	}

	public String getUser_Info() {
		return User_Info;
	}

	public void setUser_Info(String user_Info) {
		User_Info = user_Info;
	}
	
	
	
	

}
