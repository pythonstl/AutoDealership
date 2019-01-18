<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Listing" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Details</title>

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
	<c:if test="${success != null}">
		<div><c:out value="${success}" /></div>
	</c:if>
	
	<!-- inventory -->
	<c:if test="${listing != null}">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Listing #</th>
					<th scope="col">V.I.N.</th>
					<th scope="col">Images</th>
					<th scope="col">Condition</th>
					<th scope="col">Year</th>
					<th scope="col">Make</th>
					<th scope="col">Model</th>
					<th scope="col">Color</th>
					<th scope="col">Mileage</th>
					<th scope="col">Drive</th>
					<th scope="col">Transmission</th>
					<th scope="col">Fuel</th>
					<th scope="col">M.P.G.</th>
					<th scope="col">Interior</th>
					<th scope="col">Description</th>
					<th scope="col">Asking Price</th>
					<th scope="col">Listing Date</th>
					<th scope="col">Days On Market</th>
				</tr>
			</thead>
			<tbody>
					<tr>
						<td>
							<div class="row">
								<form action="AdminEditController" method="get">
									<input type="hidden" name="listingId" value="${listing.id}" />
									<button class="btn btn-primary" type="submit">Edit</button>
								</form>
							</div>
						</td>
						<td><c:out value="${listing.id}" /></td>
						<td><c:out value="${listing.vehicle.vin}" /></td>
						<td>
							<c:forEach var="image" items="${listing.vehicle.images}" varStatus="loop">
								<c:url var="imageEnc" value="${listing.vehicle.images.get(loop.index)}"></c:url>
								<img src="data:image/png;base64,${imageEnc}" />
							</c:forEach>
						</td>
						<td><c:out value="${listing.vehicle.condition}" /></td>
						<td><c:out value="${listing.vehicle.year}" /></td>
						<td><c:out value="${listing.vehicle.make}" /></td>
						<td><c:out value="${listing.vehicle.model}" /></td>
						<td><c:out value="${listing.vehicle.color}" /></td>
						<td><c:out value="${listing.vehicle.mileage}" /></td>
						<td><c:out value="${listing.vehicle.drive}" /></td>
						<td><c:out value="${listing.vehicle.transmission}" /></td>
						<td><c:out value="${listing.vehicle.fuel}" /></td>
						<td><c:out value="${listing.vehicle.mpg}" /></td>
						<td><c:out value="${listing.vehicle.interior}" /></td>
						<td><c:out value="${listing.vehicle.description}" /></td>
						<td><c:out value="${listing.askingPrice}" /></td>
						<td><c:out value="${listing.listingDate}" /></td>
						<td><c:out value="${listing.daysOnMarket}" /></td>
					</tr>
			</tbody>
		</table>
	</c:if>
	<!-- /inventory -->
	
	<div class="modal-body">
   		<div class="first-column">
       		<!-- Your first column here -->
   		</div>
   		<div class="second-column">
       		<!-- Your second column here -->
   		</div>
	</div>
	
	
	<!-- inventory -->	
		<c:if test="${listing != null}">
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