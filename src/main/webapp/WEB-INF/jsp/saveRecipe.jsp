<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<h2>Save a Recipe</h2>

<c:url var="formAction" value="/users/${userName}/saveRecipe" />

<div class="row">
	<div class="col-md-5">
		<form action="${formAction}" method="POST" id="changePasswordForm">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<div class="form-group">
				<label for="recipeName">Recipe Name: </label>
				<input type="text" id="recipeName" name="recipeName" class="form-control" />	
			</div>
			<div class="form-group">
				<label for="ingredient">Ingredients: </label>
				<input type="text" id="ingredient" name="ingredient" class="form-control" />	
			</div>
			<div class="form-group">
				<label for="instructions">Instructions: </label>
				<input type="text" id="instructions" name="instructions" class="form-control" />	
			</div>
			<button type="submit" class="btn btn-default">Save Recipe</button>
		</form>
	</div>

	<div class="col-md-7"></div>
</div>


<c:import url="/WEB-INF/jsp/footer.jsp" />