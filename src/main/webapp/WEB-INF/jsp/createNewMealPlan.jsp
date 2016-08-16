<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<!-- PAGE HEADER - BOOTSTRAP -->
<div class="page-header">
	<h2>Create a Meal Plan</h2>
	<p>Use this form to add Meal Plans to your library for meal planning.</p>
</div>

<c:url var="formAction" value="/users/${userName}/createNewMealPlan">
	<c:param name="userId" value="${currentUser.userId}" />
</c:url>

	<!-- ROW FOR FORM -->
	<div class="row">
		<div class="col-md-8">
		
			<form role="form" action="${formAction}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				
				<!-- PICK A START DATE -->
				<div class="form-group form-group row">
					<div class="col-xs-9">
						<label for="mealPlanStartDate">Meal plan for the week of: </label>
						<input type="text" id="mealPlanStartDate" name="mealPlanStartDate" class="form-control" />	
					</div>
					
					<div class="col-xs-3">
						<label for="createMealPlanDateList">Create Plan</label>
						<button type="button" class="btn btn-default btn-block btn-add" id="submitMealPlanStartDate">
							<span class="glyphicon glyphicon-calendar"></span>
						</button>	
					</div>
					<!-- <label for="mealPlanEndDate">Meal Plan End Date: </label>
					<input type="date" id="mealPlanEndDate" name="mealPlanEndDate" class="form-control" />	 -->
				</div>
				
				<!-- ROW FOR EACH MEAL DAY -->
				<div class="form-group row">
				
					<!-- MEAL TYPE: IF EAT OUT THEN DISABLE MEAL SELECT FIELD -->
					<!-- <div class="col-md-4">
						<label>Meal Type:</label>
						<div class="radio">
						  <label><input type="radio" name="eatInOut">Eat-In</label>
						</div>
						<div class="radio">
						  <label><input type="radio" name="eatInOut">Eat-Out</label>
						</div>
					</div> -->
				
					<!-- CHOOSE FROM A LIST OF MEALS -->
					<div class="col-md-6">
						<div id="mealContainer">
						
						</div>
							<label for="recipeId1">Day 1 Meal:</label>	
							<select class="form-control input-sm" name="recipeId1" id="recipeId1">
									<option value="#" disabled selected="selected">Choose Meal Option</option>
									<option value="#" disabled>--------------------------</option>
									<option value="eatOut">Eat Out</option>
									<option value="leftovers">Leftovers</option>
									<option value="#" disabled>----- Your Recipes -----</option>
								<c:forEach items="${userRecipes}" var="recipe">
									<option value="${recipe.recipeId}">${recipe.recipeName}</option>	
								</c:forEach>
							</select>
					</div>
					
					<!-- COPIED OVER FROM RECIPES, NOT SURE IF APPLICABLE HERE -->
					<!-- <div class="col-md-2">
						<label>Add/Remove:</label>
						<div class="btn-group">
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>	
					</div> -->
					
				</div>
				
				<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Create Meal Plan</button>
			
			</form>
		</div>
		
		<!-- EMPTY SPACE: COULD BE USED TO WRITE UP INSTRUCTIONS, OR SHOW AWESOME PHOTO OF CHRIS'S WICKED TACOS-->
		<div class="col-md-4"></div>
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />