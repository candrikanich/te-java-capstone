$(document).ready(function (e) {

	var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September",
	                  "October", "November", "December"];
	var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	
	$("#mealPlanStartDate").blur(function() {
		var startDate = new Date($("#mealPlanStartDate").val());
		
		for(var i = 0; i < 7; i++) {
			var startDateMonth = monthNames[startDate.getMonth()];
			var startDateYear = startDate.getFullYear();
			var startDateDay = startDate.getDay();
			var startDateDayString = dayNames[startDate.getDay()];
			var startDateDate = startDate.getDate() + 1;
			
			$('<p/>').text(startDateDayString + ", " + startDateMonth + " " + startDateDate + ", " + 
					startDateYear).appendTo($("#mealContainer"));
			startDate.setDate(startDate.getDate() + 1);
		}
	});
	
});
