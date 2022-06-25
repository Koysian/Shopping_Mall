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
    <title>상품 추가</title>
</head>
<body>


<form method="post" action="/products/create" style="text-align: center">

    상품 정보를 입력하세요 <br>
    <div class="userInfo">
        상품 이름<input type="text" name="name" id="name"><br>
        상품 가격<input type="text" name="price" id="price"><br>
        상품 이미지 소스<input type="text" name="imgUrl" id="imgUrl"><br>
    </div>
    <div>
        <input type="submit" value="상품 추가">
    </div>
</form>
<hr>

<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
