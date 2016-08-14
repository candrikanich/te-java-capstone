<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Meal Plans</h2>
</div>

<div class="row">

  <div class="user_meal_plan_list list-group col-md-5">
  	<c:forEach items="${mealPlans}" var="mealPlan">
  		<a class="mealPlan list-group-item">
  			<c:url var="mealPlanHref" value="/users/${currentUser.userName}/mealPlanDetails">
  				<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
  				<c:param name="userId">${currentUser.userId}</c:param>
  			</c:url>
  			<c:out value="${mealPlan.mealPlanName}"/>
  		</a>
  	</c:forEach>
  </div>
  
  <div class="col-md-7">
  	<iframe src="${mealPlanHref}">
  		Click for meal plan detail
  	</iframe>
  </div>
  
 </div> 
	
	<c:url var="addMealPlanHref" value="/users/${currentUser.userName}/addNewMealPlan" >
		<c:param name="userId">${currentUser.userId}</c:param>
	</c:url>
	<a href="${addMealPlanHref}">
		<button type="submit" class="btn btn-lg">Add a New Meal Plan</button>
	</a>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />