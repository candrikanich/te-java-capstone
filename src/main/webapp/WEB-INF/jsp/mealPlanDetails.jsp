<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER - BOOTSTRAP -->
<div class="page-header">
	<h2>Meal Plan starting <c:out value="${mealPlan.mealPlanStartDate}"/> </h2>
</div>

 	<h3>Meals</h3>
 	<div class="list-group">
	 	<c:forEach items="${joinedRecipeRecords}" var="recipeRecord">
		 	<c:url var="mealPlanRecipeHref" value="/users/${currentUser.userName}/recipeDetails">
				<c:param name="recipeId">${recipeRecord.recipeId}</c:param>
				<c:param name="userId">${currentUser.userId}</c:param>
			</c:url>
		 	
		 	<a href="${mealPlanRecipeHref}" class="list-group-item">
		 		<h4 class="list-group-item-heading"><c:out value="${recipeRecord.mealDayOfWeek}"/></h4>
		 		<p class="list-group-item-text"><c:out value="${recipeRecord.recipeName}"/></p>
		 	</a>
	 	</c:forEach>
 	</div>
 	
<c:import url="/WEB-INF/jsp/footer.jsp" />