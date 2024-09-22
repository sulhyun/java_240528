<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark justify-content-between">	
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/"/>">HOME</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value="/post/list/0" />">커뮤니티</a>
			</li>
		</ul>
		<ul class="navbar-nav">
			<c:if test="${user eq null}">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/signup" />">회원가입</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/login" />">로그인</a>
				</li>
			</c:if>
			<c:if test="${user ne null}">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value="/logout"/>">로그아웃</a>
				</li>
			</c:if>
		</ul>
	</nav>
</body>
</html>