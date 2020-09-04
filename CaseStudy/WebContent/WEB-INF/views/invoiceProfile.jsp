<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Invoice</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-4 text-center mb-3">
				<h1>Invoice Information</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-5">
				<form id="updateTenantForm" action="${pageContext.request.contextPath}/invoiceUpdate">
					<div class="col-md-8">
							<input type="hidden" class="form-control" id="invoiceId" name="invoiceId" value="${invoice.invoiceId}">
					</div>
					
					<div class="form-group row">
						<label for="Tenant" class="col-sm-4 col-form-label">Choose
							Tenant</label>
						<div class="col-md-8" >
							<select id="tenant" name="tenantId" required>
								<c:forEach items="${tenantList}" var="tenants">
									<option value="${tenants.tenantId}" ${tenants== tenant? 'selected="selected" id="selectedTenant"':''}>
								${tenants.firstName} ${tenants.lastName} - ${tenants.apartment.building.buildingName} - ${tenants.apartment.apartmentName} </option>
								</c:forEach>
								
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="description" class="col-sm-4 col-form-label">Description</label>
						<div class="col-md-8">
							<input type="text" class="form-control" id="description" name="description" value="${invoice.description}"
								placeholder="Description" required>
						</div>
					</div>


					<div class="form-group row">
						<label for="amount" class="col-sm-4 col-form-label">Amount</label>
						<div class="col-md-8">
							<input type="number" class="form-control" id="amount" name="amount" value="${invoice.amount}"
							placeholder="Amount" required step="any" required>
						</div>
					</div>

					<div class="form-group row">
						<label for="paid" class="col-sm-4 col-form-label">Paid</label>
						<div class="col-md-8">
						<select id="paid" name="paid" required>
							<c:if test="${invoice.paid}">
								<option value="true" selected>Yes</option>
								<option value="false">No</option>
							</c:if>
							<c:if test="${!invoice.paid}">
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
							<a href="${pageContext.request.contextPath}/invoices"
								class="form-control btn btn-sm btn-primary pl-0">Cancel</a>
						</div>
					</div>

				</form>
			</div>
		</div>
		<div class="row  justify-content-center">
			<div class="col-md-5">
				<a href="${pageContext.request.contextPath}/invoices">Back to Invoice Page</a>
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
<!--  -->