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
	
	$(".btn-add").click(function(){
		$(".recipeIngredientRow").clone().appendTo(".groupRows").addClass(function(i) { return 'ingredient' + (i + 1) }).removeClass("recipeIngredientRow");
	});
	
	$(".btn-remove").click(function(){
		$(this).remove(".rowRemove");
	});
			
});