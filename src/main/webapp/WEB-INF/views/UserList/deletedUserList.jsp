<%--
  Created by IntelliJ IDEA.
  User: thffh
  Date: 2022-05-28
  Time: 오후 8:39
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
        }
        form{
            display: inline;
        }
    </style>
    <title>삭제된 회원 복구</title>
</head>
<body>

<form method="post" action="/user/mercy" style="text-align: center">
    복구하고 싶은 회원의 id를 입력하세요. <br>

    id<input type="text" name="id" id="id"><br>

    <input type="submit" value="복구">
</form>

<br>
<hr>
<br>
<h2>삭제된 회원 목록</h2>
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

<form method=get action="/">
    <input type="submit" value="메인 화면">
</form>

</body>
</html>
