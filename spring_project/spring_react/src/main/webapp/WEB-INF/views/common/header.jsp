<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-info navbar-dark">
		<!-- Brand/logo -->
		<a class="navbar-brand" href="<c:url value="/" />">Logo</a>
		
		<!-- Links -->
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/guest/signup" />">회원가입</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">로그인</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">로그아웃</a>
			</li>
		</ul>
	</nav>
</body>
</html>