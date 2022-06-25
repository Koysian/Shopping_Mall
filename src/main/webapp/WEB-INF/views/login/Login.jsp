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
    <title>로그인 화면</title>
</head>
<body>


<form method="post" action="/user/login" style="text-align: center">

    아이디와 비밀번호를 입력하세요. <br>
    <div class="userInfo">
        &nbsp &nbsp &nbsp &nbsp &nbsp id<input type="text" name="id" id="id"><br>
        password<input type="text" name="password" id="password"><br>
    </div>
    <div>
    <input type="submit" value="로그인">
    </div>
</form>
<hr>

<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
