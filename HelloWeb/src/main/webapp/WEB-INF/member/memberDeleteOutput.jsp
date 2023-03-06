<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../includes/sidebar.jsp" %>
	<%@ include file="../includes/top.jsp" %>
	
	<h3>회원정보삭제결과</h3>
	<%
 	String message = (String) request.getAttribute("message");
	%>
	<% 
	if (message != null){
	%>
	 <p><%=message %></p>
	<%
	}
	%>
	<p>회원목록으로 이동</p>
	<a href="memberList.do">목록으로 이동</a>
	
	<%@ include file="../includes/footer.jsp" %>