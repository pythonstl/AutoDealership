<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Listing" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Check-Out</title>

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
	
	<div class="container">
		<h3><c:out value="${listing.askingPrice}"></c:out></h3>
		<form action="BuyController" method="post">
			<label for="bid">Your Offer</label>
			<input type="text" name="bid" />
			<label for="firstName">First Name</label>
			<input type="text" name="firstName" />
			<label for="lastName">Last Name</label>
			<input type="text" name="lastName" />
			<label for="street">Street</label>
			<input type="text" name="street" />
			<label for="city">City</label>
			<input type="text" name="city" />
			<label for="state">State</label>
			<input type="text" name="state" />
			<label for="zip">Z.I.P.</label>
			<input type="text" name="zip" />
			<label for="telephone">Telephone</label>
			<input type="text" name="telephone" />
			<label for="email">E-mail</label>
			<input type="text" name="email" />
			<input type="hidden" name="listing" value="${listing}" />
			<button type="submit">Submit</button>
		</form>
	</div>
</body>
</html>