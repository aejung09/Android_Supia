<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>        
<%
	request.setCharacterEncoding("utf-8");
	String userId = request.getParameter("userId");
	String calendarStartDate = request.getParameter("calendarStartDate");
	String calendarFinishDate = request.getParameter("calendarFinishDate");
		
//--------
	String url_mysql = "jdbc:mysql://database-2.cotrd7tmeavd.ap-northeast-2.rds.amazonaws.com/supia?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
	String id_mysql = "root";
	String pw_mysql = "qwer1234";

	PreparedStatement ps = null;
	try{
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection conn_mysql = DriverManager.getConnection(url_mysql,id_mysql,pw_mysql);
	    Statement stmt_mysql = conn_mysql.createStatement();
	
	    String A = "insert into calendar (userId, calendarStartDate, calendarFinishDate";
	    String B = ") values (?,?,?)";
	
	    ps = conn_mysql.prepareStatement(A+B);
	    ps.setString(1, userId);
	    ps.setString(2, calendarStartDate);
	    ps.setString(3, calendarFinishDate);
	   
		
	    
	    ps.executeUpdate();
	
	    conn_mysql.close();
	} 
	
	catch (Exception e){
	    e.printStackTrace();
	}
	
%>

