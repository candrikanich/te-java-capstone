<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER - BOOTSTRAP -->
<div class="page-header">
	<h2>Add a Meal Plan</h2>
	<p>Use this form to add Meal Plans to your library for meal planning.</p>
</div>

<c:url var="formAction" value="/users/${userName}/addNewMealPlan">
	<c:param name="userId" value="${param.userId}" />
</c:url>

	<!-- ROW FOR FORM -->
	<div class="row">
		<div class="col-md-8">
		
			<form role="form" action="${formAction}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				
				<!-- GIVE IT A NAME -->
				<div class="form-group form-group-lg">
					<label for="mealPlanName">Meal Plan Name: </label>
					<input type="text" id="mealPlanName" name="mealPlanName" class="form-control" />	
				</div>
				
				<!-- ROW FOR EACH MEAL DAY -->
				<div class="form-group row">
				
					<!-- MEAL TYPE: IF EAT OUT THEN DISABLE MEAL SELECT FIELD -->
					<div class="col-md-4">
						<label>Meal Type:</label>
						<div class="radio">
						  <label><input type="radio" name="eatInOut">Eat-In</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="eatInOut">Eat-Out</label>
						</div>
					</div>
				
					<!-- CHOOSE FROM A LIST OF MEALS -->
					<div class="col-md-6">
						<label for="recipeId1">Day 1 Meal:</label>	
						<select class="form-control input-sm" name="recipeId1" id="recipeId1">
								<option value="#">Choose recipe</option>
							<c:forEach items="${allRecipes}" var="recipe">
								<option value="${recipe.recipeID}">${recipe.recipeId}</option>	
							</c:forEach>
						</select>
					</div>
					
					<!-- COPIED OVER FROM RECIPES, NOT SURE IF APPLICABLE HERE -->
					<div class="col-md-2">
						<label>Add/Remove:</label>
						<div class="btn-group">
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>	
					</div>
					
				</div>
				
				<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add Meal Plan</button>
			
			</form>
		</div>
		
		<!-- EMPTY SPACE: COULD BE USED TO WRITE UP INSTRUCTIONS, OR SHOW AWESOME PHOTO OF CHRIS'S WICKED TACOS-->
		<div class="col-md-4"></div>
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />