<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Sign Up</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-2 text-center mb-3">
				<h1>Sign Up</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<form id="signUpForm" action="signup">
				<div class="form-group row">
					<input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="First Name" pattern="[A-Za-z\s]*"  title="Only use letters in name."
						required>
				</div>
				<div class="form-group row">
					<input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="Last Name" pattern="[A-Za-z\s]*" title="Only use letters in name."
						required>
				</div>
				<div class="form-group row">
					<select id="building" name="buildingId" required>
						<c:forEach items="${buildingList}" var="buildings">
									<option value="${buildings.buildingId}" ${buildings== building? 'selected="selected" id="selectedBuilding"':''}>${buildings.buildingName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group row">
					<select id="apartment" name="apartmentId" required>
							<c:forEach items="${apartmentList}" var="apartments">
									<option id="apartmentOptions" value="${apartments.apartmentId}" ${apartments== apartment? 'selected="selected"':''}>${apartments.apartmentName}</option>
								</c:forEach>
					</select>
				</div>
				<div class="form-group row">
					<input type="text" class="form-control" id="phoneNumber"
						name="phoneNumber" placeholder="Phone Number" pattern="[\d]{10}"
						title="Phone number must be all numbers and max 10 numbers"
						required>
				</div>
				<div class="form-group row">
					<input type="text" class="form-control" id="email" name="email"
						placeholder="Email" required>
				</div>
				<div class="form-group row">
					<input type="text" class="form-control" id="userName"
						name="userName" placeholder="Username"
						pattern="[\w!@#$%.]{8,15}"
						title="Username must be between 8 and 15 characters and can contain letters, numbers, or these special characters: @#$%."
						required>
				</div>
				<div class="form-group row">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Password"
						pattern="[\w!@#$%.]{8,15}"
						title="Password must be between 8 and 15 characters and can contain letters, numbers, or these special characters: @#$%."
						required>
				</div>
				<div class="form-group row d-flex justify-content-center">
					<div class="col-md-8">
						<input type="submit" class="form-control btn btn-primary"
							id="button" required>
					</div>
				</div>
			</form>
		</div>

		<div class="row d-flex justify-content-center text-center">
			<div class="col-md-6">
				<p>Username and password must be between 8 and 15 characters and
					can contain letters, numbers, or these special characters: @#$%.</p>
			</div>
		</div>
		<div class="row d-flex justify-content-center">
			<div class="col-md-6" id="successMessage"></div>
		</div>
		<div class="row ">
			<div class="col-md-12 text-center">
				<p>
					Have an account? <a href="loginProfile">Log in here</a>
				</p>
			</div>
		</div>
		<div class ="row justify-content-center red">
			<div class="col-md-12 mt-3 text-center">
				<h3>${message}</h3>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
	
	
	<script>
	//Tenant Profile Page

	const selectBuildings = document.getElementById("building");
	var myMap = new Map();
	
	var myMap ={
			<c:forEach items="${buildingApartmentMap}" var="item" varStatus="loop">
		     ${item.key}: '${item.value}' ${not loop.last ? ',' : ''}
		     </c:forEach>
		};
	
	
	selectBuildings.addEventListener('change',clearApartmentList);
	
	function clearApartmentList(){
		var buildingId = document.getElementById("building").value;
		var apartmentListJs = myMap[buildingId];
		apartmentListJs = apartmentListJs.replace("{","").replace("}","");
		console.log(apartmentListJs);
		var splitApartmentListJs = apartmentListJs.split(", ");
		console.log(splitApartmentListJs);
		var selectApartments = document.getElementById("apartment");
		selectApartments.innerText ="";
		
		for(var i=0;i<splitApartmentListJs.length;i++){
			var option = document.createElement('option');
			option.value=splitApartmentListJs[i].substring(0,splitApartmentListJs[i].search("="));
			option.innerText = splitApartmentListJs[i].substring(splitApartmentListJs[i].search("=")+1);
			selectApartments.add(option);
		}	
		
	}
	</script>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	
</body>
</html>

<!-- add javascript to verify that username and login exist in database -->