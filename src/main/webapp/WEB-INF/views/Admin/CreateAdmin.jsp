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
    <title>관리자 추가</title>
</head>
<body>


<form method="post" action="/user/admin" style="text-align: center">
    관리자로 추가할 회원의 아이디를 입력하세요. <br>
    <input type="text" name="id" id="id">
    <input type="submit" value="MAKE HIM ADMIN!">
</form>
<br>
<hr><br>

<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
