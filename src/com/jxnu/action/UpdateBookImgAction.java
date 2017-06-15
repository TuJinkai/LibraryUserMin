package com.jxnu.action;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.jxnu.dao.impl.UserDaoImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateBookImgAction extends ActionSupport {
	
	private String username;
	private File myUpload;
	private String myUploadFileName;
	private String myUploadContentType;
	private String savePath;
	private String book_id;
	//����struts.xml�ļ�����ֵ�ķ���
	public void setSavePath(String value)
	{
		this.savePath = value;
	}
	//�����ϴ��ļ��ı���λ��
	public String getSavePath() throws Exception 
	{
		String  str = ServletActionContext.getServletContext()
				.getRealPath(savePath);
		return str;
	}
	
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public File getMyUpload() {
		return myUpload;
	}


	public void setMyUpload(File myUpload) {
		this.myUpload = myUpload;
	}


	public String getMyUploadFileName() {
		return myUploadFileName;
	}


	public void setMyUploadFileName(String myUploadFileName) {
		this.myUploadFileName = myUploadFileName;
	}


	public String getMyUploadContentType() {
		return myUploadContentType;
	}


	public void setMyUploadContentType(String myUploadContentType) {
		this.myUploadContentType = myUploadContentType;
	}
	
	

	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	
	
	// �ļ��ϴ���action���� 
	public String upload() throws Exception {
		String strNewFileName = "img"+book_id;
		String suffix = myUploadFileName.substring(myUploadFileName.lastIndexOf("."));
		strNewFileName+=suffix;
		//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
		FileOutputStream fos = new FileOutputStream(getSavePath()
			+ "\\" + strNewFileName);
		myUploadFileName = strNewFileName;
//		System.out.println("�������������"+strNewFileName);
		FileInputStream fis = new FileInputStream(getMyUpload());
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) > 0)
		{
			fos.write(buffer , 0 , len);
		}
		fos.close();
		UserDaoImpl daoImpl = new UserDaoImpl();
		daoImpl.updateUserImgSrc(book_id, "images/Book_Main_imgs/img"+strNewFileName);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.sendRedirect("ShowBookInfo?book_id="+book_id);
		return SUCCESS;
	}
	
	

}
