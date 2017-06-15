package com.jxnu.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



//清除cookie
public class LogoutAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		cleanCookie();
		return SUCCESS;
	}
	
	

	//cookie清除和session清除
	private static void cleanCookie() throws Exception{
		Cookie name = new Cookie("Name", null);
		Cookie url = new Cookie("url", null);
		name.setMaxAge(0);
		url.setMaxAge(0);
		
		ServletActionContext.getResponse().addCookie(name);
		ServletActionContext.getResponse().addCookie(url);
		
		
		ActionContext actionContext = ActionContext.getContext();
		Map session = actionContext.getSession();
		session.clear();
		
	}
	
	

}
