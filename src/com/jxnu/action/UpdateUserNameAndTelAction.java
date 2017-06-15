package com.jxnu.action;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserNameAndTelAction extends ActionSupport {
	
	private String name;
	private String tel;

	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		String id = ServletActionContext.getRequest().getSession().getAttribute("Id").toString();
		UserDaoImpl impl = new UserDaoImpl();
		impl.updateUserNameAndTel(id, name, tel);
		
		addCookieSession(name, id);
		
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//����cookie��session
		private static void addCookieSession(String Name,String Id) throws Exception{
			Cookie name = new Cookie("Name",URLEncoder.encode(Name, "UTF-8"));//�û���cookie����
			name.setMaxAge(60*60*2);
			Cookie id = new Cookie("id", Id);//�˺�cookie����
			id.setMaxAge(60*60*2);
			
			ServletActionContext.getResponse().addCookie(name);
			ServletActionContext.getResponse().addCookie(id);
			
			Map session = ActionContext.getContext().getSession();
			ServletActionContext.getRequest().getSession().setAttribute("Name", Name);//����session Name
		}
	

}
