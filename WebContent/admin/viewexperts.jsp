<%@page import="mantras.beans.ExpertRegister"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mantras.admin.*" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="/html/commonheader.html" %>
</head>
<body>
<%@include file="/WEB-INF/adminheader.html" %>

<% AdminTask task=new AdminTask();
 ArrayList<ExpertRegister>er= task.viewexpert();
 %>


<form action="/E-Living_Mantras/DeleteExpert" method="post">
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Select</th>
      <th scope="col">Expert Id</th>
      <th scope="col">Name</th>
      <th scope="col">Address</th>
      <th scope="col">E-mail</th>
      <th scope="col">City</th>
       <th scope="col">Gender</th>
       <th scope="col">Phone No.</th>
        <th scope="col">Qualification</th>
        <th scope="col">Experience</th>
        <th scope="col">Skill</th>
        <th scope="col">Certificate number</th>
        <th scope="col">Expert Type</th>
        
    </tr>
  </thead>
  <tbody>
    <%
 for(ExpertRegister list:er)
 {
 %>
 
<tr>
<th><input type="checkbox" name="chkstudent" value="<%=list.getExpertid()%>"></th><th><%=list.getExpertid() %></th><th><%=list.getExpertname() %></th><th><%=list.getExpertaddress() %></th><th><%=list.getExpertemail() %></th><th><%=list.getExpertcity() %></th>
<th><%=list.getExpertgender() %></th><th><%=list.getExpertphone() %></th><th><%=list.getExpertqf() %></th><th><%=list.getExpertexp() %></th><th><%=list.getExpertskill() %></th><th><%=list.getExpertcno() %></th><th><%=list.getExperttype() %></th></tr>
<%} %>
  </tbody>
</table>
<div style="margin-left: 100px;margin-top: 50px"><button type="submit" id="btndelete" name="btndelete">Delete</button></div>
</form>






<%@include file="/html/commonfooter.html" %>
</body>
</html>