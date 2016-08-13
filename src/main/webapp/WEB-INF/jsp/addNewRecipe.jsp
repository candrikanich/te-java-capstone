<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>Add a Recipe</h2>
	<p>Use this form to add recipes to your library for meal planning.</p>
</div>

<c:url var="formAction" value="/users/${userName}/addNewRecipe">
	<c:param name="userId" value="${param.userId}" />
</c:url>

	<div class="row">
		<div class="col-md-8">
		
			<form role="form" action="${formAction}" method="POST">
				<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
				
				<div class="form-group form-group-lg">
					<label for="recipeName">Recipe Name: </label>
					<input type="text" id="recipeName" name="recipeName" class="form-control" />	
				</div>
				
				<div class="form-group row">
				
					<div class="col-md-4">
						<label for="ingredient">Ingredient #1: </label>	
						<select class="form-control input-sm" name="ingredientId1" id="ingredient">
								<option value="#">Choose an ingredient</option>
							<c:forEach items="${allIngredients}" var="ingredient">
								<option value="${ingredient.ingredientId}">${ingredient.ingredientName}</option>	
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-3">
						<label for="quantity">Quantity: </label>
						<select class="form-control input-sm" name="quantityId1" id="quantity">	
							<option value="#">Choose...</option>
							<c:forEach items="${allQuantities}" var="quantity">
								<option value="${quantity.quantityId}">${quantity.quantityName}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-3">
						<label for="unit">Unit:</label>
						<select class="form-control input-sm" name="unitId1" id="unit">
							<option value="#">Choose...</option>
							<c:forEach items="${allUnits}" var="unit">
								<option value="${unit.unitId}">${unit.unitName}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-2">
						<label>Add/Remove:</label>
						<div class="btn-group">
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>	
					</div>
					
				</div>
				
				<div class="form-group row">
				
					<div class="col-md-4">
						<label for="ingredient">Ingredient #2: </label>
						<select class="form-control input-sm" name="ingredientId2" id="ingredient">
							<option value="#">Choose an ingredient</option>
							<c:forEach items="${allIngredients}" var="ingredient">
								<option value="${ingredient.ingredientId}">${ingredient.ingredientName}</option>	
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-3">
						<label for="quantity">Quantity: </label>
						<select class="form-control input-sm" name="quantityId2" id="quantity">	
							<option value="#">Choose...</option>
							<c:forEach items="${allQuantities}" var="quantity">
								<option value="${quantity.quantityId}">${quantity.quantityName}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-3">
						<label for="unit">Unit: </label>
						<select class="form-control input-sm" name="unitId2" id="unit">
							<option value="">Choose...</option>
							<c:forEach items="${allUnits}" var="unit">
								<option value="${unit.unitId}">${unit.unitName}</option>
							</c:forEach>
						</select>
					</div>
					
					<div class="col-md-2">
						<label>Add/Remove:</label>
						<div class="btn-group">
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign"></span></button>
						<button type="button" class="btn btn-default"><span class="glyphicon glyphicon-minus-sign"></span></button>
						</div>	
					</div>
		
					
				</div>
				<div class="form-group form-group-lg">
					<label for="instructions">Instructions: </label>
					<textarea id="instructions" name="instructions" class="form-control"></textarea>	
				</div>
				<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-plus-sign">&nbsp;</span>Add Recipe</button>
			</form>
		</div>
		
		<!-- TESTING SEARCH TO ADD INGREDIENT -->
		<div class="col-md-1"></div>
		<div class="col-md-2">
			<form action="###" method="GET">
				<label for="addIngredient">[test] Search to Add an Ingredient:</label>
				<input type="text" name="addIngredient" id="addIngredient" class="form-control" />
				<span class="help-block">You should be able to use this field to search for an ingredient to add to the recipe.</span>
			</form>
		</div>
		<div class="col-md-1"></div>
	</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />