<%@page import="mantras.beans.ComposeMessage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="mantras.usertask.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>sentitems</title>
<%@ include file="/html/commonheader.html"%>
<%@ include file="/html/commonfooter.html"%>
<%@ include file="/WEB-INF/homenavbar.html"%>
</head>
<body>
<%@include file="/user/commonsession.jsp" %>
<%UserTask task=new UserTask();
ArrayList<ComposeMessage>c= task.sentitems(id);%>



<form action="/E-Living_Mantras/DeleteSentItems" method="post ">
<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Select</th>
				<th scope="col">To</th>
				<th scope="col">Subject</th>
				<th scope="col">Message</th>
				<th scope="col">Date</th>
			</tr>
		</thead>
		
		
		<%for(ComposeMessage cm:c)
			{%>
		
		<tbody>
			<tr>
				<th scope="row"><input type="checkbox" name="chkbox"></th>
				<td><%=cm.getReceiverid() %></td>
				<td><%=cm.getSubject() %></td>
				
				<td><%=cm.getMessage() %></td>
				<td><%=cm.getDom() %></td>
			</tr>
			
		</tbody>
		<%} %>
	
	</table>
	<button type="submit" name="delete">Delete</button>
	</form>

</body>
</html>