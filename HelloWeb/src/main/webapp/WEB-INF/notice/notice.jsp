<%@page import="co.dev.vo.NoticeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../includes/sidebar.jsp" %>
<%@ include file="../includes/top.jsp" %>

<%
NoticeVO vo = (NoticeVO)request.getAttribute("notice");
%>

	<table class="table">
	<tr>
	 <td>글 번호</td>
	 <td><input type="text" name = "nid" readonly value="<%=vo.getNoticeId()%>" ></td>
	 <td>조회수 [ <b><%=vo.getHitCount() %></b> ]</td>
	 
	</tr>
	<tr>
	 <td>제목</td>
	 <td colsapn=2><input type="text" name = "title" value="<%=vo.getNoticeTitle()%>" ></td>
	</tr>
	<tr>
	 <td>작성자</td>
	 <td colsapn=2><input type="text" name = "writer" readonly value="<%=vo.getNoticeWriter()%>" ></td>
	</tr>
	<tr>
	 <td>내용</td>
	 <td colsapn=2><textarea cols="30" rows ="5" name="subject"><%=vo.getNoticeSubject()%>"</textarea></td>
	</tr>
	<tr>
	 <td>파일</td>
	 <td colsapn=2> <% if (vo.getAttach() != null) { %>
	 <td><input type="text" name = "attach" value="<%=vo.getAttach()%>">
	 <%} else{ %>
	 <input type="text" name="attach">
	 <%} %>
	</td>
	</tr>
	<tr>
	 <td colspan="3" align="center">
	 	<button id="modBtn">수정</button>
	 	<button id="delBtn">삭제</button>
	 </td>
	</tr>
</table>
<form id="myFrm" action="noticeModify.do">

</form>
<script>
	//수정.
document.querySelector('#modBtn').addEventListener('click',function(){
	let myFrm = document.querySelector('#myFrm');
	let nid=document.querySelector('input[name="nid"]').value;
	let title = document.querySelector('input[name="title"]').value;
	let subject = document.querySelector('textarea[name="subject"]').textContent;

	myFrm.append(document.querySelector('input[name="nid"]'));
	myFrm.append(document.querySelector('input[name="title"]'));
	myFrm.append(document.querySelector('textarea[name="subject"]'));
	console.log(myFrm);
	myFrm.submit();
});

//삭제
document.querySelector('#delBtn').addEventListener('click',function(){
	let myFrm = document.querySelector('#myFrm');
	myFrm.action = 'noticeRemove.do'; // myFrm.setAttribute('action','noticeRemevo.do')
	 //FrontController에 NoticeRemoveControl();
	 //서비스:noticeRemove(int nid), mapper: deleteNotice(int nid)
	myFrm.append(document.querySelector('input[name="nid"]'));

	myFrm.submit();

}
	
	
	)
</script>

<%@ include file="../includes/footer.jsp" %>