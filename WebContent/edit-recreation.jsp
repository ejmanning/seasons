<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Recreation</title>
</head>
<body>
	<form action="editRecreationServlet" method="post">
		Name: <input type="text" name= "recname" value="${recreationToEdit.recname}">
		<input type="hidden" name = "id" value = "${recreationToEdit.id}">
		<input type="submit" value="Save Edited Item">
	</form>
</body>
</html>