<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Season</title>
</head>
<body>
	<form method="post" action="seasonNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allSeasons}" var="currentseason">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentseason.seasonname}</h2></td></tr>
		<tr><td colspan="3">Start Date: ${currentseason.seasonstartdate}</td></tr>
		<c:forEach var="recreations" items="${currentseason.recreations}">
			<tr><td></td><td colspan="3">
				${recreations.recname}
				</td>
			</tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToList">
	<input type="submit" value="delete" name="doThisToList">
	<input type="submit" value="add" name="doThisToList">
	</form>
	
	<a href="addRecreationForSeasonServlet">Add recreations for seasons</a>
	<a href="index.html">Insert a new recreation</a>
</body>
</html>