$(document).ready(function (e) {

	var monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September",
	                  "October", "November", "December"];
	var dayNames = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"];
	
//	$("#submitMealPlanStartDate").click(function() {
//		var startDate = new Date($("#mealPlanStartDate").val());
//		
//		for(var i = 0; i < 7; i++) {
//			var startDateMonth = monthNames[startDate.getMonth()];
//			var startDateYear = startDate.getFullYear();
//			var startDateDay = startDate.getDay();
//			var startDateDayString = dayNames[startDate.getDay()];
//			var startDateDate = startDate.getDate() + 1;
//			
//			$('<p/>').text(startDateDayString + ", " + startDateMonth + " " + startDateDate + ", " + 
//					startDateYear).appendTo($("#mealContainer"));
//			startDate.setDate(startDate.getDate() + 1);
//		}
//	});
	
		
//	    $( "#mealPlanStartDate" ).datepicker(function() {
//	    	
//	    	var startDate = new Date($("#mealPlanStartDate").val());
//	    	var parsedDate = new Date ($.datepicker.parseDate("mm-dd-yyyy", startDate));
//	    	
//			for(var i = 0; i < 7; i++) {
//				var startDateMonth = monthNames[parsedDate.getMonth()];
//				var startDateYear = parsedDate.getFullYear();
//				var startDateDay = parsedDate.getDay();
//				var startDateDayString = dayNames[parsedDate.getDay()];
//				var startDateDate = parsedDate.getDate() + 1;
//				
//				$('<p/>').text(startDateDayString + ", " + startDateMonth + " " + startDateDate + ", " + 
//						startDateYear).appendTo($("#mealContainer"));
//				startDate.setDate(startDate.getDate() + 1);
//			}
//	    	console.log("WTF! Yippee!");
//	  } );
	
	var selectedDate = $( "#mealPlanStartDate" ).datepicker({ 
			dateFormat: 'mm-dd-yy',
			onSelect: function() {
				var startDateDay = dayNames[$("#mealPlanStartDate").datepicker('getDate').getDay()];
				var startDateMonth = monthNames[$("#mealPlanStartDate").datepicker('getDate').getMonth()];
				var startDateDate = $("#mealPlanStartDate").datepicker('getDate').getDate();
				var startDateYear = $("#mealPlanStartDate").datepicker('getDate').getFullYear();
				var str_output = "<p><strong>Start Date Selected:</strong> " + startDateDay + ", " + startDateMonth + " " + startDateDate + ", " + startDateYear + "</p>";
				$('#mealContainer').html(str_output);
			}
	});
	
	$("#submitMealPlanStartDate").click(function() {
		
		var planDate = selectedDate; 
		
		for(var i = 0; i < 7; i++) {
			var startDateDay = dayNames[planDate.datepicker('getDate').getDay()];
			var startDateMonth = monthNames[planDate.datepicker('getDate').getMonth()];
			var startDateDate = planDate.datepicker('getDate').getDate();
			var startDateYear = planDate.datepicker('getDate').getFullYear();
			var str_output = "Meal #" + (i + 1) + ": " + startDateDay + ", " + startDateMonth + " " + startDateDate + ", " + startDateYear;
			
			$('<p/>').text(str_output).appendTo($("#mealContainer"));
			
//			INCREMENTS DATE BY 1
			var newDate = new Date(planDate.datepicker('getDate'));
			newDate.setDate(newDate.getDate()+1);
			planDate.datepicker('setDate', newDate);
			
//			DOES NOT INCREMENT ORIGINAL DATE
//			var origDate = new Date(planDate.datepicker('getDate'));
//			origDate.setDate(origDate.getDate());
//			planDate.datepicker('setDate', origDate);
			
//			var dt = $.datepicker.parseDate('mm-dd-yy', planDate);
//			dt.setDate(dt.getDate() + 1)
//			var dtNew = $.datepicker.formatDate('mm-dd-yy', dt);
			
			// var parsedPlanDate = new Date(Date.parse(planDate));
			// parsedPlanDate = planDate.setDate(planDate.getDate() + 1);
			// after click, disable click action
		}
	});
	
});
