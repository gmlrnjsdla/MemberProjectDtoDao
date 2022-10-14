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
<title>회원정보 수정 확인</title>
</head>
<body>
	<%
		MemberDao dao = new MemberDao();
		int modifyFlag = dao.modifyMemberInfo(dto);
		
		if(modifyFlag == 1){
			out.println("회원정보 수정 성공!");
		}
		else{
			out.println("회원정보 수정 실패!");
		}
	%>
</body>
</html>