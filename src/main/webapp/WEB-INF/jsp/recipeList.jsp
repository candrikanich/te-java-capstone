<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />
  <h1> ${currentUser}'s Recipes</h1>
  
  <ol class="user_recipe_list">
  	<c:forEach items="${recipes}" var="recipe">
  		<div class="recipe">
  			<c:url var="recipeHref" value="/users/${currentUser.userName}/recipeDetails">
  				<c:param name="recipeId">${recipe.recipeId}</c:param>
  				<c:param name="recipeId">${currentUser.userId}</c:param>
  			</c:url>
  			<a href="${recipeHref}" >
  				<c:out value="${recipe.recipeName}"/>
  			</a>
  			
  		</div>
  	</c:forEach>
  </ol>
 
 
 
<c:import url="/WEB-INF/jsp/footer.jsp" />