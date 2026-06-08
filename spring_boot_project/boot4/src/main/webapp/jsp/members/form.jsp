<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
	<form action="/jsp/members/save.jsp" method="post">
		<label for="username">username: </label>
		<input type="text" name="username" id="username" />
		<label for="age">age: </label>
		<input type="text" name="age"  id="age" />
		<button type="submit">전송</button>
	</form>
</body>
</html>