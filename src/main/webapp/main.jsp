<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 화면</title>
</head>
<body>
	<h3>메인 화면</h3>
	<hr>
	
	<%
		if(session.getAttribute("validMember") == null){ // 로그인 안한 상태
	%>
			<a href="login.jsp">로그인으로 가기</a>
	<% 	
		}
		else{
			String id = (String)session.getAttribute("memberId");
			out.println(id+"님 로그인 중<br><br>");
	%>
			<a href="logout.jsp">로그아웃</a>
			<br><br>
			<a href="modify.jsp">회원 정보 수정</a>
			<br><br>
			<a href="deleteMember.jsp">회원 탈퇴</a>
	<%
		}
	%>
</body>
</html>