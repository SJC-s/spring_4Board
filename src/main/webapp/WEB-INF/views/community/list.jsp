<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<link rel="stylesheet" href="../resources/css/table.css">
<link rel="stylesheet" href="../resources/css/list.css">
<script type="text/javascript">
	if('${message}'.length != 0) alert('${message}')
</script>
</head>
<body>
	<h2>글 목록</h2>
	<hr>
	<p>현재페이지의 정보 : ${pageDto} <!-- PageReqDto(page=1, pageSize=10, startNo=1, endNo=10) --></p>
	전체 페이지 수 : <c:out value="${pageDto.totalPages }"/> , 전체 글의 개수 : <c:out value="${pageDto.totalCount }"/> , 현재 페이지번호 : <c:out value="${pageDto.page }"/>
	<hr>
	<div style="width: 70%; margin: auto; padding: 10px; ">
	<!-- url은 같고 파라미터만 다른 경우 href 에 파라미터만 표시할 수 있음 -->
		<a href="?page=1" class="pagenum">&lt;&lt;</a>
		<a class="pagenum" href="?page=${pageDto.startPage-1 }" style='<c:if test="${pageDto.startPage==1 }">display:none;</c:if>' >&lt;</a>
		<c:forEach var="i" begin="${pageDto.startPage }" end="${pageDto.endPage }">
			<a href="?page=${i }" class="pagenum ino"><c:out value="${i }"/></a>
		</c:forEach>
		<a class="pagenum" href="?page=${pageDto.endPage+1 }" style='<c:if test="${pageDto.endPage>=pageDto.totalPages }">display:none;</c:if>'   >&gt;</a>
		<a href="?page=${pageDto.totalPages }" class="pagenum">&gt;&gt;</a>
	</div>
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
				<td><a href="read?idx=${dto.idx }&page=${pageDto.page}"><c:out value="${dto.title}"/></a></td>
				<td><c:out value="${dto.writer}"/></td>
				<td><c:out value="${dto.readCount}"/></td>
				<td><c:out value="${dto.createdAt}"/></td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="write?page=${pageDto.page }">글쓰기</a></p>
	
	<!-- 글쓰기 완료시에는 글목록 1페이지로 이동 / 글쓰기 중단시에는 원래 글목록 페이지로 이동 -->
	<script type="text/javascript">
		const inos = document.querySelectorAll('.ino')
		console.log(inos)
		inos.forEach(
				(i) => {
					console.log('i=', i.innerHTML.trim());
					if(i.innerHTML=='${pageDto.page}') {
					/* 	i.style.color='red'
						i.style.fontWeight='bold' */
						i.classList.add('current')
					} else {
						i.style.color='#79747E'
						i.style.backgroundColor='white'
						i.classList.remove('current')
					}
				}
				
		)
	</script>
	
</body>
</html>