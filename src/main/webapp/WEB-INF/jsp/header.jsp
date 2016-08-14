<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Meal Planner 5000</title>
		
		<!-- STYLESHEETS -->
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" href="http://localhost:8080/capstone/css/styles.css">
		<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
		
		<!-- JAVASCRIPT / jQUERY / BOOTSTRAP SCRIPTS -->
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
	    <script src="http://localhost:8080/capstone/js/siteScripts.js"></script>
		
		<!-- CUSTOM SCRIPTS -->
		

	</head>
	<body>
		
		<header class="container-fluid">
			<div class="row">
				<h1>Meal Planner 5000</h1>
				<p>The best way to plan meals</p>
			</div>
		</header>
		
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
				    	<span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span> 
					</button>
					
				  <c:url var="homepageHref" value="/" />	
			      <a class="navbar-brand" href="${homepageHref}">Meal Planner 5000</a>
			    </div>
			    
				<div class="collapse navbar-collapse" id="myNavbar">
					<ul class="nav navbar-nav">
					  
					  	<c:url var="homepageHref" value="/users/${currentUser.userName}" />
						<li data-toggle="collapse" data-target=".navbar-collapse" class="home active">
							<a id="btn-home" href="${homepageHref}">
						    	<span class="glyphicon glyphicon-home">&nbsp;</span>Home</a>
						</li>
						
						<c:if test="${not empty currentUser}">
						
							<c:url var="myRecipesHref" value="/users/${currentUser.userName}/recipeList">
								<c:param name="userId">${currentUser.userId}</c:param>
							</c:url>
							<li data-toggle="collapse" data-target=".navbar-collapse" class="myRecipes"><a id="btn-myRecipes" href="${myRecipesHref}"><span class="glyphicon glyphicon-th-list">&nbsp;</span>My Recipes<span class="badge">5</span></a></li>
							
							<c:url var="myMealPlanHref" value="#"/>
							<li data-toggle="collapse" data-target=".navbar-collapse" class="myMealPlan"><a id="btn-myMealPlan" href="${myMealPlanHref}"><span class="glyphicon glyphicon-calendar">&nbsp;</span>My Meal Plan<span class="badge">3</span></a></li>  		        
							
							<c:url var="myGroceryListHref" value="#"/>
							<li data-toggle="collapse" data-target=".navbar-collapse" class="myGroceryList">
								<a id="btn-groceryList" href="${myGroceryListHref}"><span class="glyphicon glyphicon-shopping-cart">&nbsp;</span>My Grocery List<span class="badge">Coming Soon!</span></a></li>
							</ul>

						</c:if>
						
						<ul class="nav navbar-nav navbar-right">
						
						<c:choose>
							<c:when test="${empty currentUser}">
							
								<c:url var="newUserHref" value="/users/new" />
								<li data-toggle="collapse" data-target=".navbar-collapse"><a href="${newUserHref}"><span class="glyphicon glyphicon-user">&nbsp;</span>Sign Up</a></li>
								
								<c:url var="loginHref" value="/login" />
								<li data-toggle="collapse" data-target=".navbar-collapse"><a href="${loginHref}"><span class="glyphicon glyphicon-log-in">&nbsp;</span>Login</a></li>
					
							</c:when>
							<c:otherwise>
							
								<c:url var="logoutAction" value="/logout" />
								<form id="logoutForm" action="${logoutAction}" method="POST">
									<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
								</form>
								<c:url var="changePasswordHref" value="/users/${currentUser.userName}/changePassword" />
								<li><a href="${changePasswordHref}"><span class="glyphicon glyphicon-random">&nbsp;</span>Change Password</a></li>
								<li data-toggle="collapse" data-target=".navbar-collapse"><a id="logoutLink" href="#"><span class="glyphicon glyphicon-log-out">&nbsp;</span>Log Out</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
			    </div>
			</div>
		</nav>
		
		<section id="mainContent" class="container">
			<div class="row">
				<div class="col-md-12">
				
<!-- END HEADER JSP -->