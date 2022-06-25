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
        }
        form{
            display: inline;
        }
    </style>
    <title>회원 삭제하기</title>

    <form method="post" action="/user/delete" style="text-align: center">
        삭제하고 싶은 회원의 id를 입력하세요. **관리자 계정은 삭제되지 않습니다!!** <br>

        id<input type="text" name="id" id="id"><br>

        <input type="submit" value="삭제">
    </form>
</head>
<body>

<br><hr><br>
<%
    Object size = request.getAttribute("userSize");
    Object userIdx;
    String id = "";
    String email = "";
    String firstName = "";
    String lastName = "";

    out.println("userIdx" + "&nbsp &nbsp &nbsp &nbsp" + "아이디" + "&nbsp &nbsp &nbsp &nbsp" + "이메일" + "&nbsp &nbsp &nbsp &nbsp"
            + "firstName" + "&nbsp &nbsp &nbsp &nbsp" + "lastName");
    out.print("<br>");
    out.print("<br>");
    out.print("<br>");

    for(int i = 0; i < (int)size; ++i){
        userIdx = request.getAttribute("userIdx" + i);
        id = (String)request.getAttribute("id" + i);
        email = (String)request.getAttribute("email" + i);
        firstName = (String)request.getAttribute("firstName" + i);
        lastName = (String)request.getAttribute("lastName" + i);
        out.println(userIdx + "&nbsp &nbsp &nbsp &nbsp" + id + "&nbsp &nbsp &nbsp &nbsp" + email + "&nbsp &nbsp &nbsp &nbsp"
                + firstName + "&nbsp &nbsp &nbsp &nbsp" + lastName);
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
