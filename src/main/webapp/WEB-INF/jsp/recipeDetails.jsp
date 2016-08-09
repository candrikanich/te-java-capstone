<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />
 	<h3>
 		<c:out value="${recipe.recipeName}"/>
 	</h3>
 	<ol>
 	<c:forEach items="${ingredients}" var="ingredient">
 		<li>
 			<c:out value="${ingredient.ingredientName}"/>
 		</li>
 		
 	</c:forEach>
 	</ol>
 	<p><c:out value="${recipe.instructions}"/> </p>
 	
 	
 	
<c:import url="/WEB-INF/jsp/footer.jsp" />