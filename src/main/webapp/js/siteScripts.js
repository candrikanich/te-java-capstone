$(document).ready(function (e) {

//	LOGOUT SCRIPT
	
	$("#logoutLink").click(function(event){
		$("#logoutForm").submit();
	});
			
//	MENU ACTIVE STATUS CHANGE
	
	$("#btn-home").click(home);
	$("#btn-myRecipes").click(myRecipes);
	$("#btn-myMealPlan").click(myMealPlan);
	$("#btn-groceryList").click(groceryList);
	
	function home() {
		removeActive();
		$("li.home").addClass("active");
	};
	
	function myRecipes() {
		removeActive();
		$("li.myRecipes").addClass("active");
	};
	
	function myMealPlan() {
		removeActive();
		$("li.myMealPlan").addClass("active");
	};
	
	function groceryList() {
		removeActive();
		$("li.groceryList").addClass("active");
	};
	
	function removeActive() {
		$("li.active").removeClass();
	}
	
	function checkRowCount() {
		if ($(rowCount) < 2 ) {
			$("btn-remove").hide();
		} 
	};
//	DYNAMICALLY ADD NEW INGREDIENT OPTIONS
	
	var num = 1;
	
	
	$(".btn-add").click(function(){
		var rowCount = num;
		
//		$(".groupRows").append(
//				'<div class="form-group row rowNum'+rowCount+'">'
//						+'<div class="col-md-5">'
//							+'<label for="ingredient">Ingredient </label>'	
//							+'<select class="form-control input-sm" name="ingredientId'+rowCount+'" id="ingredient">'
//									+'<option value="#">Choose an ingredient</option>'
//								+'<c:forEach items="${allIngredients}" var="ingredient">'
//									+'<option value="${ingredient.ingredientId}">${ingredient.ingredientName}</option>'	
//								+'</c:forEach>'
//							+'</select>'
//						+'</div>'
//						
//						+'<div class="col-md-3">'
//							+'<label for="quantity">Quantity: </label>'
//							+'<select class="form-control input-sm" name="quantityId'+rowCount+'" id="quantity">'	
//								+'<option value="#">Choose...</option>'
//								+'<c:forEach items="${allQuantities}" var="quantity">'
//									+'<option value="${quantity.quantityId}">${quantity.quantityName}</option>'
//								+'</c:forEach>'
//							+'</select>'
//						+'</div>'
//						
//						+'<div class="col-md-3">'
//							+'<label for="unit">Unit:</label>'
//							+'<select class="form-control input-sm" name="unitId'+rowCount+'" id="unit">'
//								+'<option value="#">Choose...</option>'
//								+'<c:forEach items="${allUnits}" var="unit">'
//									+'<option value="${unit.unitId}">${unit.unitName}</option>'
//								+'</c:forEach>'
//							+'</select>'
//						+'</div>'
//						
//						+'<div class="col-md-1">'
//							+'<label>&nbsp;</label>'
//							+'<button type="button" name="btn'+rowCount+'" style="display: inline" id="remove-button" class="btn btn-default btn-remove rowNum"'+rowCount+'><span class="glyphicon glyphicon-minus-sign"></span></button>'
//						+'</div>'
//						
//					+'</div>');
//		$(".recipeIngredientRow").clone(true, true).appendTo(".groupRows").removeClass("recipeIngredientRow").addClass(function() {return 'rowNum' + rowCount});
//		$("#ingredient").attr("name", function() {return 'ingredientId' + rowCount});
//		$("#quantity").attr("name", function() {return 'quantityId' + rowCount});
//		$("#unit").attr("name", function() {return 'unitId' + rowCount});
//		$(".btn-remove").addClass(function() {return 'btnNum' + rowCount});
//		$(".btnNum"+rowCount).attr("style", function() {return 'display: inline'});
//		$(".rowNum"+rowCount).attr('rowId', function() {return rowCount});
//		num = num + 1;
		
		
		var clone = $(".recipeIngredientRow").clone(true, true);
		$(clone).find("#ingredient").attr("name", function() {return 'ingredientId' + rowCount});
		$(clone).find("#quantity").attr("name", function() {return 'quantityId' + rowCount});
		$(clone).find("#unit").attr("name", function() {return 'unitId' + rowCount});
		$(clone).find(".btn-remove").addClass(function() {return 'btnNum' + rowCount});
		$(clone).find(".btnNum"+rowCount).attr("style", function() {return 'display: inline'});
		$(clone).find(".rowNum"+rowCount).attr('rowId', function() {return rowCount});
		$(clone).appendTo(".groupRows").removeClass("recipeIngredientRow").addClass(function() {return 'rowNum' + rowCount});
		num = num + 1;
	});
	
	$(".btn-remove").click(function(){
		$(this).parent().parent().remove();
	});
			
});