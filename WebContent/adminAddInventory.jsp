<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- imports JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin | Add Inventory</title>

<!-- Bootstrap: Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Bootstrap: Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- custom JS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
<script type="text/javascript" src="/js/adminAddVehicle.js"></script>
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
	<div style="margin-top: 100px"></div>
	
	<!-- form -->
	<div class="container">
		<form action="AdminAddInventoryController" method="post">
			<!--<label for="photo">Upload an image of the vehicle.</label>
			<input name="photo" type="file" class="form-control" />
			<br>-->
			<label for="images">Add images.</label>
			<input name="images" type="file" id="inp" class="form-control" placeholder="image Base64" multiple />
			<br>
			
			<label for="condition">What is the condition of the vehicle?</label>
			<div id="condition">
				<label class="radio-inline"><input name="isNew" type="radio" value="false" checked />Used</label>
				<label class="radio-inline"><input name="isNew" type="radio" value="true" />New</label>
			</div>
			<br>
			
			<label for="year">Year</label>
			<select name="year" class="form-control" id="year" size="5">
				<option value="" disabled selected>Select</option>
				<c:forEach var="i" begin="1995" end="2019">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<br>
			
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
			
			<label for="color">Color</label>
			<select name="color" class="form-control" id="color" size="5">
				<option value="" disabled selected>Select</option>
				<option value="black" selected>Black</option>
				<option value="blue">Blue</option>
				<option value="brown">Brown</option>
				<option value="gold">Gold</option>
				<option value="green">Green</option>
				<option value="maroon">Maroon</option>
				<option value="orange">Orange</option>
				<option value="pink">Pink</option>
				<option value="red">Red</option>
				<option value="silver">Silver</option>
				<option value="teal">Teal</option>
				<option value="violet">Violet</option>
				<option value="white">White</option>
				<option value="yellow">Yellow</option>
			</select>
			<br>
			
			<label for="mileage">Mileage</label>
			<div id="mileage">
				<input name="mileage" type="text" class="form-control" placeholder="Provide the mileage." />
			</div>
			<br>
			
			<label for="drive">Drive</label>
			<select name="drive" class="form-control" id="drive">
				<option value="four-wheel drive">All-Wheel Drive</option>
				<option value="front-wheel drive">Front-Wheel Drive</option>
				<option value="rear-wheel drive">Rear-Wheel Drive</option>
			</select>
			<br>
			
			<label for="transmission">What type of transmission does the vehicle have?</label>
			<div id="transmission">
				<label class="radio-inline"><input name="transmission" type="radio" value="automatic" checked />Automatic</label>
				<label class="radio-inline"><input name="transmission" type="radio" value="standard" />Standard</label>
			</div>
			<br>
			
			<label for="fuel">What is the fuel type?</label>
			<div id="fuel">
				<label class="radio-inline"><input name="fuel" type="radio" value="gasoline" checked />Gasoline</label>
				<label class="radio-inline"><input name="fuel" type="radio" value="hybrid" />Hybrid</label>
			</div>
			<br>
			
			<label for="mpg">Miles Per Gallon</label>
			<select name="mpg" class="form-control" id="mpg">
				<option value="" disabled selected>Select</option>
				<c:forEach var="i" begin="10" end="60">
					<option value="${i}">${i}</option>
				</c:forEach>
			</select>
			<br>
			
			<label for="interior">What material is the upholstery?</label>
			<div id="interior">
				<label class="radio-inline"><input name="interior" type="radio" value="cloth" checked />Cloth</label>
				<label class="radio-inline"><input name="interior" type="radio" value="leather" />Leather</label>
				<label class="radio-inline"><input name="interior" type="radio" value="polyester" />Polyester</label>
			</div>
			<br>
			
			<label for="description">Description</label>
			<textarea name="description" class="form-control" rows="3" id="description" placeholder="Describe the vehicle."></textarea>
			<br>
			
			<label for="askingPrice">Asking Price</label>
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