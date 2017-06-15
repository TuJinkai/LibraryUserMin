package com.jxnu.action;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;






import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import test.*;

import com.jxnu.dao.impl.UserDaoImpl;
import com.jxnu.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String id;
	private String password;
	private User user;
	
	public String execute(){
	
		//登录逻辑

		 try {
			 UserDaoImpl daoImpl = new UserDaoImpl();
				user = daoImpl.getUser(id);
			if(checkLogin(id, password)){
				Map session = ActionContext.getContext().getSession();
				ServletActionContext.getRequest().getSession().setAttribute("Id", id);//存入session id
				ServletActionContext.getRequest().getSession().setAttribute("Name", user.getName());//存入session Name
				addCookie(user.getName(), user.getId(), user.getPassword());//存放cookie
				if(user.getLevel() == 1){
					
					Cookie urladmin = new Cookie("url","User_admin.jsp");//管理员地址cookie生成
					urladmin.setMaxAge(60*60*2);
					ServletActionContext.getResponse().addCookie(urladmin);//管理员地址存入cookie
					
					ServletActionContext.getRequest().getSession().setAttribute("level", "1");	//存入session 管理员权限
					return "AdminSuccess";}
				else if(user.getLevel() == 0){
				Cookie urladmin = new Cookie("url","UserMain.action");//用户地址cookie生成
				urladmin.setMaxAge(60*60*2);
				ServletActionContext.getResponse().addCookie(urladmin);//用户地址存入cookie
				
				ServletActionContext.getRequest().getSession().setAttribute("level", "0");//存入session 普通权限
				System.out.println("普通用户登录成功");
				return "LoginSuccess";}
			
			}else 
			 {
				return "fail";
			}
				
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return ERROR;
		 
		 
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//登录验证
	private boolean checkLogin(String Id,String Password) throws Exception{		
		UserDaoImpl daoImpl = new UserDaoImpl();
		user = daoImpl.getUser(Id);

		if(user.getPassword().toString().equals(Password)){
			System.out.println("登录校验成功");
			return true;}
		else
			{System.out.println("登录校验失败");
			return false;}
		
	}
	
	//添加cookie
	private static void addCookie(String Name,String Id,String Password) throws Exception{
		Cookie name = new Cookie("Name",URLEncoder.encode(Name, "UTF-8"));//用户名cookie生成
		name.setMaxAge(60*60*2);
		Cookie password = new Cookie("password", Password);//密码cookie生成
		password.setMaxAge(60*60*2);
		Cookie id = new Cookie("id", Id);//账号cookie生成
		id.setMaxAge(60*60*2);
		
		ServletActionContext.getResponse().addCookie(name);
		ServletActionContext.getResponse().addCookie(password);
		ServletActionContext.getResponse().addCookie(id);
	}
	
	

}
