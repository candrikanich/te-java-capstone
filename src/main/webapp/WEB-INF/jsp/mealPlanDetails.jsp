<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER - BOOTSTRAP -->
<div class="page-header">
	<h2>Meal Plan starting <c:out value="${mealPlan.mealPlanStartDate}"/> </h2>
</div>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-5">
	 	<h3>Meals</h3>
 	</div>
 	<div class="col-md-3">
 		<c:url var="myGroceryListHref" value="/users/${currentUser.userName}/groceryList">
	 		<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
	 	</c:url>
		<a id="btn-groceryList" href="${myGroceryListHref}">
			<button type="button" class="btn btn-default btn-block"><span class="glyphicon glyphicon-shopping-cart">&nbsp;</span>Create Shopping List</button>
		</a>
 	</div>
 	<div class="col-md-2"></div>
</div>

<c:forEach items="${joinedRecipeRecords}" var="recipeRecord">
	<c:url var="mealPlanRecipeHref" value="/users/${currentUser.userName}/recipeDetails">
	<c:param name="recipeId">${recipeRecord.recipeId}</c:param>
</c:url>

	<div class="row">
		<div class="col-md-2"></div>
		<div class="col-md-8">
		
			<a href="${mealPlanRecipeHref}" class="list-group-item">
				<h4 class="list-group-item-heading"><c:out value="${recipeRecord.mealDayOfWeek}"/></h4>
				<p class="list-group-item-text"><c:out value="${recipeRecord.recipeName}"/></p>
			</a>

		</div>
		
		<div class="col-md-2"></div>
	</div>
</c:forEach>
 	
<c:import url="/WEB-INF/jsp/footer.jsp" />