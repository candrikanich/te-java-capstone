<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />

<div class="page-header">
	<h2>Welcome to Meal Planner 5000</h2>
	<p>The best way to plan meals</p>
</div>
 
 	<c:url var="newUserHref" value="/users/new" />
	<a href="${newUserHref}">
		<button type="submit" class="btn btn-lg">Start Meal Planning Today</button>
	</a>
 
<c:import url="/WEB-INF/jsp/footer.jsp" />