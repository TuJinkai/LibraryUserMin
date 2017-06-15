package com.jxnu.action;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.SystemMessageDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class AddSystemMessage extends ActionSupport {
	
	private String Info;

	@Override
	public String execute() throws Exception {
		// TODO 自动生成的方法存根
		try {
			String level = ServletActionContext.getRequest().getSession().getAttribute("level").toString();
			if(level.equals("0"))
				return ERROR;
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
		SystemMessageDaoImpl daoImpl = new SystemMessageDaoImpl();
		daoImpl.updateSystemMessage(Info);
		return SUCCESS;
	}

	public String getInfo() {
		return Info;
	}

	public void setInfo(String info) {
		Info = info;
	}
	
	
	

}
