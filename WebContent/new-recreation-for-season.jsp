<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add recreations to season</title>
</head>
<body>
<form action ="" method="post">
Recreation Name: <input type = "text" name ="recname"><br />
Add to Season:<br />
<select name= "seasons" multiple size="4">
<c:forEach items="${requestScope.allSeasons}" var="currentseason">
<option value ="${currentseason.id}">${currentseason.seasonname}</option>
</c:forEach>
</select>
<br />
<input type = "submit" value= "Add Recreations to Season">
</form>
<a href ="index.html">Go add new recreations instead</a>
</body>
</html>