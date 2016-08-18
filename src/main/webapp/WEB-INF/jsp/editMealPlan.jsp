<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>Edit a Meal Plan</h2>
	<p>Use this form to edit your meal plan below.</p>
</div>

<c:url var="formAction" value="/users/${userName}/editMealPlan">
	<c:param name="mealPlanId" value="${param.mealPlanId}"/>
</c:url>

	<h3>Meal plan for the week of: <c:out value="${mealPlan.mealPlanStartDate}"/></h3>

	<!-- RECIPE FORM: 1 ROW / 8 COL -->
	<div class="row">
		<div class="col-md-8">
		
			<!-- FORM -->
			<form role="form" action="${formAction}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				
				<c:forEach items="${joinedRecipeRecords}" var="recipeRecord" varStatus="loops">
					
					<div class="col-md-6">
						<label id="mealPlanRecipeLabel" for="mealPlanDay${loops.count}"><c:out value="Day ${loops.count}: ${recipeRecord.mealDayOfWeek}, ${recipeRecord.mealDate}" /></label>
						<input id="mealDate" name="mealDate${loops.count}" value="${recipeRecord.mealDate}" type="hidden" />
						<input id="mealDayOfWeek" name="mealDayOfWeek${loops.count}" value="${recipeRecord.mealDayOfWeek}" type="hidden" />
					</div>
					
					<div class="col-md-6" id="mealPlanRecipeList">
						<select class="form-control input-sm recipeSelector" name="mealPlanDay${loops.count}">
								<option selected="selected" value="${recipeRecord.recipeId}"><c:out value="${recipeRecord.recipeName}"/></option>
								<option value="#" disabled>--------------------------</option>
								<option value="-1">Eat Out</option>
								<option value="0">Leftovers</option>
								<option value="#" disabled>----- Your Recipes -----</option>
							<c:forEach items="${recipes}" var="recipe">
								<option value="${recipe.recipeId}">${recipe.recipeName}</option>	
							</c:forEach>
						</select>
					</div>
				
				</c:forEach>
					
			</form>
		</div>
	</div>
<c:import url="/WEB-INF/jsp/footer.jsp" />