<%@ page language="java" contentType="text/html; charset=utf-8"
         import="java.sql.*" pageEncoding="utf-8"%>
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
    <title>로그아웃 페이지</title>
</head>
<body>
<%
    session.invalidate();
    Cookie[] cookies = request.getCookies();
    for(int i = 0; i < cookies.length; ++i){
        Cookie c = cookies[i];
        Cookie delCookie = new Cookie(c.getName(), "");
        delCookie.setPath("/");
        delCookie.setMaxAge(1);
        response.addCookie(delCookie);

    }

%>
<h3>로그아웃 되었습니다.</h3>
<hr>
<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
