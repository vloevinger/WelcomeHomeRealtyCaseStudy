<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Make Payment</title>

<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-4 text-center mb-3">
				<h1>Make a Payment</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-6">
				<form id="updateTenantForm" action="${pageContext.request.contextPath}/makePayment">
					<div class="form-group row">
						<label for="invoice" class="col-sm-3 col-form-label">Choose
							Invoice</label>
						<div class="col-md-6">
							<select id="invoice" name="invoiceId" class="form-control" required>
								<c:forEach items="${invoiceList}" var="invoice">
									<option value="${invoice.invoiceId}" >${invoice.description} - ${invoice.amount} </option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="form-group row">
						<label for="name" class="col-sm-3 col-form-label">Name On
							Card</label>
						<div class="col-md-6">
							<input type="text" class="form-control" id="firstName"
								placeholder="Name On Card" required pattern="[A-Za-z\s]*"
								title="Name may only contain letters">
						</div>
					</div>
					<div class="form-group row">
						<label for="cardNumber" class="col-sm-3 col-form-label">Card
							Number</label>
						<div class="col-md-6">
							<input type="number" class="form-control" id="name"
								placeholder="card Number" required pattern="[0-9]*"
								title="Card Number may only contain numbers">
						</div>
					</div>
					<div class="form-group row">
						<label for="expirationDate" class="col-sm-3 col-form-label">Expiration
							Date</label>
						<div class="col-md-6">
							<input type="date" class="form-control" id="expirationDate"
								min="2020-07" value="2020-07" required
								title="Please enter 2 digit month and 4 digit year">
						</div>
					</div>
					<div class="form-group row">
						<label for="securityCode" class="col-sm-3 col-form-label">Security
							Code</label>
						<div class="col-md-6">
							<input type="number" class="form-control" id="securityCode"
								placeholder="Security Code" required pattern="[0-9]*"
								title="Security Card may only contain numbers">
						</div>
					</div>
					
					<div class="form-group row d-flex justify-content-center">
						<div class="col-md-3 pr-0">
							<input type="submit"
								class="form-control btn btn-sm btn-primary pr-0"
								value="Make Payment" id="button">
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
			<div class="col-md-6">
				<a href="${pageContext.request.contextPath}/tenants">Back to Tenant Page</a>
			</div>
		</div>
		<div class ="row justify-content-center">
			<div class="col-md-6 mt-3">
				${message}
			</div>
		</div>
		<div class ="row justify-content-center">
			<div class="col-md-6 mt-3 text-center">
				${userMessage}
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
<!-- make date picker month and year only -->
<!-- find payment api -->