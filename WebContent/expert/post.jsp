<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post</title>
<%@ include file="/html/commonheader.html" %>
<%@ include file="/WEB-INF/homenavbar.html" %>

</head>
<body>
<%@include file="/user/commonsession.jsp" %>

<div class="" style="height: 500px; width: 500px;   float: right; margin-right: 200px; margin-top: 5%;">
<img alt="gif" src="/E-Living_Mantras/images/postimg.jpeg">
<span class="container-fluid" style="font-family: cursive; font-size: 20px; color: black;">
Yoga is bringing fitness in body,calmness in mind,
<br>kindness in heart and awareness in life.
<br>BY- E-Living Mantras
</span>
</div>
<div class="container-fluid" style="margin-left: 15%; background-color: #4BECE7; width: 400px; margin-top: 5%; height: 500px;">
<div class="cotainer-fluid" style="height:100px; width: 100%"><img alt="logo" src="/E-Living_Mantras/images/elm2.png" style="height: 120px; margin-left: 30%; "></div>
<form action="/E-Living_Mantras/Post" method="post" enctype="multipart/form-data" style="margin-top: 10%;">
<div class="container-fluid" style="font-size: 20px; font-family: Arial; margin-left: 5%; margin-top: 10%;">
<label>Upload Your Video: </label><br>
<input type="file" id="file" name="file"></div>
<div class="container-fluid" style="font-size: 20px; font-family: Arial; margin-left: 5%;">

<label>Caption:</label><br>
<input  type="text" id="caption" name="caption" style="width: 320px; " placeholder="Caption">
</div>

<div class="container-fluid" style="font-size: 20px; font-family: Arial; margin-left: 5%;">

<label>Description:</label><br>
<textarea rows="2" cols="30" id="desc" name="desc" placeholder="Describe Your Video here....">
</textarea>
<br>
</div>

<div class="container-fluid" style="margin-left: 5%; margin-top: 2%;">
<button type="submit" class="btn " style="background-color: #900C3F; border-radius: 20px; width:320px;"><span style="color: black; font-family: Arial; font-size: 20px;">Submit</span></button></div>

</form>

</div>

<%@ include file="/html/commonfooter.html" %>
</body>
</html>