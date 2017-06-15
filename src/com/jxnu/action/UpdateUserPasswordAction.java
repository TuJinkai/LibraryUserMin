package com.jxnu.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserPasswordAction extends ActionSupport {
	
	private String Password;

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		String id = ServletActionContext.getRequest().getSession().getAttribute("Id").toString();
		UserDaoImpl impl = new UserDaoImpl();
		impl.updateUserPassword(id, Password);
		
		return SUCCESS;
	}
	
	

	

}
