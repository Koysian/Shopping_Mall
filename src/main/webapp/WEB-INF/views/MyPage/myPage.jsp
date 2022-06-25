<%@ page language="java" contentType="text/html; charset=utf-8"
         import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>마이 페이지</title>
    <style>
        input{
            display: inline;
            border: solid 1px black;
            background-color: antiquewhite;
            margin: 8px;
            padding: 15px;
        }
        form{
            display: inline;
        }
    </style>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();

    String id = "";
    if(cookies != null) {
        for (int i = 0; i < cookies.length; ++i) {
            Cookie c = cookies[i];
            if(((String)c.getName()).equals("id")){
                id = (String)c.getValue();
                break;
            }
        }
    }
%>
<h2 style="text-align: center">마이 페이지</h2>
<hr>
<br>
<br>
<div>
    <form method=get action="/products/cart">
        <input type="hidden" value="<%=id%>" name="id">
        <input type="submit" value="장바구니">
    </form>
    <form method=get action="/modifyUserForm">
        <input type="submit" value="내 정보 수정">
    </form>
    <form method=get action="/">
        <input type="submit" value="메인 화면">
    </form>
</div>

</body>
</html>
