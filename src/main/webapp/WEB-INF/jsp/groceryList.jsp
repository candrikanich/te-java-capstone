<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Grocery List</h2>
</div>

<div class="row">

	<!-- GROCERY LIST -->
  <div class="grocery_list list-group col-md-5">
  
  	<ul>
  	
	  	<c:forEach items="${groceryList}" var="grocery">
	  	
			<c:url var="mealPlanHref" value="/users/${currentUser.userName}/groceryList">
				<c:param name="mealPlanId">${grocery.ingredient_id}</c:param>
				<c:param name="userId">${currentUser.userId}</c:param>
			</c:url>
			
			<li class="list-group-item">
				<c:out value="${grocery.ingredient_name}"/>
			</li>
	
	  	</c:forEach>
  	
  	</ul>
  </div>
  
 </div> 
 
<c:import url="/WEB-INF/jsp/footer.jsp" />