<!DOCTYPE html>
<%@page import="org.bean.User"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>show student</title>
  </head>
  <style media="screen">
    body{
      text-align: center;
    }
  </style>
  <body>
<%
User user = new User();
user = (User)session.getAttribute("user");

%>
    <p style="font-size:40px;" class="msg" id="msg">XML READER</p>
    <h3>
    First Name :<%=user.getFirstName() %><br>  
    Last Name :<%=user.getLastName() %><br>
    Roll No:<%=user.getRollno() %><br>
    Marks:<%=user.getMarks() %><br>
    Nick Name:<%=user.getNickName() %><br>
    </h3>
  </body>
</html>
