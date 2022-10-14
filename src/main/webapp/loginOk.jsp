<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.heekwoncompany.member.MemberDao" %>    
<% request.setCharacterEncoding("utf-8"); %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<h3>로그인 확인</h3>
	<hr>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	
		MemberDao dao = new MemberDao();
		int userFlag = dao.userCheck(id, pw);
		
		if(userFlag == 0){
			out.println("입력하신 아이디가 존재하지 않습니다.");
		}
		else if(userFlag == 2){
			out.println("비밀번호가 틀렸습니다.");
		}
		else{
			session.setAttribute("memberId", id);
			session.setAttribute("validMember", "yes");
			
			out.println(id+"님 반갑습니다.");
		}
		
	 %>
	 <a href="main.jsp">메인화면으로 가기</a>
</body>
</html>