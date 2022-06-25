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
    <title>게시판</title>
</head>
<body>
<%
    Object size = request.getAttribute("postSize");
    String title = "";
    String content = "";
    String userId = "";
    Object postIdx = 0;

    out.println("postIdx" + "&nbsp &nbsp &nbsp &nbsp" + "제목" + "&nbsp &nbsp &nbsp &nbsp" + "내용" + "&nbsp &nbsp &nbsp &nbsp" + "작성자 ID");
    out.print("<br>");
    out.print("<br>");
    out.print("<br>");

    for(int i = 0; i < (int)size; ++i){
        title = (String)request.getAttribute("title" + i);
        content = (String)request.getAttribute("postContent" + i);
        userId = (String)request.getAttribute("postUserId" + i);
        postIdx = request.getAttribute("postIdx" + i);
        out.println(postIdx + "&nbsp &nbsp &nbsp &nbsp" + title + "&nbsp &nbsp &nbsp &nbsp" + content + "&nbsp &nbsp &nbsp &nbsp" + userId);
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

<form method="get" action="/createPostForm">
    <input type="submit" value="게시글 작성">
</form>

<form method="get" action="/deletePostForm">
    <input type="submit" value="게시글 삭제">
</form>

</body>
</html>
