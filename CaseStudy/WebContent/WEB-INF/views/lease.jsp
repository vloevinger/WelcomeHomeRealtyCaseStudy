<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Lease</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>

	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center mb-4">
		<div class="col-4 text-center">
			<h1>Lease</h3>
		</div>
	</div>
		<div class="row  justify-content-center">
			<div class="col-md-12">
		
				<object data="${pageContext.request.contextPath}/resources/leases/${leaseName}"
					type="application/pdf" width="100%" height="800px">
					<p class="text=center">
						Your lease  has not been added to the database yet. Please call the office for assistance.
					</p>
				</object>
			</div>
		</div>
		<div class="row  justify-content-center mt-4">
			<div class="col-md-12">
				<a href="${pageContext.request.contextPath}/tenants">Back to Tenant Page</a>
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
<!-- load leases from database -->