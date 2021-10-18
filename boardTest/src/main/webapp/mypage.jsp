<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*"%>
<jsp:useBean id="memData" class="model.client.ClientVO"
	scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정/삭제</title>
<script type="text/javascript">
	function  memDel() {
		result = confirm("정말 탈퇴하시겠습니까?");
		if(result == true){
			location.href = "cdelete.do?&userID=${seUser.userid}";
		} else{
			return;
		}
	}
</script>
</head>
<body>

	<form action="cupdate.do" method="post" name="form1">
		<table border="1">
			<tbody>
				<tr>
					<th>ID</th>
					<td><input type="text" name="userID" value="${seUser.userid}"
						readonly="readonly"></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="text" name="userPW" value="${seUser.pw}"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="${seUser.name}"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2" align="right"><input type="submit"
						value="수정" class="button"> <input type="button"
						value="탈퇴" class="button" onclick="memDel()"></td>
				</tr>
			</tfoot>
		</table>
	</form>
	<a href="list.do">메인으로</a>
</body>
</html>