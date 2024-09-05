<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<script type="text/javascript">
	if('${message}'.length != 0) alert('${message}')
</script>
</head>
<body>
	<h2>글 내용</h2>
	<hr>
	<%-- <a href="list?page=${page }">목록으로 가기</a> --%>
	<table>
		<tr>
			<td>번호</td>
			<td><c:out value="${dto.idx }"/></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><c:out value="${dto.title }"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><c:out value="${dto.writer }"/></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><c:out value="${dto.readCount }"/></td>
		</tr>
		<tr>
			<td>작성날짜</td>
			<td><c:out value="${dto.createdAt }"/></td>
		</tr>
		<tr>
			<td>IP</td>
			<td><c:out value="${dto.ip }"/></td>
		</tr>
		<tr>
			<td>댓글 수</td>
			<td><c:out value="${dto.commentCount }"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<!-- 글 내용 중 엔터는 화면에 줄이 바뀌어야 하지만, 문자열의 엔터는 \r\n 이고 브라우저의 줄바꿈은 <br> 태그
			메소드로 변경하는 것은 나중에 하고 pre 태그로 출력 -->
			<td>
				<pre><c:out value="${dto.content }"/></pre>
				<!-- <pre>${dto.content }</pre> : 자바스크립트 악성코드 실행 유발 -->
			</td>
		</tr>
	</table>
	<p></p>
	<div>
		<div class="button"><a href="modify?idx=${dto.idx }&page=${page}">수정</a></div>
		<div class="button"><a href="javascript:remove()">삭제</a></div>
		<div class="button"><a href="list?page=${page }">목록</a></div>
	</div>
	
	<form action="remove" method="post">
		<input type="hidden" name="idx" value="${dto.idx }">
		<input type="hidden" name="page" value="${page }">
		<!-- submit 버튼은 만들지 않고 위의 삭제가 클릭되면 자바스크립트 submit() 함수 실행 -->
	</form>
	<script type="text/javascript">
		function remove() {
			// form 요소는 배열(인덱스)로 처리 가능
			const frm = document.forms[0]
			const yn = confirm('이 글을 삭제하시겠습니까?')
			if(yn){
				frm.action = 'remove'				
				frm.submit()
			}
		}
	</script>
</body>
</html>