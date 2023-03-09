<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 연습.</title>
</head>
<body>
	<%
	request.getAttribute(""); // jsp페이지가 서블릿으로 변환.
	//request.setAttribute("name", "Hong"); //
	//response.sendRedirect("jstl.jsp"); //내장객체.
	session.setAttribute("name","Hong");//
	List<MemberVO> members = new ArrayList<>();
	MemberVO m1 = new MemberVO();
	m1.setId("user1"); m1.setName("사용자1");
	MemberVO m2 = new MemberVO();
	m2.setId("user2"); m2.setName("사용자2");
	members.add(m1);
	members.add(m2);
	request.setAttribute("list",members);
	//request.getRequestDispatcher("jstl.jsp").forward(request,response);
	request.getRequestDispatcher("jstl2.jsp").forward(request,response);
	%>
	Literal : ${"string"}<br>
	연산자: ${3>5} <br>
		  <p>${10 - 4 }</p>
 	파라미터: <p>${param.p }</p>
</body>
</html>