<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>        
<%
	request.setCharacterEncoding("utf-8");
	String likeUserId = request.getParameter("likeUserId");
	int likeProductId =  Integer.parseInt(request.getParameter("likeProductId"));
	String likeCheck = request.getParameter("likeCheck");
	

	String url_mysql = "jdbc:mysql://database-2.cotrd7tmeavd.ap-northeast-2.rds.amazonaws.com/supia?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";

	PreparedStatement ps = null;
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	    Statement stmt_mysql = conn_mysql.createStatement();
	
	    String A = "insert into liked (likeUserId, likeProductId, likeCheck) values (?, ?, ?)";
	
	    ps = conn_mysql.prepareStatement(A);


		ps.setString(1, likeUserId);
	    ps.setInt(2, likeProductId);
		ps.setString(3, likeCheck);
	    
	    ps.executeUpdate();
	
	    conn_mysql.close();
	} 
	
	catch (Exception e){
	    e.printStackTrace();
	}
	
%>

