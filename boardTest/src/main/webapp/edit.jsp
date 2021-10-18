<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script type="text/javascript">
	function del() {
		result = confirm("정말로 삭제하시겠습니까?");
		if (result == true) {
			location.href = "mdelete.do?&mnum=${mdata.mnum}";
		} 
		else {
			return;
		}
	}
</script>
</head>
<body>
	<form action="mupdate.do" method="post" name="form1">
	<input type="hidden" name="mnum" value="${mdata.mnum}"> 
	<input type="hidden" name="userid" value="${seUser.userid}">
			<table border="1">
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${mdata.title}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type="text" name="content" value="${mdata.content}"></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="수정" class="button">
						<input type="button" value="삭제" class="button" onclick="del()">
					</td>
				</tr>
			</table>
		</form>
	<a href="list.do">메인으로</a>
</body>
</html>