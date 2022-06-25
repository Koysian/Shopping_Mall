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

    <title>게시글 작성</title>
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
<%
    if(id.equals("")){
        %> <script>alert("로그인후 이용할 수 있습니다.")</script>
<br>
<br>
<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>
</body>
</html>

<%
    }
    else{


%>

<h2>게시글 작성</h2>

<form method="post" action="/posts/create">
    <div class="box">
        <input type="hidden" name="id" id="id" style="width: auto; height: auto" value="<%=id%>" readonly /><br>
        제목<input type="text" name="title" id="title" style="width: auto; height: auto"><br>
        내용<input type="text" name="content" id="content" style="width: auto; height: auto"><br>
    </div>
    <input type="submit" value="작성">
</form>
<br>
<form method="get" action="/">
    <input type="submit" value="메인 화면">
</form>

</body>
</html>

<%
    }
%>
