<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>About</title>
<%@ include file="pageStyle.jsp" %>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container mt-5 h-50">
		<div class="row d-flex justify-content-center mt-5">
			<div class="col-md-9">
				<div id="carouselExampleFade" class="carousel slide carousel-fade"
					data-ride="carousel">
					<div class="carousel-inner">
						<div class="carousel-item active">
							<img src="resources/images/apartmentImage1.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="resources/images/apartmentImage2.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="resources/images/apartmentImage3.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="resources/images/apartmentImage4.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="resources/images/apartmentImage5.jpg"
								class="d-block w-100" alt="...">
						</div>
						<div class="carousel-item">
							<img src="resources/images/apartmentImage6.jpg"
								class="d-block w-100" alt="...">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleFade"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleFade"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</div>
	</div>


	<div class="container mt-5 mb-5 ">
		<div class="row d-flex justify-content-center">
			<div class="col-md-9 ">
				<h3>About Us</h3>
				<p>Welcome Home Realty owns 1000+ residential properties
					throughout New York, New Jersey, and Pennsylvania. Founded in 2010,
					Welcome Home Realty has provided housing for over 100,000 tri-state
					residents. Welcome Home Realty-- when you're here, you're home.</p>
			</div>
		</div>

	</div>


	<div class="container mt-5 mb-5 ">
		<div class="row d-flex justify-content-center">
			<div class="col-md-9">
				<h3>Meet the team</h3>
				<div class="teamMember">
					<div class="row mb-5">
						<div class="col-md-2">
							<img src="resources/images/valerieLoevinger.jpg" class="teamImg ">
						</div>
						<div class="col-md-10">
							<p>Valerie Loevinger, Founder & CEO</p>
							<p>Valerie has been working the residential property for over
								20 years. Valerie founded Welcome Home Realty in 2010 to provide
								a better housing solutions to residents of the tri-state area.</p>
						</div>
					</div>
				</div>

				<div class="teamMember">
					<div class="row mb-5">
						<div class="col-md-2">
							<img src="resources/images/markSmith.jpg" class="teamImg ">
						</div>
						<div class="col-md-10">
							<p>Mark Smith, CFO</p>
							<p>Mark received an MBA from Harvard in 2000 and then went on
								to become the youngest accountant of the year award recipient
								for 3 years in a row. After working his way up the corporate
								success chain, Mark joined Welcome Home Realty so he could
								people find homes they love.</p>
						</div>
					</div>
				</div>

				<div class="teamMember">
					<div class="row mb-5">
						<div class="col-md-2">
							<img src="resources/images/andrewWebber.jpg" class="teamImg ">
						</div>
						<div class="col-md-10">
							<p>Andrew Webber, Director of Acquisitions</p>
							<p>Andrew has 30 year experience researching and analyzing
								property acquisitions. Andrew has worked at Welcome Home Realty
								since its inception and is a valued member of the team.</p>
						</div>
					</div>
				</div>

				<div class="teamMember">
					<div class="row mb-5">
						<div class="col-md-2">
							<img src="resources/images/lillyFlounder.jpg" class="teamImg ">
						</div>
						<div class="col-md-10">
							<p>Lilly Flounder, Property Manager</p>
							<p>Lilly is an efficient and effective property manager. She
								masterfully handles all property management and tenant issues.</p>
						</div>
					</div>
				</div>

				<div class="teamMember">
					<div class="row mb-5">
						<div class="col-md-2">
							<img src="resources/images/jackFitzgerald.jpg" class="teamImg ">
						</div>
						<div class="col-md-10">
							<p>Jack Fitzgerald, Property Manager</p>
							<p>Jack joined the company straight out of Harvard Business
								School and has been a huge asset ever since. He has implemented
								new strategies to manage multiple properties without breaking a
								sweat.</p>
						</div>
					</div>
				</div>
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