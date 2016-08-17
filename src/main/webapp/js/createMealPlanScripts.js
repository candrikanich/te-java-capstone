$(document).ready(function (e) {

	var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September",
	                  "October", "November", "December"];
	var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	
	var selectedDate = $( "#mealPlanStartDate" ).datepicker({ 
			dateFormat: 'mm-dd-yy',
			onSelect: function() {
				var startDateDay = dayNames[$("#mealPlanStartDate").datepicker('getDate').getDay()];
				var startDateMonth = monthNames[$("#mealPlanStartDate").datepicker('getDate').getMonth()];
				var startDateDate = $("#mealPlanStartDate").datepicker('getDate').getDate();
				var startDateYear = $("#mealPlanStartDate").datepicker('getDate').getFullYear();
				var str_output = "<p><strong>Start Date Selected:</strong> " + startDateDay + ", " + startDateMonth + " " + startDateDate + ", " + startDateYear + "</p>";
				
				$('#mealContainer').append(str_output);
			}
	});
	
	$("#submitMealPlanStartDate").click(function() {
		var planDate = selectedDate; 
		
		for(var i = 0; i < 7; i++) {
			var mealPlanDay = i + 1;
			var startDateDay = dayNames[planDate.datepicker('getDate').getDay()];
			var startDateMonth = monthNames[planDate.datepicker('getDate').getMonth()];
			var startDateDate = planDate.datepicker('getDate').getDate();
			var startDateYear = planDate.datepicker('getDate').getFullYear();
			
			var mealDate =  startDateYear + "-" + planDate.datepicker('getDate').getMonth() + "-" + startDateDate;
			var str_output = "Meal #" + mealPlanDay + ": " + startDateDay + ", " + startDateMonth + " " + startDateDate + ", " + startDateYear;
			var forLabel = "mealPlanDay" + mealPlanDay;
			
			var clone = $(".mealContainer").clone(true, true);
			$(clone).find("#mealPlanRecipeLabel").attr("for", forLabel).text(str_output);
			
			var mealDateName = "mealDate" + mealPlanDay; 
			$(clone).find("#mealDate").attr({
				name: mealDateName,
				value: mealDate
			});
			
			var mealDayOfWeek = "mealDayOfWeek" + mealPlanDay;
			$(clone).find("#mealDayOfWeek").attr({
				name: mealDayOfWeek,
				value: startDateDay
			});
			
			$(clone).find(".recipeSelector").attr({
				name: forLabel,
				style: "display: inline;",
				id: "recipeSelector" + mealPlanDay	
			});
			$(clone).appendTo(".mealPlanRows").removeClass("mealContainer");
			
			
			
			
//			INCREMENTS DATE BY 1
			var newDate = new Date(planDate.datepicker('getDate'));
			newDate.setDate(newDate.getDate()+1);
			planDate.datepicker('setDate', newDate);
		}
	});
});
