<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h2>자바 스크립트 연습</h2>
	<input type="button" value="night" id="theme">   
	<input type="button" value="hi" id="hi">
	<br>
	
	<script type="text/javascript">
		$('#theme').on('click', function(){
			var target = $(this).val();
			if(target === 'night'){
				$('body').css('backgroundColor', 'black');
				$('body').css('color', 'white');
				$(this).val('day');
				$('a').css('color', 'powderblue');
			}else{
				$('body').css('backgroundColor', 'white');
				$('body').css('color', 'black');
				$(this).val('night');
				$('a').css('color', 'rgba(255, 255, 255, 0.5)');
			}
		});
		
		$('#hi').on('click', ()=>{
			alert("hi");
		});
	</script>
</body>
</html>
