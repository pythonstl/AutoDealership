<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Listings" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Inventory</title>

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
	<div class="text-center">
	<form action="adminAddInventory.jsp">
		<button class="btn btn-info btn-lg text-center" type="submit">Add Vehicle</button>
	</form>
	</div>
	<br>
	<!-- inventory -->	
		<c:if test="${listings != null}">
			<div class="container">
				<div class="row flex">
					<c:forEach var="listing" items="${listings.iterator()}">
				 		<div class="col-sm-6 col-md-4">
    						<div class="thumbnail bg-warning">
    							<c:url var="imageEnc" value="${listing.vehicle.images.get(0)}"></c:url>
      							<img src="data:image/png;base64,${imageEnc}" alt="Vehicle Image" class="img-rounded"
      								style="width:95%;height:200px"/>
      							<div class="caption">
        						<h3>
        							<c:out value="${listing.vehicle.year}" />
        							<c:out value="${listing.vehicle.make}" />
        							<c:out value="${listing.vehicle.model}" />	
        							<br>
        							$<c:out value="${listing.askingPrice}" />	
        						</h3>
        						<div>
        						Color: <c:out value="${listing.vehicle.color}" />
        						<br>
        						Mileage: <c:out value="${listing.vehicle.mileage}" />
        						<br>
        						Transmission: <c:out value="${listing.vehicle.transmission}"/>
        						<br>
								Fuel: <c:out value="${listing.vehicle.fuel}" />
								<br>
								M.P.G.: <c:out value="${listing.vehicle.mpg}" />
								<br>
								Interior: <c:out value="${listing.vehicle.interior}" />
								<br>
								Listed: <c:out value="${listing.listingDate}" />
								<br>
								Days Since: <c:out value="${listing.daysOnMarket}" />
								</div>
								<br>
								<div class="row">
        						<div class="col-md-3">
        							<form action="AdminViewListingController" method="get">
										<input type="hidden" name="listingId" value="${listing.id}" />
										<button class="btn btn-info" type="submit">View</button>
									</form>
								</div>

								<div class="col-md-3">
        							<form action="AdminDeleteController" method="get">
										<input type="hidden" name="listingId" value="${listing.id}" />
										<button class="btn btn-warning" type="submit">Delete</button>
									</form>
								</div>
								</div>
      						</div>
    					</div>
  					</div>
  				</c:forEach>
			</div>
		</div>
	</c:if>
	<!-- /inventory -->
</body>
</html>