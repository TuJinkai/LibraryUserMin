package com.jxnu.model;

import javax.persistence.*;


@Entity
@Table(name="user")
public class User {
	
	private String Id;
	private String Name;
	private String Password;
	private long Tel;
	private String Registration_time;
	private int Level;
	private String Nick_Name;
	private String User_Info;
	private String Img;

	@Id
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}

	public String getRegistration_time() {
		return Registration_time;
	}
	public void setRegistration_time(String registration_time) {
		Registration_time = registration_time;
	}
	public int getLevel() {
		return Level;
	}
	public void setLevel(int level) {
		Level = level;
	}
	public String getNick_Name() {
		return Nick_Name;
	}
	public void setNick_Name(String nick_Name) {
		Nick_Name = nick_Name;
	}
	public String getUser_Info() {
		return User_Info;
	}
	public void setUser_Info(String user_Info) {
		User_Info = user_Info;
	}
	public String getImg() {
		return Img;
	}
	public void setImg(String img) {
		Img = img;
	}
	public long getTel() {
		return Tel;
	}
	public void setTel(long tel) {
		Tel = tel;
	}
	
	

}
