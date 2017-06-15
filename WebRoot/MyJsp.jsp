<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <a href="test.action">my JSP page. </a> <br>
	<s:iterator value="Employees" var="obj" >
    	<s:a href="index.jsp?id=%{id}/">id=<s:property value="id"/><br></s:a>
    	firstName=<s:property value="firstName"/><br>
    	lastName=<s:property value="lastName"/><br>
    </s:iterator>
    
    <s:iterator value="books" var="obj">
    	BookName=<s:property value="Book_Name"/><br>
    </s:iterator>
    
        <s:iterator value="book" var="obj">
    	BookName=<s:property value="Book_Name"/><br>
    	<%=request.getAttribute("Book_Img") %>
    </s:iterator>
    
  </body>
</html>
