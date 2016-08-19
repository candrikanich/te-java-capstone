<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Grocery List</h2>
</div>

<div class="row">
	<div class="col-md-2"></div>
	<!-- GROCERY LIST -->
  	<div class="grocery_list list-group col-md-8">
  
	  	<ul>
	  	
		  	<c:forEach items="${groceryList}" var="grocery">
		  	
				<c:url var="mealPlanHref" value="/users/${currentUser.userName}/groceryList">
					<c:param name="userId">${currentUser.userId}</c:param>
				</c:url>
				
				<li class="list-group-item">
					<span class="glyphicon glyphicon-unchecked">&nbsp;</span><c:out value="${grocery.ingredientName}"/>
				</li>
		
		  	</c:forEach>
	  	
	  	</ul>
	</div>
  	<div class="col-md-2"></div>
 </div> 
 
<c:import url="/WEB-INF/jsp/footer.jsp" />