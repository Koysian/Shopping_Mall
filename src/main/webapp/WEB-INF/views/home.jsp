<%@ page language="java" contentType="text/html; charset=utf-8"
         import="java.sql.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        input{
            display: inline;
        }
        div{
            text-align: center;
        }
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
        img{
            height: 170px;
            width: 170px;


        }
        p{
            position: relative;
            display: inline-flex;
        }
    </style>
    <meta charset="utf-8">
    <title>Home</title>
</head>
<body>
<h1 style="text-align: center">쇼핑몰<br><br></h1>
<h3 style="text-align: center">

<br>
<%
    Cookie[] cookies = request.getCookies();


    String value = "";
    String id = "";
    if(cookies != null) {
        for (int i = 0; i < cookies.length; ++i) {
            Cookie c = cookies[i];
            if (((String) c.getName()).equals("status")) {
                value = ((String) c.getValue());
            }
            if(((String)c.getName()).equals("id")){
                id = (String)c.getValue();
            }
        }
    }
%>
<div>
    <form method=get action="/create">
        <input type="submit" value="회원 가입">
    </form>
<%
    if(!value.equals("ACTIVE")){
        out.println("<form method=get action=\"/login\">\n" +
                "        <input type=\"submit\" value=\"로그인\">\n" +
                "    </form>");
    }
    else{
        out.println("<form method=get action=\"/logout\">\n" +
                "        <input type=\"submit\" value=\"로그아웃\">\n" +
                "    </form>");
        out.println("<form method=get action=\"/myPage\">\n" +
                "        <input type=\"submit\" value=\"마이 페이지\">\n" +
                "    </form>");
    }
%>
    <form method=get action="/admin">
        <input type="submit" value="관리자 전용 페이지">
    </form>
    <form method=get action="/posts">
        <input type="submit" value="게시판">
    </form>

</div>
<br><br><hr><br><br>

<%
    Object size = request.getAttribute("productSize");
    String name = "";
    String price = "";
    String imgUrl = "";

    for(int i = 0; i < (int)size; ++i){
        name = (String)request.getAttribute("name" + i);
        price = (String)request.getAttribute("price" + i);
        imgUrl = (String)request.getAttribute("imgUrl" + i);
        out.print("<p>\n" +
                "    <img src=\"" + imgUrl + "\">\n" +
                "    <br>\n" +
                "    <form method=\"post\" action=\"/products/add\">\n" +
                "        <input type=\"hidden\" name=\"id\" value=\"" + id + "\">" +
                "        <input type=\"hidden\" name=\"name\" value=\"" + name +"\">\n" +
                "        " + name + "(" + price + "원)" + "<input type=\"submit\" value=\"장바구니에 담기\">\n" +
                "    </form>\n" +
                "</p>");
        if((i+1)%3 == 0){
            out.print("<br><br>");
        }
    }
%>


</body>
</html>