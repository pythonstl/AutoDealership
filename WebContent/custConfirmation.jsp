<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Listing" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>

<!-- Bootstrap: Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap: Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<!-- navbar --> 
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation.</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Asian Imports</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><form action="GetInventoryController" method="get">
						<input type="hidden" value="">
						<button type="submit" class="btn btn-link navbar-btn">Inventory</button>
					</form></li>
					<li><form action="" method="get">
						<input type="hidden" value="">
						<button type="submit" class="btn btn-link navbar-btn">Contact</button>
					</form></li>
					<li><form action="AdminLoginController" method="get">
						<input type="hidden" value="">
						<button type="submit" class="btn btn-link navbar-btn">Administrator</button>
					</form></li>
				</ul>
			</div>
		</div>
	</nav> 
	<!-- /navbar -->
	<div style="padding-top:100px"></div>
	<h1>Thanks!</h1>
	<a href="index.jsp">HOME</a>
</body>
</html>