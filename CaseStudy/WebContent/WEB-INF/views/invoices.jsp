<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Invoices</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center mb-4">
			<div class="col-4 text-center">
				<h1>Invoices</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-10">
				<table class="table table-striped">
					<thead class="bgBlue">
						<tr>
							<th scope="col">Invoice</th>
							<th scope="col">Tenant</th>
							<th scope="col">Description</th>
							<th scope="col">Amount</th>
							<th scope="col">Paid</th>
							<th scope="col">Delete</th>
						</tr>
					</thead>
					<tbody class="textBlue">
						<c:forEach items="${invoiceList}" var="invoice">
						<tr>
							<td><a href="${pageContext.request.contextPath}/invoiceProfile/${invoice.invoiceId}">${invoice.invoiceId}</a></td>
							<td>${invoice.tenant.firstName} ${invoice.tenant.lastName}</td>
							<td>${invoice.description}</td>
							<td>${invoice.amount}</td>
							<c:if test="${invoice.paid}">
							<td>Yes</td>
							</c:if>
							<c:if test="${!invoice.paid}">
							<td>No</td>
							</c:if>
							
							<td><a href="${pageContext.request.contextPath}/deleteInvoice/${invoice.invoiceId}" class="btn btn-primary text-light">Delete</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-10">
				<!-- landlord access only -->
				<a class="btn btn-primary text-light" href="${pageContext.request.contextPath}/invoiceProfile/0">Add a
					New Invoice</a>
			</div>
		</div>
		<div class ="row justify-content-center mt-3">
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