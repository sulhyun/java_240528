<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.servlet.boot4.member.repository.MemberRepository" %>
<%@ page import="com.servlet.boot4.member.domain.Member" %>
<%@ page import="java.util.List" %>
<%
	MemberRepository memberRepository = MemberRepository.getInstance();
	List<Member> members = memberRepository.findAll();
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Title</title>
</head>
<body>
	<a href="/index.html">메인</a>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>username</th>
				<th>age</th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Member member : members) {
					out.write("    <tr>");
					out.write("        <td>" + member.getId() + "</td>");
					out.write("        <td>" + member.getUsername() + "</td>");
					out.write("        <td>" + member.getAge() + "</td>");
					out.write("    <tr>");
				}
			%>
		</tbody>
	</table>
</body>
</html>