<%@page import="com.welcomeHomeRealtyCaseStudy.services.BuildingServices"%>
<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Building"%>
<%@page import="com.welcomeHomeRealtyCaseStudy.services.ApartmentServices"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Apartment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Tenant</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-4 text-center mb-3">
				<h1>Tenant Profile</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form id="updateTenantForm" action="${pageContext.request.contextPath}/tenantUpdate">
				
					<div class="form-group row">
						<input type="hidden" class="form-control" name="tenantId" value="${tenant.tenantId}">
					</div>
							
					<div class="form-group row">
						<label for="firstName" class="col-sm-4 col-form-label">First
							Name</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="firstName" name="firstName" value="${tenant.firstName}"
								placeholder="First Name" required pattern="[A-Za-z\s]*"
								title="Name may only contain letters">
						</div>
					</div>
					<div class="form-group row">
						<label for="lastName" class="col-sm-4 col-form-label">Last
							Name</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="lastName" name="lastName" value="${tenant.lastName}"
								placeholder="Last Name" required pattern="[A-Za-z\s]*"
								title="Name may only contain letters">
						</div>
					</div>
					<div class="form-group row">
						<label for="phone" class="col-sm-4 col-form-label">Phone</label>
						<div class="col-md-8">
							<input type="tel" class="form-control" id="phone" name="phoneNumber" value="${tenant.phoneNumber}"
								placeholder="Phone"
								pattern="\(*[0-9]{3}\)*\s*-*\s*[0-9]{3}\s*-*\s*[0-9]{4}"
								required
								title="Please enter a valid US phone number without - or ()">
						</div>
					</div>
					<div class="form-group row">
						<label for="email" class="col-sm-4 col-form-label">Last
							Name</label>
						<div class="col-md-8">
							<input type="email" class="form-control" id="email" name ="email" value="${tenant.email}"
								placeholder="Email" required>
						</div>
					</div>
				
					
					<!-- landlord access only -->
					<c:if test ="${userLogin.role >1}" >
					<div class="form-group row">
						<label for="building" class="col-sm-4 col-form-label" >Choose
							a Building</label>
						<div class="col-md-8">
							<select id="building2"  required>
								<c:forEach items="${buildingList}" var="buildings">
									<option value="${buildings.buildingId}" ${buildings== building? 'selected="selected" id="selectedBuilding"':''}>${buildings.buildingName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<!-- landlord access only -->
					</c:if>
					<c:if test ="${userLogin.role >1}" >
					<div class="form-group row">
						<label for="apartment2" class="col-sm-4 col-form-label">Choose
							An Apartment</label>
						<div class="col-md-8">
							<select id="apartment2" name="apartmentId" required>
								<c:forEach items="${apartmentList}" var="apartments">
									<option id="apartmentOptions" value="${apartments.apartmentId}" ${apartments== apartment? 'selected="selected"':''}>${apartments.apartmentName}</option>
								</c:forEach>
							</select>
							
						</div>
					</div>
					</c:if>
					<c:if test ="${userLogin.role ==1}" >
					<div class="form-group row d-none">
						<label for="apartment2" class="col-sm-4 col-form-label">Choose
							An Apartment</label>
						<div class="col-md-8 ">
							<select id="apartment2" name="apartmentId" required>
								<c:forEach items="${apartmentList}" var="apartments">
									<option id="apartmentOptions" value="${apartments.apartmentId}" ${apartments== apartment? 'selected="selected"':''}>${apartments.apartmentName}</option>
								</c:forEach>
							</select>
							
						</div>
					</div>
					</c:if>
					
					<c:if test ="${userLogin.role >1}" >
					<div class="form-group row">
						<label for="leaseStart" class="col-sm-4 col-form-label">Lease
							Start</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="leaseStart" name="leaseStart" value="${tenant.leaseStart}"
								value="2020-07" required
								title="Please enter 2 digit month and 4 digit year">
						</div>
					</div>
					</c:if>
					
					<c:if test ="${userLogin.role ==1}" >
					<div class="form-group row d-none">
						<label for="leaseStart" class="col-sm-4 col-form-label">Lease
							Start</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="leaseStart" name="leaseStart" value="${tenant.leaseStart}"
								value="2020-07" required
								title="Please enter 2 digit month and 4 digit year">
						</div>
					</div>
					</c:if>
					
					<c:if test ="${userLogin.role >1}">
					<div class="form-group row">
						<label for="leaseEnd" class="col-sm-4 col-form-label">Lease
							End</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="leaseEnd" name="leaseEnd" value="${tenant.leaseEnd}"
								value="2020-07" required
								title="Please enter 2 digit month and 4 digit year">
								
						</div>
					</div>
					</c:if>
			
					<c:if test ="${userLogin.role ==1}" >
					<div class="form-group row d-none">
						<label for="leaseEnd" class="col-sm-4 col-form-label">Lease
							End</label>
						<div class="col-md-8">
							<input type="date" class="form-control" id="leaseEnd" name="leaseEnd" value="${tenant.leaseEnd}"
								value="2020-07" required
								title="Please enter 2 digit month and 4 digit year">
						</div>
					</div>
					</c:if>
				
					<div class="form-group row d-flex justify-content-end">
						<div class="col-md-3 pr-0">
							<input type="submit"
								class="form-control btn btn-sm btn-primary pr-0" value="Save"
								id="button">
						</div>
						<div class="col-md-3 pl-1">
							<a href="${pageContext.request.contextPath}/tenants"
								class="form-control btn btn-sm btn-primary pl-0">Cancel</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="row  justify-content-center">
			<div class="col-md-5">
				<a href="${pageContext.request.contextPath}/tenants">Back to Tenant Page</a>
			</div>
		</div>
	</div>




	<%@ include file="footer.jsp"%>
	
	
	<script >
	//Tenant Profile Page

	const selectBuildings = document.getElementById("building2");
	var myMap = new Map();
	
	var myMap ={
		    <c:forEach items="${buildingApartmentMap}" var="item" varStatus="loop">
		     ${item.key}: '${item.value}' ${not loop.last ? ',' : ''}
		     </c:forEach>
	};
	
	
	selectBuildings.addEventListener('change',clearApartmentList);
	
	function clearApartmentList(){
		var buildingId = document.getElementById("building2").value;
		var apartmentListJs = myMap[buildingId];
		apartmentListJs = apartmentListJs.replace("{","").replace("}","");
		console.log(apartmentListJs);
		var splitApartmentListJs = apartmentListJs.split(", ");
		console.log(splitApartmentListJs);
		var selectApartments = document.getElementById("apartment2");
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
