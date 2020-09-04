<%@page import="com.welcomeHomeRealtyCaseStudy.entities.UserLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Home Realty</title>
<%@ include file="pageStyle.jsp" %>

</head>
	
<body>
	<Header>
		<div class="row mb-5">
			<div class="col-md-12">
				<nav
					class="navbar navbar-expand-lg navbar-light fixed-top bg-light d-flex ">
					<a class="navbar-brand" href="#"> <img
						src="resources/images/logo.png" style="height: 70px;">
					</a>
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>

					<div class="collapse navbar-collapse " id="navbarSupportedContent">
						<ul class="navbar-nav ">
							<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index">Home
									<span class="sr-only">(current)</span>
							</a></li>
							<li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/about">About</a>
							</li>
							<li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/contact">Contact
									Us</a></li>
							<c:if test ="${userLogin.role >1}" >
							<li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/buildings">Buildings</a>
							</li>
							</c:if>
							<c:if test ="${userLogin.role>0}" >
							<li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/tenants">Tenants</a>
							</li>
							</c:if>
							<c:if test ="${userLogin.role >1}" >
							<li class="nav-item "><a class="nav-link" href="${pageContext.request.contextPath}/invoices">Invoices</a>
							</li>
							</c:if>
						</ul>

						<ul class="navbar-nav ml-auto">
							<c:if test = "${userLogin.userName==null}" >
							<li class="nav-item "><a class="nav-link " href="${pageContext.request.contextPath}/loginProfile">Login</a></li>
							<li class="nav-item"><a class="nav-link " href="${pageContext.request.contextPath}/signUpProfile">Sign
									Up</a></li>	
							</c:if >
							<c:if test ="${userLogin.userName!= null}" >
							<li class="nav-item "><a class="nav-link "">Welcome ${userLogin.userName}</a></li>
							<li class="nav-item "><a class="nav-link " href="${pageContext.request.contextPath}/logout">Logout</a></li>
							</c:if>
							
							
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</header>

	<div class="row mb-5">
		<div class="col-md-12 pr-0 d-none d-sm-block">
			<img class="headerImage" src="resources/images/headerImage.jpg">
		</div>
	</div>


	<div class="row cardsRow justify-content-center h-50 mb-5">
		<div class="col-10 mt-5 col-md-3 d-flex">
			<div class="card flex-fill text-center">
				<div class="card-header text-center text-white bgBlue">
					<p>About</p>
				</div>
				<div class="card-body">
					<p>Welcome Home Realty manages 1000+ residential properties
						throughout New York.Want to know more? Click the button below.</p>
				</div>
				<div class="card-footer bg-light">
					<a class="btn btn-lg text-white bgBlue" href="about">About</a>
				</div>
			</div>
		</div>

		<div class="col-10 mt-5 col-md-3 d-flex ">
			<div class="card flex-fill text-center">
				<div class="card-header text-white bgBlue">
					<p>Contact</p>
				</div>
				<div class="card-body">
					<p>Have a question? Click the button below to contact us.</p>
				</div>
				<div class="card-footer bg-light">
					<a class="btn btn-lg text-white bgBlue" href="contact">Contact
						Us</a>
				</div>
			</div>
		</div>

		<c:if test ="${userLogin.userName == null}" >
		<div class="col-10 mt-5 col-md-3 d-flex">
			<div class="card flex-fill text-center">
				<div class="card-header text-center text-white bgBlue">
					<p>Login</p>
				</div>
				<div class="card-body">
					<p>Login to your account to update profile information or make
						a payment.</p>
				</div>
				<div class="card-footer bg-light">
					<a class="btn btn-lg text-white bgBlue" href="loginProfile">Login</a>
				</div>
			</div>
		</div>
		</c:if>
		
		<c:if test ="${userLogin.userName != null}" >
		<div class="col-10 mt-5 col-md-3 d-flex">
			<div class="card flex-fill text-center">
				<div class="card-header text-center text-white bgBlue">
					<p>Tenants</p>
				</div>
				<div class="card-body">
					<p>Access your tenant records here.</p>
				</div>
				<div class="card-footer bg-light">
					<a class="btn btn-lg text-white bgBlue" href="tenants">Tenants</a>
				</div>
			</div>
		</div>
		</c:if>
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
