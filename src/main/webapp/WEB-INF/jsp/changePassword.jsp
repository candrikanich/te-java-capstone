<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/header.jsp" />

<c:url var="pwValidationSrc" value="/js/passwordValidation.js" />
<script src="${pwValidationSrc}"></script>

<div class="page-header">
	<h2>Change your password</h2>
</div>

<script type="text/javascript">
	$(document).ready(function () {
	
		$("#changePasswordForm").validate({
			
			rules : {
				password : {
					required : true,
					minlength : 10,
					maxlength : 128,
					complexPassword : true,
					noMoreThan2Duplicates : true
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


<h2>Change Password</h2>

<c:url var="formAction" value="/users/${userName}/changePassword" />

<div class="row">
	<div class="col-md-5">
		<form action="${formAction}" method="POST" id="changePasswordForm">
			<input type="hidden" name="CSRF_TOKEN" value="${CSRF_TOKEN}" />
			<div class="form-group">
				<label for="password">New Password: </label>
				<input type="password" id="password" name="password" class="form-control" />	
			</div>
			<div class="form-group">
				<label for="confirmPassword">Confirm Password: </label>
				<input type="password" id="confirmPassword" name="confirmPassword" class="form-control" />	
			</div>
			<button type="submit" class="btn btn-default">Change Password</button>
		</form>
	</div>

	<div class="col-md-7"></div>
</div>

<c:import url="/WEB-INF/jsp/footer.jsp" />