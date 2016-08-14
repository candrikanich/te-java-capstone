<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="pwValidationSrc" value="/js/passwordValidation.js" />
<script src="${pwValidationSrc}"></script>

<div class="page-header">
	<h2>Sign Up to Meal Planner 5000</h2>
	<p>The best way to plan meals</p>
</div>

<script type="text/javascript">
	$(document).ready(function () {
	
		$("form").validate({
			rules : {
				password : {
					required : true,
					minlength : 10,
					maxlength : 128,
					complexPassword : true,
					noMoreThan2Duplicates : true
				},
				userName : {
					required : true
				},
				confirmPassword : {
					required : true,		
					equalTo : "#password"  
				}
			},
			messages : {			
				confirmPassword : {
					equalTo : "Passwords do not match"
				}
			},
			errorClass : "error"
		});
		
	});
</script>

<c:url var="formAction" value="/users/new" />
<form method="POST" action="${formAction}">
	<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
	<div class="row">
		<div class="col-sm-6">	
			<div class="form-group">
				<label for="userName">User Name: </label>
				<input type="text" id="userName" name="userName" placeHolder="User Name" class="form-control" />
			</div>
			<div class="form-group">
				<label for="password">Password: </label>
				<input type="password" id="password" name="password" placeHolder="Password" class="form-control" />
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" placeHolder="Re-Type Password" class="form-control" />	
			</div>
			<button type="submit" class="btn btn-default">Create User</button>
		</div>
		<div class="col-sm-6">
			<strong>Password Rules:</strong>
			<ul>
				<li>Must be at least 10 characters long</li>
				<li>Must contain at least 3 of the following 4 types of characters:
					<ol>
						<li>Uppercase letter (A-Z)</li>
						<li>Lowercase letter (a-z)</li>
						<li>Number (0-9)</li>
						<li>A "special" character (#, $, space, etc)</li>
					</ol>
				</li>
				<li>No more than two identical characters in a row</li>
			</ul>
		</div>
	</div>
</form>
		
<c:import url="/WEB-INF/jsp/footer.jsp" />