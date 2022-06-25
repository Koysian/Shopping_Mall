<%@ page language="java" contentType="text/html; charset=utf-8"
         import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>관리자 전용 페이지</title>
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
</head>
<body>
<%

    Cookie[] cookies = request.getCookies();
    String admin = "";
    String id = "";
    if(cookies != null) {
        for (int i = 0; i < cookies.length; ++i) {
            Cookie c = cookies[i];
            if (((String) c.getName()).equals("id")) {
                id = ((String) c.getValue());
                admin = (String)session.getAttribute(id);
                break;
            }
        }
    }

    if(!admin.equals("ACTIVE")){
%>
        <script>
            alert("관리자 계정으로 로그인 해야 합니다!!!")
        </script>
<br><br><br><br><br>
<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
<%
    }
    else{
%>
        <h2 style="text-align: center">관리자 전용 페이지</h2>
        <hr>
        <br>
<form method="get" action="/user/list">
    <input type="submit" value="회원 목록 조회">
</form>
<form method="get" action="/user/deleteForm">
    <input type="submit" value="회원 삭제">
</form>
<form method="get" action="/user/deleted">
    <input type="submit" value="삭제된 회원 복구">
</form>
<form method="get" action="/createAdminForm">
    <input type="submit" value="관리자 추가">
</form>
<form method="get" action="/createProductForm">
    <input type="submit" value="상품 추가">
</form>
<form method="get" action="/deleteProductForm">
    <input type="submit" value="상품 삭제">
</form>
<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
<%
    }
%>





</body>
</html>
