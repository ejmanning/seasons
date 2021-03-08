<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Season</title>
</head>
<body>
	<form action = "editSeasonServlet" method= "post">
	<input type = "hidden" name ="id" value="${seasonToEdit.id}">
	Season: <input type = "text" name ="listName" value="${seasonToEdit.seasonname}"><br />
	
	Start date: <input type ="text" name ="month" placeholder="mm" size="4" value="${month}"> <input type ="text" name ="day" placeholder="dd" size="4" value="${date}">, <input type ="text" name="year" placeholder="yyyy" size="4" value="${year}">
	
	Available Recreations:<br />
	
	<select name="allRecreationsToAdd"multiple size="6">
	<c:forEach items="${requestScope.allRecreations}" var="currentrecreation">
		<option value ="${currentrecreation.id}">${currentrecreation.recname}</option>
	</c:forEach>
	</select>
<br />
<input type = "submit" value="Edit Season and Add Recreations">
</form>
<a href = "index.html">Go add new recreations instead.</a>
</body>
</html>