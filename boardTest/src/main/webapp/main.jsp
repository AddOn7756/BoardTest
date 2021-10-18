<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.message.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

<c:if test="${seUser==null}">
	<form action="login.do" method="post" name="form1">
		<input type="hidden" name="action" value="login">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userid"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="로그인">
					<input type="button" value="회원가입"  onclick="location.href='signup.jsp'">
				</td>
			</tr>
		</table>
	</form>
</c:if>	
<hr>
<table border="1">
	<tr>
		<th>번호</th>
		<th>작성자</th>
		<th>제목</th>
		<th>작성일</th>
	</tr>
<c:if test="${mdatas==null}">
	<tr>
		<td colspan="5" align="center">등록된 게시글이 없습니다.</td>
	</tr>
</c:if>
<c:if test="${mdatas!=null}">
	<c:forEach var="v" items="${mdatas}">
		<tr>
			<td>${v.mnum}</td>
			<td>${v.userid}</td>
			<td>${v.title}</td>
			<td>${v.wdate}</td>
		</tr>
	</c:forEach>
</c:if>
</table>
</body>
</html>