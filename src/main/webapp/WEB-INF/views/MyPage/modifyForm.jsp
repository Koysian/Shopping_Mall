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
    <title>회원 정보 수정하기</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    String id = "";
    request.setAttribute("id", id);
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
<form method="post" action="/user/modify">

    수정할 정보를 입력하세요.<br>
    <div class="userInfo" style="text-align: center">
        <input type="hidden" name="id" id="id" style="width: auto; height: auto" value="<%=id%>" readonly /><br>
        firstName<input type="text" name="firstName" id="firstName"><br>
        lastName<input type="text" name="lastName" id="lastName"><br>
        email<input type="text" name="email" id="email"><br>
    </div>
    <input type="submit" value="수정하기">
</form>
<br>
<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
