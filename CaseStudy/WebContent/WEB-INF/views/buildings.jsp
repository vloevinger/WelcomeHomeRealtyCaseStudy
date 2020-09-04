<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Buildings</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container form-container ">
	<div class="row justify-content-center mb-4">
			<div class="col-4 text-center">
				<h1>Buildings</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-11">
				<table class="table table-striped">
					<thead class="bgBlue">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Address</th>
							<th scope="col">Units</th>
							<th scope="col">Apartments</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody class="textBlue">
						<c:forEach items="${buildingList}" var="building">
							<tr>
								<td><a href="buildingProfile/${building.buildingId}">${building.buildingName}</a></td>
								<td>${building.address}, ${building.city},${building.state} ${building.zip}</td>
								<td>${building.units}</td>
								<td><a href="apartments/${building.buildingId}" class="btn btn-primary text-light">Apartments</a></td>
								<td><a href="deleteBuilding/${building.buildingId}" class="btn btn-primary text-light">Delete</a></td>
								</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		
	</div>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-11">
				<!-- landlord access only -->
				<a class="btn btn-primary text-light" href="buildingProfile/0">Add
					a New Building</a>
			</div>
		</div>
		<div class="row justify-content-center mt-5">
			<div class="col-11 text-center userMessage">
				${message}
			</div>
		</div>
	</div>



	<%@ include file="footer.jsp"%>

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
<!-- change login link to hello <Tenant Name> and add a log out feature -->
<!-- load tenant info from database -->