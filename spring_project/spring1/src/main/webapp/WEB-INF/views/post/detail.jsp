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
	<a href="<c:url value="/post/list/${post.po_co_num}" />" class="btn btn-outline-dark">목록</a>
	<c:if test="${user.me_id eq post.po_me_id}">
		<a href="<c:url value="/post/update/${post.po_num}" />" class="btn btn-outline-dark">수정</a>
		<a href="<c:url value="/post/delete/${post.po_co_num}/${post.po_num}" />" class="btn btn-outline-dark">삭제</a>
	</c:if>
	<hr>
	<div class="comment-container">
		<ul class="comment-list" style="list-style: none; padding:0">
			<li class="comment-item">
				<div class="clearfix">
					<div class="float-right">
						<button class="btn btn-outline-dark comment-update">수정</button>
						<button class="btn btn-outline-dark comment-delete">삭제</button>
					</div>
					<span class="float-left" style="line-height: 38px">아이디</span>
				</div>
				<div class="comment-content" style="padding-left: 20px; line-height: 38px;">댓글내용</div>
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
					<span class="input-group-text btn-insert" style="cursor:pointer;">등록</span>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		let cri = {
			page : 1,
			search : '${post.po_num}'
		}
		
		function getCommentList(cri){
			$.ajax({
				async : true,
				url : '<c:url value="/comment/list" />', 
				type : 'post', 
				data : JSON.stringify(cri), 
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function (data){
					displayCommentList(data.list);
					displayPagination(data.pm);
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR);
				}
			});
		}
		
		function displayCommentList(list){
			if(list == null || list.length == 0){
				$('.comment-list').html('<li class="comment-item text-center"><b>등록된 댓글이 없습니다.</b></li>');
				$('.comment-pagination').hide();
				return;
			}
			let str = '';
			for(comment of list){
				let btns = '';
				if(comment.cm_me_id == '${user.me_id}'){
					btns = `
						<div class="float-right">
							<button class="btn btn-outline-dark comment-update" data-num=\${comment.cm_num}>수정</button>
							<button class="btn btn-outline-dark comment-delete" data-num=\${comment.cm_num}>삭제</button>
						</div>
					`;
				}
				str += `
					<li class="comment-item">
						<div class="clearfix">
							<span class="float-left" style="line-height: 38px">\${comment.cm_me_id}</span>
							\${btns}
						</div>
						<div class="comment-content" style="padding-left: 20px; line-height: 38px;">\${comment.cm_content}</div>
					</li>
				`;
			}
			$('.comment-list').html(str);
		} // 댓글 및 대댓글 html 코드 추가
		
		function displayPagination(pm){
			if(pm == null || pm.endPage == 0){
				return;
			}
			let str = '';
			if(pm.prev){
				str += `
					<li class="page-item" data-page="\${pm.startPage-1}">
						<a class="page-link" href="javascript:void(0);">이전</a>
					</li>
				`;
			}
			for(var i = pm.startPage; i <= pm.endPage; i++){
				str += `
					<li class="page-item" data-page="\${i}">
						<a class="page-link" href="javascript:void(0);">\${i}</a>
					</li>
				`;			
			}
			if(pm.next){
				str += `
					<li class="page-item" data-page="\${pm.endPage+1}">
						<a class="page-link" href="javascript:void(0);">다음</a>
					</li>
				`;
			}
			$('.comment-pagination>.pagination').html(str);
		} // 댓글 페이지 네이션 html 코드 추가
		
		getCommentList(cri);
		
		$(document).on('click', '.comment-pagination .page-item', function(){
			cri.page = $(this).data('page');
			getCommentList(cri);
		});
		
		function checkLogin(){
			if('${user.me_id}' != ''){
				return false;
			}
			if(confirm("로그인이 필요한 서비스입니다.\n로그인 하시겠습니까?")){
				location.href="<c:url value="/login"/>";
			}
			return true;
		}
		
		$(document).on('click', '.btn-insert', function(){
			if(checkLogin()){
				return;
			}
			let cm_content = $('#input-comment').val();
			let cm_po_num = '${post.po_num}';
			let comment = {
					cm_content : cm_content,
					cm_po_num : cm_po_num
			}
			if(cm_content.length == 0){
				alert('댓글을 입력하세요');
				$('#input-comment').focus();
				return;
			}
			$.ajax({
				async : true,
				url : '<c:url value="/comment/insert" />', 
				type : 'post', 
				data : JSON.stringify(comment), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					if(data){
						alert('댓글 등록 성공');
						$('#input-comment').val('');
					}else{
						alert('댓글 등록 실패');
					}
					getCommentList(cri);
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR);
				}
			});
		});
		
		$(document).on('click', '.comment-delete', function(){
		    let cm_num = $(this).data('num');
		    // commentDel1(cm_num);
		    // commentDel2(cm_num);
		    commentDel3(cm_num);
		});
		
		function commentDel1(cm_num){
			let comment = {
				cm_num : cm_num
			}
			$.ajax({
				async : true,
				url : '<c:url value="/comment/delete1" />', 
				type : 'post', 
				data : JSON.stringify(comment), 
				contentType : "application/json; charset=utf-8",
				dataType : "json", 
				success : function (data){
					if(data.res){
						alert("댓글 삭제 성공");
					}else{
						alert("댓글 삭제 실패");
					}
					getCommentList(cri);
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR);
				}
			});
		}
		
		function commentDel2(cm_num){
			let comment = {
				cm_num : cm_num
			}
			$.ajax({
				async : true,
				url : '<c:url value="/comment/delete2" />', 
				type : 'post', 
				data : comment, 
				dataType : "json", 
				success : function (data){
					if(data.res){
						alert("댓글 삭제 성공");
					}else{
						alert("댓글 삭제 실패");
					}
					getCommentList(cri);
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR);
				}
			});	
		}
		
		function commentDel3(cm_num){
			let comment = {
				cm_num : cm_num
			}
			$.ajax({
				async : true,
				url : '<c:url value="/comment/delete3" />', 
				type : 'post', 
				data : comment, 
				success : function (data){
					if(data){
						alert("댓글 삭제 성공");
					}else{
						alert("댓글 삭제 실패");
					}
					getCommentList(cri);
				}, 
				error : function(jqXHR, textStatus, errorThrown){
					console.log(jqXHR);
				}
			});
		}
		
		$(document).on('click', '.comment-update', function(){
			let cm_num = $(this).data('num');
			let cm_content = $(this).parents('.comment-item').find('.comment-content').text();
			console.log(cm_num);
			console.log(cm_content);
			let str = `
				<div class="comment-input-box comment-update-box">
				<div class="input-group mb-3">
					<textarea class="form-control" placeholder="댓글 입력" id="input-update-comment">\${cm_content}</textarea>
					<input type="hidden" name="cm_num" value="\${cm_num}">
					<div class="input-group-append">
						<span class="input-group-text btn-update" style="cursor:pointer;">수정</span>
					</div>
				</div>
			</div>
		`;
		$('.comment-update-box').remove();
		$('.comment-input-box').hide();
		$('.comment-input-box').after(str);
		});
		
		$(document).off('click', '.btn-update');
		$(document).on('click', '.btn-update', function(){
			var cm_num = $('.comment-update-box').find('[name=cm_num]').val();
			var cm_content = $('#input-update-comment').val();
			var comment = {
				cm_num : cm_num,
				cm_content : cm_content
			};
			if(cm_content.length == 0){
				alert('댓글을 입력하세요');
				$('#input-update-comment').focus();
				return;
			}
			$.ajax({
				async : true,
				url : '<c:url value="/comment/update"/>', 
				type : 'post', 
				data : JSON.stringify(comment), 
				contentType : "application/json; charset=utf-8",
				success : function (data){
					if(data){
						alert('댓글 수정 완료');
				        $('.comment-update-box').remove();
				        $('.comment-input-box').show();
					}else{
						alert('댓글 수정 실패');
					}
					getCommentList(cri);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
</body>
</html>