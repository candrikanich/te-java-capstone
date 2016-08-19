<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/jsp/header.jsp" />
 
<div class="page-header">
	<h2>Welcome to Meal Planner 5000</h2>
	<h3>The Best Way to Plan Meals</h3>
</div>
 
<div class="row">
	<div class="col-md-6">
		<h4>My Recipes</h4>
	</div>
	<div class="col-md-6">
		<h4>My Meal Plans</h4>
	</div>
</div>
 
 
<div class="row">
	<div class="col-md-3">
		<c:url var="addNewRecipeHref" value="/users/${currentUser.userName}/addNewRecipe" ></c:url>
		<a href="${addNewRecipeHref}">
			<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add a New Recipe</button>
		</a>
	</div>
	<div class="col-md-3">
		<c:url var="allRecipesHref" value="/users/${currentUser.userName}/recipeList" ></c:url>
		<a href="${allRecipesHref}">
			<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-eye-open">&nbsp;</span>View All Recipes</button>
		</a>
	</div>
	<div class="col-md-3">
		<c:url var="addMealPlanHref" value="/users/${currentUser.userName}/createNewMealPlan" ></c:url>
		<a href="${addMealPlanHref}">
			<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add a New Meal Plan </button>
		</a>
	</div>
	<div class="col-md-3">
		<c:url var="allMealPlansHref" value="/users/${currentUser.userName}/mealPlanList" ></c:url>
		<a href="${allMealPlansHref}">
			<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-eye-open">&nbsp;</span>View All Meal Plans</button>
		</a>
	</div>
</div>
 
 
<c:import url="/WEB-INF/jsp/footer.jsp" />