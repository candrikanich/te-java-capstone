<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<title>Meal Planner 5000</title>
			<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
		    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
		    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
		    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
		    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
			
			<script type="text/javascript">
			$(document).ready(function() {
				
				$("#logoutLink").click(function(event){
					$("#logoutForm").submit();
				});
				
				/* var pathname = window.location.pathname;
				$("nav a[href='"+pathname+"']").parent().addClass("active"); */
				
			});
			
			
		</script>
	</head>
	<body>
		<header>
			<div><h1>Meal Planner 5000</h1></div>
		</header>
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<c:url var="homepageHref" value="/" />
					<li><a href="${homepageHref }">Home</a></li>
					<c:if test="${not empty currentUser}">
						<c:url var="myRecipesHref" value="/receipsList"/>
						<li><a href="${myRecipesHref }">My Recipes</a></li>
						<c:url var="myMealPlanHref" value="#"/>
						<li><a href="${myMealPlanHref }" >My Meal Plan</a></li>
						<c:url var="myGroceryListHref" value="#"/>
						<li><a href="${myGroceryListHref }">My GroceryList</a></li>
					</c:if>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${empty currentUser}">
							<c:url var="newUserHref" value="/users/new" />
							<li><a href="${newUserHref}">Sign Up</a></li>
							<c:url var="loginHref" value="/login" />
							<li><a href="${loginHref}">Log In</a></li>
						</c:when>
						<c:otherwise>
							<c:url var="logoutAction" value="/logout" />
							<form id="logoutForm" action="${logoutAction}" method="POST">
								<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
							</form>
							<li><a id="logoutLink" href="#">Log Out</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
	