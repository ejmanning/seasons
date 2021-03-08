<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Season</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<form method="post" action="seasonNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allSeasons}" var="currentseason">
	<tr>
		<td><input type="radio" name="id" value="${currentseason.id}"></td>
		<td><h2>${currentseason.seasonname}</h2></td></tr>
		<tr><td colspan="3">Start Date: ${currentseason.seasonstartdate}</td></tr>
		<tr><td colspan="3">Recreations: <c:forEach var="recreations" items="${currentseason.recreations}">
			<tr><td></td><td colspan="3">
				${recreations.recname}
				</td>
			</tr>
		</c:forEach>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToSeason">
	</form>
	
	<a href="index.html">Insert a new recreation</a>
</body>
</html>