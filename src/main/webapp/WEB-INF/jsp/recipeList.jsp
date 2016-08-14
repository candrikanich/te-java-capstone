<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER -->
<div class="page-header">
	<h2>${currentUser.userName}'s Recipes</h2>
</div>

<div class="row">
	
<div class="user_recipe_list list-group col-md-5">
	<c:forEach items="${recipes}" var="recipe">
		<a class="recipe list-group-item" href="${recipeHref}">
		<c:url var="recipeHref" value="/users/${currentUser.userName}/recipeDetails">
			<c:param name="recipeId">${recipe.recipeId}</c:param>
			<c:param name="userId">${currentUser.userId}</c:param>
		</c:url>
		<c:out value="${recipe.recipeName}"/>
		</a>
	</c:forEach>
</div>
  
  <div class="col-md-7">
  	<iframe id="recipeDetail">
  		Click for recipe detail
  	</iframe>
  </div>
  
 </div> 
	
	<c:url var="addNewRecipeHref" value="/users/${currentUser.userName}/addNewRecipe" >
		<c:param name="userId">${currentUser.userId}</c:param>
	</c:url>
	<a href="${addNewRecipeHref}">
		<button type="submit" class="btn btn-lg">Add a New Recipe</button>
	</a>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />