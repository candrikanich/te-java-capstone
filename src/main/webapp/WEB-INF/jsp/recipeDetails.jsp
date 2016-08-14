<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2><c:out value="${recipe.recipeName}"/></h2>
</div>
 	
 	<h3>Ingredients</h3>
 	<ul class="list-group">
	 	<c:forEach items="${ingredients}" var="ingredient">
	 		<li class="list-group-item"><c:out value="${ingredient.quantityName}"/>&nbsp;<c:out value="${ingredient.unit}"/>&nbsp;<c:out value="${ingredient.ingredientName}"/></li>
	 	</c:forEach>
 	</ul>
 	
 	<h3>Instructions</h3>
 	<p><c:out value="${recipe.instructions}"/> </p>
 	
<c:import url="/WEB-INF/jsp/footer.jsp" />