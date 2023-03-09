<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
	<h3>jstl.page</h3>
	<%
	String name = (String) application.getAttribute("name");
	String n = "Hong";
	
	if ( n == null) {
		System.out.print("name"+n);
	}else{
		System.out.print("m은 null입니다");
	}
	
	%>
	
	<p> name : <%=name%> </p>
	<p> name : ${name }</p>  <!-- request,session,application -->
	<p>Members: ${list }</p>
	
	<c:set value="Hong" var="m"></c:set> <!-- 변수담고 -->
	<c:out value="${m }"></c:out>  <!-- 변수읽어옴 -->

	<c:if test="${m != null }"> <!-- 단독if문 -->
	<p>m의 값은 null이 아닙니다. <c:out value="${m }"></c:out></p>
	<p></p>
	</c:if>
	
	<c:choose> <!-- if -else구문 -->
	 <c:when test ="${m !=null }">
	 <p>m은 null아닙니다. ${m }</p>
	 </c:when>
	 <c:otherwise>
	  <p>m은 null입니다.
	 </c:otherwise>
	</c:choose>
	
	<c:set var = "score" value="85"></c:set>
	
	<c:choose>
	<c:when test="${score >= 90 }">
	 <p>A학점입니다</p>
	</c:when>
	<c:when test="${score >= 80 }">
	 <p>B학점입니다</p>
	</c:when>
	<c:when test="${score >= 70 }">
	 <p>C학점입니다</p>
	</c:when>
	<c:otherswise test="${score >= 60 }">
	 <p>D학점입니다</p>
	</c:otherswise>>
	
	 
	</c:choose>
</body>
</html>