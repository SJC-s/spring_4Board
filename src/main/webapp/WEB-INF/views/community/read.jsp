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
	<h2>글 내용</h2>
	<hr>
	<a href="list?page=${page }">목록으로 가기</a>
	<br>
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
			<td><c:out value="${dto.content }"/></td>
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
	</table>
</body>
</html>