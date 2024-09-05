<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>커뮤니티 게시판</title>
<script type="text/javascript">
	/* 이 위치의 스크립트는 렌더링 되기 전에 실행이 된다 
	const frm = documnet.forms[0] 오류 발생
	*/
</script>

<!-- function 함수는 특별히 head 안에 있어도 렌더링 된 후에 동작 -->
<script type="text/javascript">
	function isValid() { // form 태그 onsubmit 이벤트 처리하는 함수(submit 하기 전)
		let result = true
		const frm = document.forms[0]
		const content = frm.content
		const title = frm.title
		const writer = frm.writer
		
		if (title.value == '') {
			alert('글 제목 작성은 필수입니다')
			result=false
			title.focus()
		} else if (writer.value == '') {
			alert('글 작성자 입력은 필수입니다')
			result=false
			writer.focus()
		} else if (content.value == '') {
			alert('글 내용 작성은 필수입니다')
			result=false
			content.focus()
		}
		// 참을 리턴하면 submit
		return result
	}
</script>
</head>
<body>
	<h2>새 글쓰기</h2>
	<hr>
	<!-- onsubmit="return isValid()" : return 이 참이면 submit, 거짓이면 submit 안함 -->
	<form action="write" method="post" name="frmWrite" onsubmit="return isValid()">
		<input type="hidden" name="ip" value="<%=request.getRemoteAddr() %>">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="30" cols="80" name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<!-- submit 은 서버로 입력값들을 전송(자바스크립트에도 form요소에 submit 함수를 갖고 있다 -->
					<button type="submit">저장</button>
					<button type="reset">다시쓰기</button>
					<button type="button" onclick="location.href='list?page=${page}'">목록</button>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>