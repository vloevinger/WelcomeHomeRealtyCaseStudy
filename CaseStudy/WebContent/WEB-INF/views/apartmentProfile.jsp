<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Building"%>
<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Apartment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Apartment</title>
<%@ include file="pageStyle.jsp" %>
</head>

<body>

 
<jsp:include page="header.jsp" />


	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-6 text-center mb-3">
				<h1>Apartment Profile - ${building.buildingName}</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form id="updateTenantForm" action="${pageContext.request.contextPath}/updateApartment/${building.buildingId}">
				
					
					<div class="form-group row d-none">
							<input type="text" class="form-control" name="apartmentId" value="${apartment.apartmentId}">
					</div>
					<div class="form-group row">
						<label for="apartmentName" class="col-sm-5 col-form-label">Apartment
							Name</label>
						<div class="col-md-7">
							<input type="text" class="form-control" id="apartmentName" name="apartmentName" value="${apartment.apartmentName}"
								placeholder="Apartment Number" required pattern="[0-9A-Za-z]*"
								title="Apartment number may only contain letters and numbers">
						</div>
					</div>
					<div class="form-group row">
						<label for="rooms" class="col-sm-5 col-form-label">Rooms</label>
						<div class="col-md-7">
							<input type="number" class="form-control" id="rooms" name="rooms" value="${apartment.rooms}"
								placeholder="Rooms" required 
								title="Rooms may only contain numbers">
						</div>
					</div>

					<div class="form-group row">
						<label for="bedrooms" class="col-sm-5 col-form-label">Bedrooms</label>
						<div class="col-md-7">
							<input type="number" class="form-control" id="bedrooms" name="bedrooms" value="${apartment.bedrooms}"
								placeholder="Bedrooms" required
								title="Bedrooms may only contain numbers">
						</div>
					</div>
					<div class="form-group row">
						<label for="bathrooms" class="col-sm-5 col-form-label">Bathrooms</label>
						<div class="col-md-7">
							<input type="number" class="form-control" id="bathrooms" name="bathrooms" value="${apartment.bathrooms}"
								placeholder="Bathrooms" required step="any"
								title="Bathroom may only contain numbers and a .">
						</div>
					</div>

					<div class="form-group row">
						<label for="sqft" class="col-sm-5 col-form-label">Square
							Feet</label>
						<div class="col-md-7">
							<input type="number" class="form-control" id="sqft" name="squareFeet" value="${apartment.squareFeet}"
								placeholder="Square Feet" required "
								title="Square feet may only contain numbers">
						</div>
					</div>
						
					<div class="form-group row">
						<label for="rented" class="col-sm-5 col-form-label">Rented</label>
						<div class="col-md-7">
						<select id="rented" name="rented" required>	
							<c:if test="${apartment.rented}">
								<option value="true" selected>Yes</option>
								<option value="false">No</option>
							</c:if>
							<c:if test="${!apartment.rented}">
								<option value="true" >Yes</option>
								<option value="false" selected>No</option>
							</c:if>
						</select>
						</div>
					</div>	
											
			
					<div class="form-group row d-flex justify-content-end">
						<div class="col-md-3 pr-0">
							<input type="submit" 
								class="form-control btn btn-sm btn-primary pr-0" value="Save"
								id="button">
						</div>
						<div class="col-md-3 pl-1">
							<a href="${pageContext.request.contextPath}/apartments/${building.buildingId}"
								class="form-control btn btn-sm btn-primary pl-0">Cancel</a>
						</div>
					</div>
				</form>
				
				
			</div>
		</div>
		<div class="row  justify-content-center">
			<div class="col-md-5">
				<a href="${pageContext.request.contextPath}/apartments/${building.buildingId}">Back to Apartments Page</a>
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
