<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
    String strBtnCategory =  request.getParameter("productCategory1");

	String url_mysql = "jdbc:mysql://database-2.cotrd7tmeavd.ap-northeast-2.rds.amazonaws.com/supia?serverTimezone=Asia/Seoul&characterEncoding=utf8&useSSL=false";
 	String id_mysql = "root";
 	String pw_mysql = "qwer1234";
    String WhereDefault = "select productNo, productName, productPrice, productQuantity, productBrand, productImagePath, productInfo, ";       
    String WhereDefault1 = "productCategory1, productCategory2, count(productId) as 'rank' ";
    String WhereDefault2 = "from orderlist, product where productId = productNo and productCategory1 like '%" + strBtnCategory + "%' ";
    String WhereDefault3 = "group by productId order by productId desc";


    int count = 0;


    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn_mysql = DriverManager.getConnection(url_mysql, id_mysql, pw_mysql);
        Statement stmt_mysql = conn_mysql.createStatement();

        ResultSet rs = stmt_mysql.executeQuery(WhereDefault + WhereDefault1 + WhereDefault2 + WhereDefault3);  
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
                "rank" :"<%=rs.getInt(10) %>"
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