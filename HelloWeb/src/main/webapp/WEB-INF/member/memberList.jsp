
<%@page import="co.dev.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	<%
	// 자바 영역.
		List<MemberVO> list = (List<MemberVO>) request.getAttribute("members"); // list 주소값.
		System.out.print(list);
	%>
	<table class= "table">
	<thead>
		<tr><th>Id</th><th>Name</th><th>Pass</th><th>Mail</th></tr>
	</thead>
	 <tbody>

	<%
	    for (MemberVO member : list) {
	%>
	    <tr><td><%=member.getId() %></td>
	   		<td><%=member.getName() %></td>
	    	<td><%=member.getPasswd() %></td>
	    	<td><%=member.getMail()%></td></tr>
	<%
	    }
	%>
	 </tbody>
	</table>
	<p>회원등록 페이지 이동</p>
	<a href="memberInsertForm.do">회원등록페이지</a>
	<%@ include file="../includes/footer.jsp" %>