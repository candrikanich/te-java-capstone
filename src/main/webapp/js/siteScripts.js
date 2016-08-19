$(document).ready(function (e) {

//	LOGOUT SCRIPT
	
	$("#logoutLink").click(function(event){
		$("#logoutForm").submit();
	});
			
//	MENU ACTIVE STATUS CHANGE
	
	$("#btn-home").click(activeHome);
	$("#btn-myRecipes").click(activeMyRecipes);
	$("#btn-myMealPlan").click(activeMyMealPlan);
	$("#btn-groceryList").click(activeGroceryList);
	
	function activeHome() {
		removeActive();
		$("li.home").addClass("active");
	};
	
	function activeMyRecipes() {
		removeActive();
		$("li.myRecipes").addClass("active");
	};
	
	function activeMyMealPlan() {
		removeActive();
		$("li.myMealPlan").addClass("active");
	};
	
	function activeGroceryList() {
		removeActive();
		$("li.groceryList").addClass("active");
	};
	
	function removeActive() {
		$("li.active").removeClass("active");
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
	
	//	DYNAMICALLY ADD NEW INGREDIENT OPTIONS for edit recipe JSP
	
	var numRecipeEdit = 0;
	var checkElementExists = document.getElementById("counter")
	if(checkElementExists != null) {
		numRecipeEdit = parseInt(document.getElementById("counter").value) + 1;
	}
	
	$(".btn-edit-add").click(function(){
		var rowCount = numRecipeEdit;
		
		var clone = $(".recipeIngredientRow").clone(true, true);
		$(clone).find("#hidden").show();
		$(clone).find("#ingredient").attr("name", function() {return 'ingredientId' + rowCount});
		$(clone).find("#quantity").attr("name", function() {return 'quantityId' + rowCount});
		$(clone).find("#unit").attr("name", function() {return 'unitId' + rowCount});
		$(clone).find(".btn-remove").addClass(function() {return 'btnNum' + rowCount});
		$(clone).find(".btnNum"+rowCount).attr("style", function() {return 'display: inline'});
		$(clone).find(".rowNum"+rowCount).attr('rowId', function() {return rowCount});
		$(clone).appendTo(".groupRows").removeClass("recipeIngredientRow").addClass(function() {return 'rowNum' + rowCount});
		num = num + 1;
	});
	
	$(".btn-edit-remove").click(function(){
		$(this).parent().parent().parent().remove();
	});
	
	$("#hidden").hide();
	
			
});