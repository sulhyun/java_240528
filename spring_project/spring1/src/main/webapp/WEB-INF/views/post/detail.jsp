<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>게시글 상세</h1>
	<div>
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title" readonly value="${post.po_title}">
		</div>
		<div class="form-group">
			<label>작성자:</label>
			<input type="text" class="form-control" readonly value="${post.po_me_id}">
		</div>
		<div class="form-group">
			<label>작성일:</label>
			<input type="text" class="form-control" readonly value="<fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd hh:mm:ss" />">
		</div>
		<div class="form-group">
			<label>조회수:</label>
			<input type="text" class="form-control" readonly value="${post.po_view}">
		</div>
		<div class="form-group">
			<label for="po_content">내용:</label>
			<div class="form-control" id="po_content" style="min-height: 400px; height: auto;">${post.po_content}</div>
		</div>
	</div>
	<a href="<c:url value="/post/list/${post.po_co_num}" />" class="btn btn-outline-dark">게시글 목록</a>
	<c:if test="${user.me_id eq post.po_me_id}">
		<a href="<c:url value="/post/update/${post.po_num}" />" class="btn btn-outline-dark">게시글 수정</a>
		<a href="<c:url value="/post/delete/${post.po_co_num}/${post.po_num}" />" class="btn btn-outline-dark">게시글 삭제</a>
	</c:if>
	<hr>
	<div class="comment-container">
		<ul class="comment-list" style="list-style: none; padding:0">
			<li class="comment-item">
				<div class="clearfix">
					<span class="float-left" style="line-height: 38px">아이디</span>
					<div class="float-right">
						<button class="btn btn-outline-dark">수정</button>
						<button class="btn btn-outline-dark">삭제</button>
					</div>
				</div>
				<div style="padding-left: 20px; line-height: 38px;">댓글내용</div>
			</li>
		</ul>
		<div class="comment-pagination">
			<ul class="pagination justify-content-center">
				<li class="page-item">
					<a class="page-link" href="javascript:void(0);">Previous</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="javascript:void(0);">1</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="javascript:void(0);">Next</a>
				</li>
			</ul>
		</div>
		<div class="comment-input-box">
			<div class="input-group mb-3">
				<textarea class="form-control" placeholder="댓글 입력" id="input-comment"></textarea>
				<div class="input-group-append">
					<span class="input-group-text btn-insert">등록</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>