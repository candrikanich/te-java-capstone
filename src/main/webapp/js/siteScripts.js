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
	
//	DYNAMICALLY ADD NEW INGREDIENT OPTIONS
	
	var num = 1;
	
	$(".btn-add").click(function(){
		var rowCount = num;
		$(".recipeIngredientRow").clone().appendTo(".groupRows").removeClass("recipeIngredientRow").addClass(function() {return 'rowNum' + rowCount});
		$("#ingredient").attr("name", function() {return 'ingredientId' + rowCount});
		$("#quantity").attr("name", function() {return 'quantityId' + rowCount});
		$("#unit").attr("name", function() {return 'unitId' + rowCount});
		$(".btn-remove").addClass(function() {return 'rowNum' + rowCount});
		num = num + 1;
	});
	
	$(".btn-remove").click(function(){
		$(".rowNum").remove();
	});
			
});