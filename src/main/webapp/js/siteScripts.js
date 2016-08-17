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