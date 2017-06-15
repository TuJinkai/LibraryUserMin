package com.jxnu.action;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import test.Connecting_To_Database;

import com.jxnu.dao.impl.UserDaoImpl;
import com.jxnu.model.Book;
import com.jxnu.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserMainAction extends ActionSupport {
	
	private User user;
	private List<User>users;
	private int CollectNumber;
	
	@Override
	public String execute() throws Exception {
		// TODO �Զ����ɵķ������
		try {
			
			UserDaoImpl userDaoImpl = new UserDaoImpl();
			users = userDaoImpl.getUserList(ServletActionContext.getRequest().getSession().getAttribute("Id").toString());
			
			CollectNumber  = CollectNumberView(ServletActionContext.getRequest().getSession().getAttribute("Id").toString());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
		
		return SUCCESS;
		
	}

		//��ȡ�û��ղ�ͼ������
		protected static int CollectNumberView(String Id){
			
			int CollectNumber = 0;
			
			try {
				Connection conn = Connecting_To_Database.getConnection();
				Statement stmt = conn.createStatement();
				String sql = "select * from collect_record where  User_Id = '"+Id+"'";
				ResultSet ps = stmt.executeQuery(sql);
				
				while(ps.next()){
					CollectNumber++;
				}

				stmt.close();
				conn.close();
				
			} catch (Exception e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				
			}
			return CollectNumber;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public int getCollectNumber() {
			return CollectNumber;
		}

		public void setCollectNumber(int collectNumber) {
			CollectNumber = collectNumber;
		}

		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
		}


		
		
		

}
