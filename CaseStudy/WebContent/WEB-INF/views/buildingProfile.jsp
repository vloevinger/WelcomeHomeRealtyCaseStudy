<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Building"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Building</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-4 text-center mb-3">
				<h1>Building Profile</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form id="updateTenantForm" action="${pageContext.request.contextPath}/updateBuilding">
				
					<div class="form-group row d-none">
						<input type="text" class="form-control" name="buildingId" value="${building.buildingId}">
					</div>
					<div class="form-group row">
						<label for="name" class="col-sm-4 col-form-label">Name</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="name" name="buildingName" value="${building.buildingName}"
								placeholder="Name" required pattern="[A-Za-z\s]*"
								title="Name may only contain letters">
						</div>
					</div>
					<div class="form-group row">
						<label for="address" class="col-sm-4 col-form-label">Address</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="address" name="address" value="${building.address}"
								placeholder="Address" required pattern="[A-Za-z0-9\s]*"
								title="Address may only contain letters and numbers">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="city" class="col-sm-4 col-form-label">City</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="city" name="city" value="${building.city}"
								placeholder="City" required pattern="[A-Za-z\s]*"
								title="city may only contain letters and spaces">
						</div>
					</div>

					<div class="form-group row">
						<label for="State" class="col-sm-4 col-form-label">State</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="state" name="state" value="${building.state}"
								placeholder="City" required pattern="[A-Za-z]*{2}"
								title="State may only contain 2 Letter">
						</div>
					</div>

					<div class="form-group row">
						<label for="zipCode" class="col-sm-4 col-form-label">Zip
							Code</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="zipCode" name="zip" value="${building.zip}"
								placeholder="Zip Code" required pattern="[0-9-\s]*"
								title="Zip Code may only contain numbers and a dash">
						</div>
					</div>

					<div class="form-group row">
						<label for="units" class="col-sm-4 col-form-label">Units</label>
						<div class="col-md-8">
							<input type="number" class="form-control" id="unit" name="units" value ="${building.units}"
								placeholder="Units" required pattern="[0-9]*"
								title="Units may only contain numbers">
						</div>
					</div>

					<div class="form-group row">
						<label for="cost" class="col-sm-4 col-form-label">Cost</label>
						<div class="col-md-8">
							<input type="number" class="form-control" id="cost" name="cost" value="${building.cost}"
								placeholder="cost" required pattern="[0-9].*"
								title="Cost may only contain numbers and a .">
						</div>
					</div>

					<div class="form-group row">
						<label for="dateBought" class="col-sm-4 col-form-label">Date
							Bought</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="dateBought" name="datePurchased"
								value="${building.datePurchased}" required>
						</div>
					</div>

					<div class="form-group row">
						<label for="dateSold" class="col-sm-4 col-form-label">Date
							Sold</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="dateSold" name="dateSold"
							 value="${building.dateSold}" >
						</div>
					</div>
					
					<div class="form-group row">
						<label for="salePrice" class="col-sm-4 col-form-label">Sale Price</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="salePrice" name="salePrice"
								value="${building.salePrice}" >
						</div>
					</div>

					<div class="form-group row d-flex justify-content-end">
						<div class="col-md-3 pr-0">
							<input type="submit"
								class="form-control btn btn-sm btn-primary pr-0" value="Save"
								id="button">
						</div>
						<div class="col-md-3 pl-1">
							<a href="${pageContext.request.contextPath}/buildings"
								class="form-control btn btn-sm btn-primary pl-0">Cancel</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row  justify-content-center">
			<div class="col-md-5">
				<a href="${pageContext.request.contextPath}/buildings">Back to Building Page</a>
			</div>
		</div >
		<div class="row  justify-content-center userMessage">
					${message}
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
