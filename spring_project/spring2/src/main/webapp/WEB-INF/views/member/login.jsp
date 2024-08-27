<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form action="<c:url value="/login"/>" method="post" id="form" class="mb-3">
	<div class="form-group" style="margin-top: 20px;">
		<label for="id">아이디:</label>
		<input type="text" class="form-control" id="id" name="me_id">
	</div>
	<div class="form-group">
		<label for="pw">비번:</label>
		<input type="password" class="form-control" id="pw" name="me_pw">
	</div>
	<button type="submit" class="btn btn-outline-dark col-12">로그인</button>
</form>
</body>
</html>