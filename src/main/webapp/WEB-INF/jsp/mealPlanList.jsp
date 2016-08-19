<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Meal Plans</h2>
</div>

<!-- LIST GROUP OF USER MEAL PLANS -->
<c:forEach items="${mealPlans}" var="mealPlan">  	
 	<div class="row">
 		<div class="col-sm-2"></div>
 		
	  	<div class="user_meal_plan_list list-group col-sm-5 col-xs-7">
			<c:url var="mealPlanHref" value="/users/${currentUser.userName}/mealPlanDetails">
				<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
			</c:url>
			<a class="mealPlan list-group-item" href="${mealPlanHref}">
				Meal Plan starting <c:out value="${mealPlan.mealPlanStartDate}"/>
			</a>
		</div>

		<div class="col-sm-3 col-xs-5">
			<c:url var="editMealPlanHref" value="/users/${currentUser.userName}/editMealPlan">
				<c:param name="mealPlanId">${mealPlan.mealPlanId}</c:param>
			</c:url>
			<a href="${editMealPlanHref}">
				<button type="button" class="btn btn-default btn-block"><span class="glyphicon glyphicon-edit">&nbsp;</span>Edit Meal Plan</button>
			</a>
		</div>
	
		<div class="col-sm-2"></div>
	</div> 
</c:forEach>

	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-4">
			<c:url var="addMealPlanHref" value="/users/${currentUser.userName}/createNewMealPlan" ></c:url>
			<a href="${addMealPlanHref}">
				<button type="submit" class="btn btn-default btn-block"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add a New Meal Plan </button>
			</a>			
		</div>
		<div class="col-sm-6"></div>
	</div>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />