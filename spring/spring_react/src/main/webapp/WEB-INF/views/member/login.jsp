<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/additional-methods.min.js"></script>
	<link rel="stylesheet" href="<c:url value='/resources/css/member.css'/>">
</head>
<body>
	<div class="member-box">
		<h1>로그인</h1>
		<form action="<c:url value="/login" />" method="post" id="form">
			<div class="form-group">
		  		<label for="id">아이디</label>
		    	<input type="text" class="form-control" id="id" name="me_id">
		  	</div>
		 	 <div class="form-group">
		    	<label for="pw">비밀번호</label>
		    	<input type="password" class="form-control" id="pw" name="me_pw">
		  	</div>
		  	<button type="submit" class="btn btn-info col-12">로그인</button>
		</form>	
	</div>
	<script type="text/javascript">
		// 아이디가 없으면 아이디창 활성화하고 아이디가 있으면 비번창을 활성화
		var id = $('#id').val();
		if(id == ''){
			$('#id').focus();
		}else{
			$('#pw').focus();
		}
		
		// 아이디나 비번이 입력되지 않으면 알림을 띄우고 해당 창을 활성화
		$('#form').submit(function(){
			var id = $('#id').val();
			var pw = $('#pw').val();
			if(id == ''){
				alert('아이디를 입력하세요.');
				$('#id').focus();
				return false;
			}
			if(pw == ''){
				alert('비밀번호를 입력하세요.');
				$('#pw').focus();
				return false;
			}
			return true;
		});
	</script>
</body>
</html>
