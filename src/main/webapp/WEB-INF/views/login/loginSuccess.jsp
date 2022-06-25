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
        }
        form{
            display: inline;
        }
    </style>
    <title>로그인 성공!!!</title>
</head>
<body>
로그인이 완료되었습니다. <br>
<%
    String id = request.getParameter("id");

    Cookie cookie_id = new Cookie("id", id);
    cookie_id.setPath("/");
    cookie_id.setMaxAge(60 * 30);

    Cookie cookie_status = new Cookie("status", "ACTIVE");
    cookie_status.setPath("/");
    cookie_status.setMaxAge(60 * 30);

    session.setMaxInactiveInterval(60 * 30);
    session.setAttribute(id, "INACTIVE");

    response.addCookie(cookie_id);
    response.addCookie(cookie_status);
%>

<hr>
[<%= id %>]님 환영합니다.

<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
