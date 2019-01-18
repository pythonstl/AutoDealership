<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.app.model.Listing" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Edit</title>

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
	<c:if test="${listing != null}">
	<!-- form -->
	<div class="container">
		<form action="AdminEditController" method="post">
			<label for="images">Add images.</label>
			<input name="images" type="file" class="form-control" placeholder="image Base64" multiple />
			<br>
			
			<label for="condition">What is the condition of the vehicle?</label>
			<div>Current: <c:out value="${listing.vehicle.condition}" /></div>
			<div id="condition">
				<label class="radio-inline"><input name="isNew" type="radio" value="false" checked />Used</label>
				<label class="radio-inline"><input name="isNew" type="radio" value="true" />New</label>
			</div>
			<br>
			
			<label for="year">Year</label>
			<div>Current: <c:out value="${listing.vehicle.year}" /></div>
			<select name="year" class="form-control" id="year" size="5">
				<option value="" disabled selected>Select</option>
				<c:forEach var="i" begin="1995" end="2019">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<br>
			
			<label for="make">Make</label>
			<div>Current: <c:out value="${listing.vehicle.make}" /></div>
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
			<div>Current: <c:out value="${listing.vehicle.model}" /></div>
			<select name="model" class="form-control" id="model">
				<option>Please choose from above.</option>
			</select>
			<br>
			
			<label for="color">Color</label>
			<div>Current: <c:out value="${listing.vehicle.color}" /></div>
			<select name="color" class="form-control" id="color" size="5">
				<option value="" disabled selected>Select</option>
				<option value="Black" selected>Black</option>
				<option value="Blue">Blue</option>
				<option value="Brown">Brown</option>
				<option value="Gold">Gold</option>
				<option value="Green">Green</option>
				<option value="Maroon">Maroon</option>
				<option value="Orange">Orange</option>
				<option value="Pink">Pink</option>
				<option value="Red">Red</option>
				<option value="Silver">Silver</option>
				<option value="Teal">Teal</option>
				<option value="Violet">Violet</option>
				<option value="White">White</option>
				<option value="Yellow">Yellow</option>
			</select>
			<br>
			
			<label for="mileage">Mileage</label>
			<div>Current: <c:out value="${listing.vehicle.mileage}" /></div>
			<div id="mileage">
				<input name="mileage" type="text" class="form-control" placeholder="Provide the mileage." />
			</div>
			<br>
			
			<label for="drive">Drive</label>
			<div>Current: <c:out value="${listing.vehicle.drive}" /></div>
			<select name="drive" class="form-control" id="drive">
				<option value="All-Wheel Drive">All-Wheel Drive</option>
				<option value="Front-Wheel Drive">Front-Wheel Drive</option>
				<option value="Rear-Wheel Drive">Rear-Wheel Drive</option>
			</select>
			<br>
			
			<label for="transmission">What type of transmission does the vehicle have?</label>
			<div>Current: <c:out value="${listing.vehicle.transmission}" /></div>
			<div id="transmission">
				<label class="radio-inline"><input name="transmission" type="radio" value="Automatic" checked />Automatic</label>
				<label class="radio-inline"><input name="transmission" type="radio" value="Standard" />Standard</label>
			</div>
			<br>
			
			<label for="fuel">What is the fuel type?</label>
			<div>Current: <c:out value="${listing.vehicle.fuel}" /></div>
			<div id="fuel">
				<label class="radio-inline"><input name="fuel" type="radio" value="Gasoline" checked />Gasoline</label>
				<label class="radio-inline"><input name="fuel" type="radio" value="Hybrid" />Hybrid</label>
			</div>
			<br>
			
			<label for="mpg">Miles Per Gallon</label>
			<div>Current: <c:out value="${listing.vehicle.mpg}" /></div>
			<select name="mpg" class="form-control" id="mpg">
				<option value="" disabled selected>Select</option>
				<c:forEach var="i" begin="10" end="60">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<br>
			
			<label for="interior">What material is the upholstery?</label>
			<div>Current: <c:out value="${listing.vehicle.interior}" /></div>
			<div id="interior">
				<label class="radio-inline"><input name="interior" type="radio" value="Cloth" checked />Cloth</label>
				<label class="radio-inline"><input name="interior" type="radio" value="Leather" />Leather</label>
				<label class="radio-inline"><input name="interior" type="radio" value="Polyester" />Polyester</label>
			</div>
			<br>
			
			<label for="description">Description</label>
			<div>Current: <c:out value="${listing.vehicle.description}" /></div>
			<textarea name="description" class="form-control" rows="3" id="description" placeholder="Describe the vehicle."></textarea>
			<br>
			
			<label for="askingPrice">Asking Price</label>
			<div>Current: <c:out value="${listing.askingPrice}" /></div>
			<div id="askingPrice">
				<input name="askingPrice" type="text" class="form-control" placeholder="$ What is the asking price?" />
			</div>
			<br>
			
			<!-- 
			<label for="listingDate">Today's Date</label>
			<input name="listingDate" type="text" id="datepicker" class="form-control" />
			<br>
			-->
			
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	</c:if>
	<!-- /form -->
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