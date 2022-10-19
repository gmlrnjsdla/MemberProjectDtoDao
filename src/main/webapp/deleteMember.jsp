<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<jsp:useBean id="dto" class="com.heekwoncompany.member.MemberDto"/> 
<jsp:setProperty property="*" name="dto"/>
<%@ page import="com.heekwoncompany.member.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<%
		MemberDao dao = new MemberDao();
		String id = (String)session.getAttribute("memberId");
		int deleteFlag = dao.delete(id);
		
		if(deleteFlag == 1){
			out.println("회원 탈퇴 성공! 그동안 감사했습니다. 안녕히 가세요.");
		}
		else{
			out.println("회원 탈퇴 실패! 다시 확인해주세요.");
		}
	%>
	<br><br>
	<a href="main.jsp">메인화면으로 가기</a>
</body>
</html>