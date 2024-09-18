<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h2>자바 스크립트 연습</h2>
	<input type="button" value="night" onclick="nightDay(this);">
	<input type="button" value="Hi" onclick="alert('Hi')">
	<br>
	
	<script type="text/javascript">
		function nightDay(self){
			var target = document.querySelector('body');
			if(self.value == 'night'){
				body.setBackgroundColor('black');
				body.setColor('white');
				self.value = 'day';
				
				link.setColor = ('powderblue');
			}else{
				body.setBackgroundColor('white');
				body.setColor('black');
				self.value = 'night';
				
				link.setColor = ('rgba(255, 255, 255, 0.5)');
			}
		}
		let link = {
			setColor : function(color){
				var list = document.querySelectorAll('a');
				for(var i = 0; i < list.length; i++){
					list[i].style.color = color;
				}
			}
		}
		let body = {
			setColor : function(color){
				document.querySelector('body').style.color = color;
			},
			setBackgroundColor : function(color){
				document.querySelector('body').style.backgroundColor = color; 
			}
		}
	</script>
</body>
</html>
