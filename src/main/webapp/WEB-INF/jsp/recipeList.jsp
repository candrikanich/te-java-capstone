<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<c:import url="/WEB-INF/jsp/header.jsp" />
  <h1> ${param.username}'s Recipes</h1>
  
  <ol class="user_recipe_list">
  	<c:forEach items="${recipes}" var="recipe">
  		<div class="recipe">
  			<h3>
  				<c:out value="${recipe.recipeName}"/>
  			</h3>
  		</div>
  	</c:forEach>
  </ol>
 
 
 
<c:import url="/WEB-INF/jsp/footer.jsp" />