$(document).ready(function() {

$( function() {
    var availableIngredients = [
      "ActionScript",
      "AppleScript",
      "Asp",
      "BASIC",
      "C",
      "C++",
      "Clojure",
      "COBOL",
      "ColdFusion",
      "Erlang",
      "Fortran",
      "Groovy",
      "Haskell",
      "Java",
      "JavaScript",
      "Lisp",
      "Perl",
      "PHP",
      "Python",
      "Ruby",
      "Scala",
      "Scheme"
    ];
    $( "#addIngredientSearch" ).autocomplete({
      source: availableIngredients
    });
  } );


$("#addIngredientSearch2").autocomplete({
	source : function(request, response) {
	$.ajax("/addIngredientsToRecipe", {
		type : "GET",
		dataType : "json"
	}).success(function(result) {
		response(result)
		console.log("Hooray!");
	}).fail(logRequestFailure);
	}
});
	
function logRequestFailure(xhr, status, errorMessage) {
	console.log("BOO! Hiss!");
}
	



});