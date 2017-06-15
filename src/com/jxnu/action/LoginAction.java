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
	
		//��¼�߼�

		 try {
			 UserDaoImpl daoImpl = new UserDaoImpl();
				user = daoImpl.getUser(id);
			if(checkLogin(id, password)){
				Map session = ActionContext.getContext().getSession();
				ServletActionContext.getRequest().getSession().setAttribute("Id", id);//����session id
				ServletActionContext.getRequest().getSession().setAttribute("Name", user.getName());//����session Name
				addCookie(user.getName(), user.getId(), user.getPassword());//���cookie
				if(user.getLevel() == 1){
					
					Cookie urladmin = new Cookie("url","User_admin.jsp");//����Ա��ַcookie����
					urladmin.setMaxAge(60*60*2);
					ServletActionContext.getResponse().addCookie(urladmin);//����Ա��ַ����cookie
					
					ServletActionContext.getRequest().getSession().setAttribute("level", "1");	//����session ����ԱȨ��
					return "AdminSuccess";}
				else if(user.getLevel() == 0){
				Cookie urladmin = new Cookie("url","UserMain.action");//�û���ַcookie����
				urladmin.setMaxAge(60*60*2);
				ServletActionContext.getResponse().addCookie(urladmin);//�û���ַ����cookie
				
				ServletActionContext.getRequest().getSession().setAttribute("level", "0");//����session ��ͨȨ��
				System.out.println("��ͨ�û���¼�ɹ�");
				return "LoginSuccess";}
			
			}else 
			 {
				return "fail";
			}
				
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
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
	
	//��¼��֤
	private boolean checkLogin(String Id,String Password) throws Exception{		
		UserDaoImpl daoImpl = new UserDaoImpl();
		user = daoImpl.getUser(Id);

		if(user.getPassword().toString().equals(Password)){
			System.out.println("��¼У��ɹ�");
			return true;}
		else
			{System.out.println("��¼У��ʧ��");
			return false;}
		
	}
	
	//���cookie
	private static void addCookie(String Name,String Id,String Password) throws Exception{
		Cookie name = new Cookie("Name",URLEncoder.encode(Name, "UTF-8"));//�û���cookie����
		name.setMaxAge(60*60*2);
		Cookie password = new Cookie("password", Password);//����cookie����
		password.setMaxAge(60*60*2);
		Cookie id = new Cookie("id", Id);//�˺�cookie����
		id.setMaxAge(60*60*2);
		
		ServletActionContext.getResponse().addCookie(name);
		ServletActionContext.getResponse().addCookie(password);
		ServletActionContext.getResponse().addCookie(id);
	}
	
	

}
