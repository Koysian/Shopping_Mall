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
    <title>상품 삭제</title>
</head>
<body>


<form method="post" action="/products/delete" style="text-align: center">

    삭제할 상품의 이름을 입력하세요 <br>
    상품 이름<input type="text" name="name" id="name"><br>
    <input type="submit" value="상품 삭제">

</form>
<hr>

<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
