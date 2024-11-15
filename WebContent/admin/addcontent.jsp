<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Content</title>
<link href="/E-Living_Mantras/css/style.css" type="text/css" rel="stylesheet">
<link href="/E-Living_Mantras/css/footerstyling.css" type="text/css" rel="stylesheet">

<%@ include file="/html/commonheader.html" %>

<%@ include file="/WEB-INF/adminheader.html" %>

</head>
<body>
<div class="container-fluid" style="width: 400px; margin-top: 5%; ">
<form action="/E-Living_Mantras/AddContent" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Subject</label>
    <input type="text" class="form-control" name="subject" id="subject" aria-describedby="emailHelp">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Tips</label>
    <textarea rows="" cols="" name="tips" class="form-control"></textarea>
  </div>
<div class="form-group">
    <label for="exampleInputEmail1">Date</label>
    <input type="date" class="form-control" name="date" id="date" aria-describedby="emailHelp">
    
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>


<%@ include file="/html/commonfooter.html" %>
<%@ include file="/WEB-INF/footers.html" %>
</body>
</html>