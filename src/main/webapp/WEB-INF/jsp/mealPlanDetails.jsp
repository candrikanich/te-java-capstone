<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER - BOOTSTRAP -->
<div class="page-header">
	<h2>Meal Plan for <c:out value="${mealPlan.mealPlanStartDate}"/> &ndash; <c:out value="${mealPlan.mealPlanEndDate}"/></h2>
</div>
 	

 	<h3>Recipes</h3>
 	<ul class="list-group">
	 	<c:forEach items="${mealPlanRecipes}" var="recipe">
		 	<c:url var="mealPlanRecipeHref" value="/users/${currentUser.userName}/recipeDetails">
				<c:param name="recipeId">${recipe.recipeId}</c:param>
				<c:param name="userId">${currentUser.userId}</c:param>
			</c:url>
		 	<a href="${mealPlanRecipeHref}" class="list-group-item">
		 		<li class="list-group-item"><c:out value="${recipe.recipeName}"/></li>
		 	</a>
	 	</c:forEach>
 	</ul>
 	
 	
 	<hr />
 	
 	<h4>This is sample data</h4>
 	
 	<p>For each day in the meal plan, show the day # and the recipe name with link to the recipe detail<p>

<!-- LIST GROUP SHOWING ALL RECIPES IN A SPECIFIC MEAL PLAN  -->
<div class="list-group">

	<!-- DAY 1 RECIPE -->
	<a href="#" class="list-group-item active">
		<h4 class="list-group-item-heading">Day 1</h4>
		<p class="list-group-item-text">Mac-N-Cheese</p>
	</a>
	
	<!-- DAY 2 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 2</h4>
		<p class="list-group-item-text">Chris' Wicked Tacos</p>
	</a>
	
	<!-- DAY 3 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 3</h4>
		<p class="list-group-item-text">Rebecca's Carrot Soup</p>
	</a>
	
	<!-- DAY 4 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 4</h4>
		<p class="list-group-item-text">Jim's Beer Can Chicken</p>
	</a>
	
	<!-- DAY 5 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 5</h4>
		<p class="list-group-item-text">Ray's Hot-lanta Burger</p>
	</a>
	
	<!-- DAY 6 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 6</h4>
		<p class="list-group-item-text">David's Tofu Salad</p>
	</a>
	
	<!-- DAY 7 RECIPE -->
	<a href="#" class="list-group-item">
		<h4 class="list-group-item-heading">Day 7</h4>
		<p class="list-group-item-text">Ice Cream for Dinner</p>
	</a>
</div>
 	
<c:import url="/WEB-INF/jsp/footer.jsp" />