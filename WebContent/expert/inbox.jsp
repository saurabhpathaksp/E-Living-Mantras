<%@page import="mantras.beans.ComposeMessage"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="mantras.usertask.*,mantras.beans.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inbox</title>
<%@ include file="/html/commonheader.html"%>
<%@ include file="/html/commonfooter.html"%>
<%@ include file="/WEB-INF/homenavbar.html"%>
<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" >
<style type="text/css">
element.style {
	z-index: 999;
	right: -40px;
}

#ssb-container {
	top: 30%;
}

div#ssb-container {
	
}

#ssb-container {
	right: 0 !important;
}

#ssb-container {
	position: fixed;
	top: 30%;
	z-index: 1;
}

.ssb-btns-right {
	right: 0;
}

a, abbr, acronym, address, applet, article, aside, audio, b, big,
	blockquote, body, canvas, caption, center, cite, code, dd, del, details,
	dfn, div, dl, dt, em, embed, fieldset, figcaption, figure, footer, form,
	header, hgroup, html, i, iframe, img, ins, kbd, label, legend, li, mark,
	menu, nav, object, ol, output, p, pre, q, ruby, s, samp, section, small,
	span, strike, strong, sub, summary, sup, table, tbody, td, tfoot, th,
	thead, time, tr, tt, u, ul, var, video {
	margin: 0;
	padding: 0;
	border: 0;
	vertical-align: baseline;
	font-size: 100%;
}

user agent stylesheet
div {
	display: block;
}

body {
	font-size: 14px;
	color: #404040;
	font-weight: 400;
	line-height: 1.66em;
}

body, p, textarea, input, select, button, .mk-edge-desc, .edge-desc {
	font-family: Open Sans;
}

body {
	position: relative;
	-webkit-text-size-adjust: 100%;
	-webkit-font-smoothing: antialiased;
}

html {
	font-size: 100%;
	-webkit-font-smoothing: antialiased;
	-webkit-text-size-adjust: 100%;
	-ms-text-size-adjust: 100%;
}

#mk-notification-bar, #mk-page-introduce, #mk-theme-container,
	.master-holder div, .mk-blog-classic-item, .mk-blog-grid-item,
	.mk-employee-item, .mk-fullwidth-boxed, .mk-gallery .gallery-caption,
	.mk-gallery .gallery-inner, .mk-gallery .gallery-title,
	.mk-header-toolbar, .mk-image-caption, .mk-news-item,
	.page-section-content, .portfolio-widget-info, .shopping-cart-header,
	.testimonial-column .testimonial-item, .text-input, .theme-page-wrapper,
	:after, :before, [class*=mk-col-], input[type=text], textarea {
	box-sizing: border-box;
}

#mk-notification-bar, #mk-page-introduce, #mk-theme-container,
	.master-holder div, .mk-blog-classic-item, .mk-blog-grid-item,
	.mk-employee-item, .mk-fullwidth-boxed, .mk-gallery .gallery-caption,
	.mk-gallery .gallery-inner, .mk-gallery .gallery-title,
	.mk-header-toolbar, .mk-image-caption, .mk-news-item,
	.page-section-content, .portfolio-widget-info, .shopping-cart-header,
	.testimonial-column .testimonial-item, .text-input, .theme-page-wrapper,
	:after, :before, [class*=mk-col-], input[type=text], textarea {
	box-sizing: border-box;
}

::selection {
	background-color: #243d77;
	color: #fff;
}
</style>
</head>
<body>

<%@include file="/user/commonsession.jsp" %>
<%UserTask task=new UserTask(); 
ArrayList<ComposeMessage>cm= task.inbox(id);
System.out.println(id);


%>


	<div id="ssb-container" class="ssb-btns-right ssb-anim-slide" style="z-index: 999; right: -40px; height: 200px; ">
		<ul class="ssb-light-hover">
			<li id="ssb-btn-0" style="background-color: red; height: 60px;  border-radius: 10px; ">
				<p>
					<a href="/E-Living_Mantras/expert/inbox.jsp"><span style="font-size: 30px; color: black; "><i class="fa fa-inbox" style="margin-left: 40%"></i><br>Inbox</span> </a>
				</p>
			</li>
			<li id="ssb-btn-1" style="background-color: blue; height: 60px; border-radius: 10px;">
				<p>
					<a href="/E-Living_Mantras/expert/sentitems.jsp"><span style="font-size: 30px; color: black;  "><i class="fas fa-paper-plane" style="margin-left: 40%"></i><br>Sent Items</span> </a>
				</p>
			</li>
			<li id="ssb-btn-2" style="background-color: red; height: 60px; border-radius: 10px;">
				<p>
					<a href="/E-Living_Mantras/expert/compose.jsp"><span style="font-size: 30px; color: black;"><i class="fa fa-rocket" style="margin-left: 40%"></i><br>Compose</span> </a>
				</p>
			</li>
		</ul>
	</div>
	<form action="/E-Living_Mantras/DeleteInbox" method="post">
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Select</th>
				<th scope="col">From</th>
				<th scope="col">Subject</th>
				<th scope="col">Message</th>
				<th scope="col">Date</th>
			</tr>
		</thead>
		
		
		<%for(ComposeMessage c:cm)
		{ %>
		
		<tbody>
			<tr>
				<th scope="row"><input type="checkbox" name="chkbox" value="<%=c.getSenderid()%>"></th>
				<td><%=c.getSenderid() %></td>
				<td><%=c.getSubject() %></td>
				
				<td><%=c.getMessage() %></td>
				<td><%=c.getDom() %></td>
			</tr>
			
		</tbody>
		<%} %>
	</table>
	<button type="submit" name="delete">Delete</button>
	</form>
</body>
</html>