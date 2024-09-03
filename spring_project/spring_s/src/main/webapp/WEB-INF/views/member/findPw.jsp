<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
	<h1>비번찾기</h1>
	<div>
		<div class="form-group">
			<label for="id">아이디:</label>
			<input type="text" class="form-control" id="id" name="me_id">
		</div>
		<button type="button" class="btn btn-outline-dark col-12 btn-find-pw">비번찾기</button>
	</div>
	
	<script type="text/javascript">
		$('.btn-find-pw').click(function(){
			var id = $('#id').val();
			if(id == ''){
				alert('아이디를 입력하세요.');
				return;
			}
			$.ajax({
				async : false,
				url : '<c:url value="/find/pw"/>', 
				type : 'post', 
				data : {id : id}, 
				success : function (data){
					console.log(data);
				}, 
				error : function(jqXHR, textStatus, errorThrown){

				}
			});
		});
	</script>
</body>
</html>