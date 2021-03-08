<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recreations</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<form method="post" action="recreationNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allRecreations}" var="currentrecreation">
		<tr>
			<td><input type="radio" name="id" value="${currentrecreation.id}"></td>
			<td>${currentrecreation.recname}</td>
		</tr> 
		</c:forEach>
	</table>
	<input type = "submit" value="edit" name="doThisToRecreation">
	<input type = "submit" value="delete" name="doThisToRecreation">
	<input type = "submit" value="add" name="doThisToRecreation">
	</form>
</body>
</html>