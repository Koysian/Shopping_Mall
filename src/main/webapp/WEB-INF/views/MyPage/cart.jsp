<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         import="java.sql.*" pageEncoding="utf-8"%>
<%@ page import="com.example.final_exam.Domain.Post" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        input{
            display: inline;
            border: solid 1px black;
            background-color: antiquewhite;
            margin: 8px;
            padding: 15px;
            text-align: center;
        }
        form{
            display: inline;
        }
    </style>
    <title>장바구니</title>
</head>
<body>
<%
    Object size = request.getAttribute("cartSize");
    String name = "";
    String price = "";

    out.println("상품명" + "&nbsp &nbsp &nbsp &nbsp" + "가격");
    out.print("<br>");
    out.print("<br>");
    out.print("<br>");

    for(int i = 0; i < (int)size; ++i){
        name = (String)request.getAttribute("name" + i);
        price = (String)request.getAttribute("price" + i);
        out.println(name + "&nbsp &nbsp &nbsp &nbsp" + price);
        out.print("<br>");
        out.print("<br>");

    }
%>

<hr>
<br>
<br>
<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>

</body>
</html>
