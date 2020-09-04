<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container form-container ">
		<div class="row justify-content-center mb-4">
			<div class="col-6 text-center">
				<h1>Ooops...Something went wrong!</h1>
				<h3> We are sorry for the error. Please contact the office for help.</h3>
			</div>
		</div>
	</div>
</body>
</html>