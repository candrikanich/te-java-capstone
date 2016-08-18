<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>Add a Recipe</h2>
	<p>Use this form to add recipes to your library for meal planning.</p>
</div>

<c:url var="formAction" value="/users/${userName}/editRecipe">
	<c:param name="recipeId" value="${param.recipeId }"/>
</c:url>

	<!-- RECIPE FORM: 1 ROW / 8 COL -->
	<div class="row">
		<div class="col-md-8">
		
			<!-- FORM -->
			<form role="form" action="${formAction}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				
				<div class="row">
					<div class="form-group form-group col-md-10">
						<label for="recipeName">Recipe Name: </label>
						<input type="text" id="recipeName" name="recipeName" class="form-control" value="${recipe.recipeName}" />	
					</div>
					<div class="col-md-2">
						<label>+ Ingredient:</label>
						<button type="button" class="btn btn-default btn-block btn-edit-add"><span class="glyphicon glyphicon-plus-sign"></span></button>	
					</div>
				</div>
				
				<div class="recipeIngredientList">
				
					<c:forEach items="${recipeIngredients}" var="recipeIngredient" varStatus="loops">
						<div class="col-md-5">
							<label for="ingredient">Ingredient </label>	
							<select class="form-control input-sm" name="ingredientId${loops.index}" id="ingredient">
								<option value="${recipeIngredient.ingredientId}">
									<c:out value="${recipeIngredient.ingredientName}"/>
								</option>
								<option value="0">---Delete ingredient---</option>
								<c:forEach items="${allIngredients}" var="ingredient">
									<option id="addIngredient" value="${ingredient.ingredientId}">
										<c:out value="${ingredient.ingredientName}"/>
									</option>	
								</c:forEach>
							</select>
						</div>
							
						<div class="col-md-3">
							<label for="quantity">Quantity: </label>
							<select class="form-control input-sm" name="quantityId${loops.index}" id="quantity">	
								<option value="${recipeIngredient.quantityId}"><c:out value="${recipeIngredient.quantityName }"/></option>
								<c:forEach items="${allQuantities}" var="quantity">
									<option value="${quantity.quantityId}"><c:out value="${quantity.quantityName}"/></option>
								</c:forEach>
							</select>
						</div>
							
						<div class="col-md-3">
							<label for="unit">Unit:</label>
							<select class="form-control input-sm" name="unitId${loops.index}" id="unit">
								<option value="${recipeIngredient.unitId}"><c:out value="${recipeIngredient.unitName}"/></option>
								<c:forEach items="${allUnits}" var="unit">
									<option value="${unit.unitId}"><c:out value="${unit.unitName}"/></option>
								</c:forEach>
							</select>
						</div>
							
						<div class="col-md-1">
							<label>&nbsp;</label>
							<button type="button" style="display: none" class="btn btn-default btn-remove"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>
					</c:forEach>
					
				</div>
				<div class="groupRows">
			
					<!-- INGREDIENT ROW -->
					<c:set var="count" value="${fn:length(recipeIngredients) }" scope="page"/>
					<input type="hidden" id="counter" value="${count }">
					<div class="form-group row recipeIngredientRow">
					<div id="hidden" style="display: none">
						<div class="col-md-5">
							<label for="ingredient">Ingredient </label>	
							<select class="form-control input-sm" name="ingredientId${count}" id="ingredient">
									<option value="0">Choose an ingredient</option>
								<c:forEach items="${allIngredients}" var="ingredient">
									<option id="addIngredient" value="${ingredient.ingredientId}">
										<c:out value="${ingredient.ingredientName}"/>
									</option>	
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-3">
							<label for="quantity">Quantity: </label>
							<select class="form-control input-sm" name="quantityId${count}" id="quantity">	
								<option value="0">Choose...</option>
								<c:forEach items="${allQuantities}" var="quantity">
									<option value="${quantity.quantityId}">${quantity.quantityName}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-3">
							<label for="unit">Unit:</label>
							<select class="form-control input-sm" name="unitId${count}" id="unit">
								<option value="0">Choose...</option>
								<c:forEach items="${allUnits}" var="unit">
									<option value="${unit.unitId}"><c:out value="${unit.unitName}"/></option>
								</c:forEach>
							</select>
						</div>
						
						<div class="col-md-1">
							<label>&nbsp;</label>
							<button type="button" style="display: inline" class="btn btn-default btn-edit-remove"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>
						
					</div>
					</div>
					<!-- End Ingredient Row -->
				
				</div>
				<!-- End GroupRow -->
				
				<div class="form-group form-group-lg">
					<label for="instructions">Instructions: </label>
					<textarea id="instructions" name="instructions" class="form-control" rows="5">
						<c:out value="${recipe.instructions}"/>
					</textarea>	
				</div>
				
				<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Submit Recipe Update</button>
			</form>
		</div>
		
		<!-- 
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<form action="###" method="GET">
				<label for="addIngredientSearch">[test] Search Autocomplete Proof of Concept:</label>
				<input type="text" name="addIngredientSearch" id="addIngredientSearch" class="form-control" />
				<span class="help-block">You should be able to use this field to search for an ingredient to add to the recipe.</span>
			</form>
			<div class="search-container">
        		<div class="ui-widget">
        			<label for="addIngredientSearch2">[test] Search Autocomplete from Ingredients:</label>
					<input type="text" id="addIngredientSearch2" name="addIngredientSearch2" class="form-control" />
        		</div>
			</div>

		</div> -->
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />