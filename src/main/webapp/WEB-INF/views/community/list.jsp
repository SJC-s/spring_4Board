<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<link rel="stylesheet" href="../resources/css/table.css">
</head>
<body>
	<h2>글 목록</h2>
	<hr>
	<table>
		<tr>
			<td>번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>날짜</td>
		</tr>
		<c:forEach items="${list }" var="dto">
			<tr>
				<td><c:out value="${dto.idx}"/></td>
				<td><c:out value="${dto.title}"/></td>
				<td><c:out value="${dto.writer}"/></td>
				<td><c:out value="${dto.readCount}"/></td>
				<td><c:out value="${dto.createdAt}"/></td>
			</tr>
		</c:forEach>
	</table>
	<p>현재페이지의 정보 : PageReqDto(page=1, pageSize=10, startNo=1, endNo=10)</p>
</body>
</html>