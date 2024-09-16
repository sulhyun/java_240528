<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
</head>
<body>
	<h1>게시글 등록</h1>
	<form action="<c:url value="/post/insert/${co_num}" />" method="post">
		<div class="form-group">
			<label for="po_title">제목:</label>
			<input type="text" class="form-control" id="po_title" name="po_title">
		</div>
		<div class="form-group">
			<label for="po_content">내용:</label>
			<textarea class="form-control" id="po_content" name="po_content" style="min-height: 400px; height: auto;"></textarea>
		</div>
		<button type="submit" class="btn btn-outline-dark col-12">등록</button>
	</form>
	<script type="text/javascript">
	 	$('#po_content').summernote({
			placeholder: '내용을 작성하세요',
			tabsize: 2,
			height: 400
		})
	</script>
</body>
</html>
