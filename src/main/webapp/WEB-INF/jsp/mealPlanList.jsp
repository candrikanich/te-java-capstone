<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Meal Plans</h2>
</div>

<div class="row">

	<!-- LIST GROUP OF USER MEAL PLANS -->
  <div class="user_meal_plan_list list-group col-md-5">
  	<c:forEach items="${mealPlans}" var="mealPlan">
		<c:url var="mealPlanHref" value="/users/${currentUser.userName}/mealPlanDetails">
			<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
			<c:param name="userId">${currentUser.userId}</c:param>
		</c:url>
		<a class="mealPlan list-group-item" href="${mealPlanHref}">
			Meal Plan starting <c:out value="${mealPlan.mealPlanStartDate}"/>
		</a>
		<c:url var="editMealPlanHref" value="/users/${currentUser.userName}/editMealPlan">
			<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
			<c:param name="userId">${currentUser.userId}</c:param>
		</c:url>
		<a href="${editMealPlanHref}">
			<button type="button" class="btn btn-sm">Edit Meal Plan</button>
		</a>
  	</c:forEach>
  </div>
  
 </div> 
	
	<c:url var="addMealPlanHref" value="/users/${currentUser.userName}/createNewMealPlan" >
		<c:param name="userId">${currentUser.userId}</c:param>
	</c:url>
	<a href="${addMealPlanHref}">
		<button type="submit" class="btn btn-lg">Add a New Meal Plan <span class="badge">Coming Soon!</span></button>
	</a>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />