<%@page import="java.util.ArrayList"%>
<%@page import="mantras.beans.UserRegister"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mantras.admin.*" %>
    <%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewuser</title>
<%@include file="/html/commonheader.html" %>
</head>
<body>
<%@include file="/WEB-INF/adminheader.html" %>
<% AdminTask task=new AdminTask();
ArrayList<UserRegister>ur= task.viewUser();%>


<form action="/E-Living_Mantras/DeleteUser" method="post">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">User Id</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">E-mail</th>
       <th scope="col">Gender</th>
       <th scope="col">Phone No.</th>
        <th scope="col">D.O.B</th>
    </tr>
  </thead>
  <tbody>
    <%
 for(UserRegister list:ur)
 {
 %>
 
<tr>
<th><input type="checkbox" name="chkuser" value="<%=list.getUserid()%>"></th><th><%=list.getUserid() %></th><th><%=list.getUsername() %></th><th><%=list.getUseraddress() %></th><th><%=list.getUseremail() %></th>
<th><%=list.getUsergender() %></th><th><%=list.getUserphoneno() %></th><th><%=list.getUserdob() %></th></tr>
<%} %>
  </tbody>
</table>
<div style="margin-left: 100px;margin-top: 50px"><button type="submit">Delete</button></div>
</form>




<%@include file="/html/commonfooter.html" %>
</body>
</html>