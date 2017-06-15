package com.jxnu.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.SystemMessageDaoImpl;
import com.jxnu.model.SystemMessage;
import com.opensymphony.xwork2.ActionSupport;

public class ShowSystemMessage extends ActionSupport {
	
	private List<SystemMessage>messages;
	


	public List<SystemMessage> getMessages() {
		return messages;
	}



	public void setMessages(List<SystemMessage> messages) {
		this.messages = messages;
	}



	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		
		try {
			String level = ServletActionContext.getRequest().getSession().getAttribute("level").toString();
			SystemMessageDaoImpl impl = new SystemMessageDaoImpl();
			messages = impl.getSystemMessage();
			
			if(level.equals("0"))
				return "user";
			else
				return "admin";
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
		
		

	}


	
	

}
