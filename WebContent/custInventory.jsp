<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="com.app.model.Listings" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inventory</title>

<!-- Bootstrap: Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap: Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/image.css">
<link rel="stylesheet" type="text/css" href="WebContent/thumbnails.css">
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
		<c:if test="${notFound}">
			<h3>No matches found!</h3>
		</c:if>
		<div class="container">
		<form action="SearchController" method="get">
			<label for="make">Make</label>
			<select name="make" class="form-control" id="make" size="5">
				<option value="" disabled selected>Select</option>
				<option value="Honda">Honda</option>
				<option value="Hyundai">Hyundai</option>
				<option value="Mitsubishi">Mitsubishi</option>
				<option value="Nissan">Nissan</option>
				<option value="Subaru">Subaru</option>
				<option value="Toyota">Toyota</option>
			</select>
			<br>
			<label for="model">Model</label>
			<select name="model" class="form-control" id="model">
				<option>Please choose from above.</option>
			</select>
			<br>
		<button class="btn btn-info btn-lg text-center" type="submit">Search</button>
		</form>
		</div>
		
		<c:if test="${noMatches != null}">
			<br>
			<h3>No matches were found!</h3>
			<br>
		</c:if>
		<div>
		<c:if test="${noMatches != null}">
			<br>
				<h3>No matches were found!</h3>
			<br>
		</c:if>
		</div>
	<!-- inventory -->
	<c:if test="${listings != null}">
			<div class="container">
				<div class="row">
					<c:forEach var="listing" items="${listings.iterator()}">
				 		<div class="col-sm-6 col-md-4">
				 		<br>
    						<div class="thumbnail">
    							<c:url var="imageEnc" value="${listing.vehicle.images.get(0)}"></c:url>
      							<img src="data:image/png;base64,${imageEnc}"  alt="Vehicle Image" class="img-rounded"
      								style="width:95%;height:200px" />
      							<div class="caption">
        						<h3>
        							<c:out value="${listing.vehicle.year}" />
        							<c:out value="${listing.vehicle.make}" />
        							<c:out value="${listing.vehicle.model}" />	
        							<br>
        							<fmt:setLocale value = "en_US"/>
         							<fmt:formatNumber value = "${listing.askingPrice}" type = "currency"/>
        						</h3>
        						<p><c:out value="${listing.vehicle.description}" /></p>
        						<div>
        							<form action="ViewListingController" method="get">
										<input type="hidden" name="listingId" value="${listing.id}" />
										<button class="btn btn-primary" type="submit">View</button>
									</form></div>
      							</div>
    						</div>
  						</div>
  					</c:forEach>
				</div>
			</div>
	</c:if>
	<!-- /inventory -->
		 <script>
 	// Automatically selects year 2019, if new:
 	$(function() {
 		$("#condition").change(function() {
 	 		$("#year option[value=2019]").attr('selected','selected');
 	 		// Prevents other choices.
 	 		//$("#year").attr('disabled','disabled');
 		});
 	}); 
 	
 	// Makes make/model drop-down menus dynamic:
    $(function() {
        $("#make").change(function() {
            $("#model").load("menu-dropdowns/" + $(this).val() + ".txt");
        });
    });
	</script>
</body>
</html>