<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER -->
<div class="page-header">
	<h2>${currentUser.userName}'s Recipes</h2>
</div>
	
<c:forEach items="${recipes}" var="recipe">
	<div class="row">
		<div class="col-md-2"></div>		
			
		<div class="user_recipe_list list-group col-md-5">
			<c:url var="recipeHref" value="/users/${currentUser.userName}/recipeDetails">
				<c:param name="recipeId">${recipe.recipeId}</c:param>
			</c:url>
			<a class="recipe list-group-item" href="${recipeHref}">
				<c:out value="${recipe.recipeName}"/>
			</a>
		</div>
		
		<div class="col-md-3">
			<c:url var="editRecipeHref" value="/users/${currentUser.userName}/editRecipe">
				<c:param name="recipeId">${recipe.recipeId}</c:param>
			</c:url>
			<a href="${editRecipeHref}">
				<button type="button" class="btn btn-default btn-block"><span class="glyphicon glyphicon-edit">&nbsp;</span>Edit recipe</button>
			</a>
		</div>
		<div class="col-md-2"></div>
	 </div> 	
</c:forEach>
	
	<div class="row">
		<div class="col-md-2"></div>
			<div class="col-md-5">
				<!-- ADD NEW RECIPE TO LIST/LIBRARY -->
				<c:url var="addNewRecipeHref" value="/users/${currentUser.userName}/addNewRecipe" ></c:url>
				<a href="${addNewRecipeHref}">
					<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add a New Recipe</button>
				</a>
			</div>
	</div>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />