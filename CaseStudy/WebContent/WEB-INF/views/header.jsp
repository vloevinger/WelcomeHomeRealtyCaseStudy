<%@page import="com.welcomeHomeRealtyCaseStudy.entities.UserLogin"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%! public UserLogin sessionLogin = null; %>
<body>
<%sessionLogin =  (UserLogin)session.getAttribute("userLogin");  %>
	<Header>
		<div class="row addMarginToNavbar">
			<div class="col-md-12">
				<nav
					class="navbar navbar-expand-lg navbar-light  fixed-top  bg-light mb-5 ">
					<a class="navbar-brand" href="#"> <img
						src="${pageContext.request.contextPath}/resources/images/logo.png" style="height: 70px;">
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

</body>
</html>
