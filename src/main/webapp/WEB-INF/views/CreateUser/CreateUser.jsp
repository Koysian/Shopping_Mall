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

    <title>Title</title>
</head>
<body>
<h2>Sign Up</h2>

<form method="post" action="/user/create">

    Type Info **이미 로그인된 상태에서 회원가입을 해도 로그아웃 되지 않습니다. 회원 가입후 로그아웃 하고 생성한 계정으로 다시 로그인해야 합니다.**<br>
    <div class="userInfo">
        firstName<input type="text" name="firstName" id="firstName"><br>
        lastName<input type="text" name="lastName" id="lastName"><br>
        email<input type="text" name="email" id="email"><br>
        id<input type="text" name="id" id="id"><br>
        password<input type="text" name="password" id="password"><br>
    </div>

    <input type="submit" value="send">
</form>
<br>
<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>

</body>
</html>
