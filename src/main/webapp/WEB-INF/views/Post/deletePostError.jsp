<%--
  Created by IntelliJ IDEA.
  User: thffh
  Date: 2022-05-28
  Time: 오후 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>삭제 실패</title>
</head>
<body>
게시글 번호 또는 제목이 잘못 되었거나, 자신이 쓴 게시글이 아닙니다!!<br>
자신의 게시글만 삭제할 수 있습니다.

<br>
<br>
<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>
