<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<%@ include file="pageStyle.jsp" %>
</head>

<body>

	<jsp:include page="header.jsp" />

	<div class="container form-container ">
		<div class="row justify-content-center">
			<div class="col-md-2 text-center mb-3">
				<h1>Login</h1>
			</div>
		</div>
		<div class="row justify-content-center">
			<form id="loginForm" action="login">
				<div class="form-group row">
					<input type="text" class="form-control" id="userName"
						name="userName" placeholder="Username"
						pattern="[\w!@#$%.]{8,15}"
						title="Username must be between 8 and 15 characters and can contain letters, numbers, or these special characters: @#$%."
						required>
				</div>
				<div class="form-group row">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="Password"
						pattern="[\w!@#$%.]{8,15}"
						title="Password must be between 8 and 15 characters and can contain letters, numbers, or these special characters: @#$%."
						required>
				</div>
				<div class="form-group row d-flex justify-content-center">
					<div class="col-md-8">
						<input type="submit" class="form-control btn btn-primary"
							id="button" required>
					</div>
				</div>
			</form>
		</div>

		<div class="row">
			<div class="col-md-12 text-center">
				<p>
					Don't have an account? <a href="signUpProfile">Sign up here</a>
				</p>
			</div>
		</div>
		<div class ="row justify-content-center red mb-5">
			<div class="col-md-12 mt-3 text-center">
				<h3>${message}</h3>
			</div>
		</div>
	</div>
	<div class="row id=addMarginBottom"></div>
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