<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title>find cookies</title>
  </head>
  <style media="screen">
    body{
      text-align: center;
    }
  </style>
  <body>
<%
Boolean error = false;
if(session.getAttribute("error")!=null){
	error = (Boolean)session.getAttribute("error");
}
session.removeAttribute("error");
%>  
    <p style="font-size:40px;" class="msg" id="msg">XML READER</p>
    <form action="ShowStudent" method="post">
    enter rollno: 
    <input name="rollno" type="number" /><br><hr>
    <input  type="submit"  value="submit" />
    </form>
<%if(error!=null && error==true){ %>
<p style="color:red;">*wrong roll number</p>
<%} %>
  </body>
</html>
