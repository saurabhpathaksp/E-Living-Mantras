<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Compose</title>
<link href="https://fonts.googleapis.com/css?family=Roboto+Condensed" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="custom.css">

<%@ include file="/html/commonheader.html" %>
<%@ include file="/html/commonfooter.html" %>
<%@ include file="/WEB-INF/homenavbar.html"%>
<style type="text/css">
body{
	/* background-image: url('/E-Living_Mantras/images/wolfgang-hasselmann-5DFaZ89XbE8-unsplash.jpg'); */
	background-color: brown;
}
.main-section{
	font-family: 'Roboto Condensed', sans-serif;
	position: absolute;
	left:50%;
	right:50%;
	transform: translate(-50%,30%);
}
.left-sidebar ul{
	list-style: none;
}
.left-sidebar ul li{
	width: 100%;
	padding:0px 0px;
	display: inline-block;
	border-bottom:1px solid #d2d2d2;
}
.left-sidebar ul li a:hover{
	background-color: #d2d2d2;
	color:red;
}
.left-sidebar ul li a{
	display: inline-block;
	width: 100% !important;
	color:#000;
}
.left-sidebar .badge{
	float:right;
}
.messege-right h1{
	font-size:18px;
}
.message-box-icon i{
	padding: 0px 3px;
}
.message-box-input .form-control{
	border-radius: unset;
	box-shadow: none;
}
.message-box-last-content{
	margin-top: -20px;
	border-top:2px solid #E5E5E5;
	background-color: #f5f5f5;
	width: 100%;
}
.message-box-last-content i{
	color:#404040;
	padding:0px 5px;
}

</style>
</head>

<body>
<%@include file="/user/commonsession.jsp" %>

	<div class="container main-section">
		<div class="row">
			<div class="col-lg-9 border main-section bg-white">
				<div class="row">
					<div class="col-lg-12 p-2">
						<h3>Message </h3>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 left-sidebar p-3 border">
						<div class="row">
							<div class="col-lg-12">
								<ul class="nav">
						            <li class="nav-item">
						                <a class="nav-link" href="/E-Living_Mantras/expert/inbox.jsp"><i class="fa fa-inbox"></i> Inbox</a>
						            </li>
						            <li class="nav-item">
						                <a class="nav-link" href="/E-Living_Mantras/expert/sentitems.jsp"><i class="fas fa-paper-plane"></i>Sent Items</a>
						            </li>
						            <li class="nav-item">
						                <a class="nav-link" href="#"><i class="fa fa-rocket"></i> Compose</a>
						            </li>						            
						        </ul>
							</div>
						</div>
					</div>
					<div class="col-lg-8 messege-right p-3 border">
						<div class="row m-0">
							<div class="col-lg-12 bg-dark text-white">
								<div class="row">
									<div class="col-lg-6">
										<h1 class="pt-2">New Message</h1>
									</div>
									<div class="col-lg-6 pt-2 message-box-icon">
										<span class="pull-right">
											<i class="fa fa-minus" aria-hidden="true"></i>
											<i class="fa fa-arrows-alt" aria-hidden="true"></i>
											<i class="fa fa-times" aria-hidden="true"></i>
										</span>
									</div>
								</div>
							</div> 
							<div class="col-lg-12 p-0 message-box-input">
								<form action="/E-Living_Mantras/Compose" method="post">
								  	<div class="form-group">
								    	<input type="text" class="form-control" name="receiverid" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Reciever's Id">
								    	<input type="text" class="form-control" name="subject" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Subject">
								  		<textarea class="form-control" name="message" id="exampleFormControlTextarea1" rows="6" placeholder="Write Your Message Here............"></textarea>
								  	
								  	<input type="hidden" value="<%=id%>" name="senderid">
								  	</div>
								  	<div class="co-lg-12 message-box-last-content p-2">
								<button type="submit" class="btn btn-primary">Send</button>
								
							</div>
								 </form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>