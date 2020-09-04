<%@page import="com.welcomeHomeRealtyCaseStudy.entities.UserLogin"%>
<%@page import="java.util.List"%>
<%@page import="com.welcomeHomeRealtyCaseStudy.entities.Tenant"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.welcomeHomeRealtyCaseStudy.services.TenantServices" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>

<title>Tenants</title>
<%@ include file="pageStyle.jsp" %>

</head>

<body>

	<jsp:include page="header.jsp" />
	<div class="container form-container ">
	<div class="row justify-content-center mb-4">
		<div class="col-4 text-center">
			<h1>Tenants</h3>
		</div>
	</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped">
					<thead class="bgBlue">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Building</th>
							<th scope="col">Apartment</th>
							<th scope="col">Balance</th>
							<th scope="col">Lease</th>
							<c:if test ="${userLogin.role ==1}" >
							<th scope="col">Payment</th>
							</c:if>								
							<c:if test ="${userLogin.role >1}" >
							<th scope="col">Delete</th>
							</c:if>
							
						</tr>
					</thead>
					<tbody class="textBlue">
					
					<c:forEach items="${tenantList}" var="tenant">
						
						<tr>
							<td><a href="${pageContext.request.contextPath}/tenantProfile/${tenant.tenantId}">${tenant.firstName} ${tenant.lastName} </a></td>
							<td>${tenant.apartment.building.buildingName}</td>
							<td>${tenant.apartment.apartmentName}</td>
							<td>
							<% 
								Tenant tenantFound = (Tenant)(pageContext.findAttribute("tenant")); 
								TenantServices tenantService = new TenantServices();	
								double balance = tenantService.getTenantBalanceService(tenantFound);
								java.util.Formatter formatter = new java.util.Formatter();
								
								out.print(formatter.format("%.2f", balance));
								formatter.close();
							%>
							
							</td>
						
							<td><a href="${pageContext.request.contextPath}/lease/${tenant.tenantId}_${tenant.apartment.apartmentId}.pdf" class="btn btn-primary text-light">View</a></td>
							<!-- tenant access only -->
							
							<c:if test ="${userLogin.role ==1}" >
							<td><a href="${pageContext.request.contextPath}/makePaymentProfile/${tenant.tenantId}" class="btn btn-primary text-light">Pay</a></td>
							</c:if>
							<!-- landlord access only -->
							
							<c:if test ="${userLogin.role > 1}" >
							<td><a href="${pageContext.request.contextPath}/deleteTenant/${tenant.tenantId}" class="btn btn-primary text-light">Delete</a></td>
							</c:if>
							
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row justify-content-center mb-3">
			<div class="col-md-10">
				<!-- landlord access only -->
				<c:if test ="${userLogin.role > 1}" >
				<a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/tenantProfile/0">Add a
					New Tenant</a>
				</c:if>
			</div>
		</div>
		<div class ="row justify-content-center">
			<div class="col-md-10">
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