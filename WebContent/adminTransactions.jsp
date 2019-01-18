<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Transactions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Transactions</title>

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
				<a class="navbar-brand" href="index.jsp">Asian Imports</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><form action="GetInventoryController" method="get">
						<input type="hidden" value="">
						<button type="submit" class="btn btn-link navbar-btn">Inventory</button>
					</form></li>
					<li><form action="contact.jsp" method="get">
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
	
	<!-- transactions -->
	<c:if test="${transactions != null}">
		<table id="dtBasicExample" class="table table-striped table-bordered table-sm">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Transaction</th>
					<th scope="col">Sold</th>
					<th scope="col">Listed</th>
					<th scope="col">First</th>
					<th scope="col">Last</th>
					<th scope="col">Street</th>
					<th scope="col">City</th>
					<th scope="col">State</th>
					<th scope="col">Zip</th>
					<th scope="col">Telephone</th>
					<th scope="col">E-mail</th>
					<th scope="col">V.I.N.</th>
					<th scope="col">Year</th>
					<th scope="col">Make</th>
					<th scope="col">Model</th>
					<th scope="col">Net Sale</th>
					<th scope="col">Tax</th>
					<th scope="col">Total</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="transaction" items="${transactions.iterator()}" varStatus="loop">
					<tr>
						<td><c:out value="${loop.index + 1}" /></td>
						<td><c:out value="${transaction.id}" /></td>
						<td><c:out value="${transaction.saleDate}" /></td>
						<td><c:out value="${transaction.listing.listingDate}" /></td>
						<td><c:out value="${transaction.customer.firstName}" /></td>
						<td><c:out value="${transaction.customer.lastName}" /></td>
						<td><c:out value="${transaction.customer.address.street}" /></td>
						<td><c:out value="${transaction.customer.address.city}" /></td>
						<td><c:out value="${transaction.customer.address.state}" /></td>
						<td><c:out value="${transaction.customer.address.zip}" /></td>
						<td><c:out value="${transaction.customer.address.telephone}" /></td>
						<td><c:out value="${transaction.customer.address.email}" /></td>
						<td><c:out value="${transaction.listing.vehicle.vin}" /></td>
						<td><c:out value="${transaction.listing.vehicle.year}" /></td>
						<td><c:out value="${transaction.listing.vehicle.make}" /></td>
						<td><c:out value="${transaction.listing.vehicle.model}" /></td>
						<td><c:out value="${transaction.salePrice}" /></td>
						<td><c:out value="${transaction.tax}" /></td>
						<td><c:out value="${transaction.total}" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<!-- /transactions -->
</body>
</html>