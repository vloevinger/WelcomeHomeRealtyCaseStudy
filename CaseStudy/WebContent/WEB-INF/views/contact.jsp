<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Contact</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="row">
			<div
				class="col-md-6 d-flex flex-column align-items-center justify-content-center">
				<div class="row mb-5">
					<h1>Contact Us</h1>
				</div>
				<div class="row">
					<table>
						<tr>
							<td>Phone:</td>
							<td>(800) 555-5555</td>
						</tr>
						<tr>
							<td>Fax:</td>
							<td>(800) 555-5556</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td><a href="mailto:welcomehomerealtyny@gmail.com"
								target="_blank">welcomehomerealtyny@gmail.com</a></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="col-md-6 d-none d-md-block">
				<img src="resources/images/movingIn.jpg" class="contactImage">
			</div>
		</div>


		<div class="container m-5">
			<div class="row">
				<div class="col-md-6 d
				-none d-md-block">
					<img src="resources/images/movingIn2.jpg" class="contactImage">
				</div>
				<div class="col-10 col-md-6">
					<form method="post" id="contactForm" action="contact">
						<div class="form-group row">
							<label for="name" class="col-sm-2 col-form-label">Name</label>
							<div class="col-md-8">
								<input type="name" class="form-control" id="name"
									placeholder="Name" required pattern="[A-Za-z\s]*"
									title="Name may only contain letters">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-2 col-form-label">Phone</label>
							<div class="col-md-8">
								<input type="tel" class="form-control" id="phone"
									placeholder="Phone"
									pattern="\(*[0-9]{3}\)*\s*-*\s*[0-9]{3}\s*-*\s*[0-9]{4}"
									required
									title="Please enter a valid US phone number without - or ()">
							</div>
						</div>
						<div class="form-group row">
							<label for="email" class="col-sm-2 col-form-label">Email</label>
							<div class="col-md-8">
								<input type="email" class="form-control" id="email"
									placeholder="Email" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="info" class="col-sm-2 col-form-label">More
								Info</label>
							<div class="col-md-8">
								<textarea class="form-control" id="info" rows="3" required></textarea>
							</div>
						</div>
						<div class="form-group row">
							<div class="col-sm-10 text-right">
								<button type="submit" class="btn btn-primary"
									id="submitButttonContact">Send</button>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row d-flex justify-content-end">
				<div class="col-md-6" id="successMessage"></div>
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
	<script src="resources/scripts/contactScript.js"></script>
</body>
</html>
