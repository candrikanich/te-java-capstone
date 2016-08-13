<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>${currentUser.userName}'s Recipes</h2>
	<p>Use this form to add recipes to your library for meal planning.</p>
</div>
 
  <div class="user_recipe_list list-group">
  	<c:forEach items="${recipes}" var="recipe">
  		<a class="recipe list-group-item" href="${recipeHref}" >
  			<c:url var="recipeHref" value="/users/${currentUser.userName}/recipeDetails">
  				<c:param name="recipeId">${recipe.recipeId}</c:param>
  				<c:param name="userId">${currentUser.userId}</c:param>
  			</c:url>
  			<c:out value="${recipe.recipeName}"/>
  		</a>
  	</c:forEach>
  </div>
	
	<c:url var="saveRecipeHref" value="/users/${currentUser.userName}/addNewRecipe" >
		<c:param name="userId">${currentUser.userId}</c:param>
	</c:url>
	<a href="${saveRecipeHref}">
		<button type="submit" class="btn btn-lg">Add a New Recipe</button>
	</a>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />