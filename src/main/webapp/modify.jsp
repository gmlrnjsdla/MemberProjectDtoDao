<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.heekwoncompany.member.*" %>   
<% request.setCharacterEncoding("utf-8"); %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h3>회원 정보 수정</h3>
	<hr>
	<%
		MemberDao dao = new MemberDao();
		String id = (String)session.getAttribute("memberId");
		MemberDto dto = dao.getMemberInfo(id);
	
	%>
	<form action="modifyOk.jsp" method="post">
	아이디 : <input type="text" name="id" size="20" value="<%=dto.getId()%>" readonly="readonly"><br><br>
	비밀번호 : <input type="password" name="pw" size="20" value="<%=dto.getPw()%>"><br><br>
	이름 : <input type="text" name="username" size="20" value="<%=dto.getUsername()%>"><br><br>
	이메일 : <input type="text" name="email" size="20" value="<%=dto.getEmail()%>"><br><br>
	가입일 : <input type="text" name="signuptime" size="20" value="<%=dto.getSignuptime()%>" readonly="readonly"><br><br>
	<input type="submit" value="수정완료">&nbsp&nbsp&nbsp
	<input type="button" value="수정취소" onclick="javascript:window.location = 'main.jsp'">
	</form>
</body>
</html>