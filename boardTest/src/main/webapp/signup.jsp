<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입페이지</title>
<script src="jquery-3.6.0.min.js"></script>
<script type="text/javascript">


</script>
</head>
<body>

	<form action="signup.do" method="post" name="form1">
		<table border="1">
			<tr>
				<td>id</td>
				<td><input type="text" name="userid" id="userid" required></td>
			</tr>
			<tr>
				<td>pw</td>
				<td><input type="password" name="pw" required></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="회원가입">
				</td>
			</tr>
		</table>
	</form>

</body>
</html>