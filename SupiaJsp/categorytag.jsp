<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String strBtntag =  request.getParameter("tag");


	String url_mysql = "jdbc:mysql://database-2.cotrd7tmeavd.ap-northeast-2.rds.amazonaws.com/supia?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
 	String id_mysql = "root";
 	String pw_mysql = "qwer1234";
       String WhereDefault = "SELECT distinct * From supia.product ";
    String WhereDefault1 = "Left join liked on product.productno = liked.likeproductid where productCategory2 ";
    String WhereDefault2 =  "like '%" + strBtntag + "%' order by productNo desc "; 


    int count = 0;
    
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();

        ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault1 + WhereDefault2);  
%>
		{ 
  			"product"  : [ 
<%
        while (rs.next()) {
            if (count == 0) {

            }else{
%>
            , 
<%
            }
%>            
			{
                "productNo" : "<%=rs.getInt(1) %>", 
                "productName" : "<%=rs.getString(2) %>",   
                "productPrice" : "<%=rs.getInt(3) %>",  
                "productQuantity" : "<%=rs.getInt(4) %>",
                "productBrand": "<%=rs.getString(5) %>",
                "productImagePath" : "<%=rs.getString(6) %>",
                "productInfo" :"<%=rs.getString(7) %>",
                "productCategory1" :"<%=rs.getString(8) %>",
                "productCategory2" :"<%=rs.getString(9) %>",
                "likeUserId" :"<%=rs.getString(10) %>",
                "likeProductId" :"<%=rs.getInt(11) %>",
                "likeCheck" :"<%=rs.getString(12) %>"
			}

<%		
        count++;
        }
%>
		  ] 
		} 
<%		
        conn_mysql.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	
%>