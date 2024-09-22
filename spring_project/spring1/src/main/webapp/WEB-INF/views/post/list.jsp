<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h1>커뮤니티 목록</h1>
	<div class="mt-3 mb-3">
		<c:forEach items="${communityList}" var="community">
			<a href="<c:url value="/post/list/${community.co_num}" />" class="btn btn-outline-dark">${community.co_name}</a>
		</c:forEach>
	</div>
	<c:if test="${pm.cri.co_num ne 0}">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>추천수</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${postList}" var="post">
					<tr>
						<td>${post.po_num}</td>
						<td>
							<a href="<c:url value="/post/detail/${post.po_num}"/>">${post.po_title}</a>
						</td>
						<td>${post.po_me_id}</td>
						<td><fmt:formatDate value="${post.po_date}" pattern="yyyy-MM-dd"/></td>
						<td>0</td>
						<td>${post.po_view}</td>
					</tr>
				</c:forEach>
				<c:if test="${postList.size() == 0}">
					<tr>
						<td colspan="6" class="text-center"><b>등록된 게시글이 없습니다.</b></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
			<c:if test="${pm.prev}">
				<c:url value="/post/list/${pm.cri.co_num}" var="url">
					<c:param name="page" value="${pm.startPage - 1}" />
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">이전</a>
				</li>
			</c:if>
			<c:forEach begin="${pm.startPage}" end="${pm.endPage}" var="i">
				<c:url value="/post/list/${pm.cri.co_num}" var="url">
					<c:param name="page" value="${i}" />
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">${i}</a>
				</li>
			</c:forEach>
			<c:if test="${pm.next}">
				<c:url value="/post/list/${pm.cri.co_num}" var="url">
					<c:param name="page" value="${pm.endPage + 1}" />
				</c:url>
				<li class="page-item">
					<a class="page-link" href="${url}">다음</a>
				</li>
			</c:if>
		</ul>
		<a href="<c:url value="/post//insert/${pm.cri.co_num}" />" class="btn btn-outline-dark post-insert">글등록</a>
	</c:if>
	<script type="text/javascript">
		$('.post-insert').on('click', function(e){
			if('${user.me_id}' != ''){
				return;
			}
			e.preventDefault();
			if(confirm('로그인이 필요한 서비스입니다.\n로그인 페이지로 이동하겠습니까?')){
				location.href = "<c:url value="/login" />";
			}
		})
	</script>
</body>
</html>
