package com.jxnu.dao;

import java.util.List;

import com.jxnu.model.SystemMessage;

public interface SystemMessageDao {
	
	public List<SystemMessage> getSystemMessage();
	
	public void updateSystemMessage( String Info);
	
	public void deleteSystemMessage( String Id);

}
