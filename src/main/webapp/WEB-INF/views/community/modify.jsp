<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
</head>
<body>
	<h2>글 수정</h2>
	<hr>
	<form action="modify" method="post" name="frmModify" onsubmit="return isValid()">
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>">
		<input type="hidden" name="idx" value="${dto.idx }">
		<input type="hidden" name="page" value="${page }">
		<table>
			<tr>
				<th>제목</th>
				<td> <input type="hidden" name="title" value="(수정)${dto.title }">
				<input type="text" value="(수정)${dto.title }" disabled></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${dto.writer }" disabled></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="30" cols="80" name="content"><c:out value="${dto.content }"/></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<!-- submit 은 서버로 입력값들을 전송(자바스크립트에도 form요소에 submit 함수를 갖고 있다 -->
					<button type="submit">저장</button>
					<!-- 처음 화면의 value 값으로 복구 -->
					<button type="reset">다시쓰기</button>
					<button type="button" onclick="location.href='list?page=${page}'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>