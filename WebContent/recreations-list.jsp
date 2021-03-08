<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recreations</title>
</head>
<body>
	<form method="post" action="recreationNavigationServlet">
	<table>
		<c:forEach items="${requestScope.allRecreations}" var="currentitem">
		<tr>
			<td><input type="radio" name="id" value="${currentitem.id}"></td>
			<td>${currentitem.recname}</td>
		</tr> 
		</c:forEach>
	</table>
	<input type = "submit" value="edit" name="doThisToRecreation">
	<input type = "submit" value="delete" name="doThisToRecreation">
	<input type = "submit" value="add" name="doThisToRecreation">
	</form>
</body>
</html>