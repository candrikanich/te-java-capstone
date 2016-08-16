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


// from Tic-Tac_Toe
//$(function listOfIngredients() {
//	$.ajax("addiIngredientsToRecipe", {
//		type : "GET",
//		dataType : "json"
//	}).success(function(result) {
//		response(result) // what to do with success??
//	}).fail(logRequestFailure);	
//	
//	$( "#addIngredientSearch" ).autocomplete({
//	      source: listOfIngredients
//	});
//	
//});

	
// From the inter-webs
//$(document).ready(function() {
//    $(function() {
//            $("#addIngredientSearch").autocomplete({     
//            source : function(request, response) {
//            $.ajax({
//                    url : "ingredients",
//                    type : "GET",
//                    data : {
//                            ingredientName : ingredientName,
//                            ingredientId : ingredientId
//                    },
//                    dataType : "json",
//                        success : function(data) {
//                                response(data);
//                        }
//                });
//        }
//});
//});
//});	

//$( "#addIngredientSearch" ).autocomplete({
//      source: listOfIngredients
//    });
	