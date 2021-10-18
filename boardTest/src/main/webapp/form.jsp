<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
	<form action="minsert.do" method="post" name="form1">
		<input type="hidden" name="userid" value="${seUser.userid}">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" required></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" required /></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit" value="글 등록" class="button"></td>
			</tr>
		</table>
	</form>
</body>
</html>