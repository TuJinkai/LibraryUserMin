package com.jxnu.dao;

import java.util.List;

import com.jxnu.model.User;

public interface UserDao {
	public User getUser(String Id);
	
	public List<User> getUserList(String Id);
	
	public void updateUserNameAndTel(String id,String name,String Tel);
	
	public void updateUserPassword(String id,String password);
	
	public void updateUserInfo(String id,String user_info);
	
	public void updateUserImgSrc(String id,String path);
}
