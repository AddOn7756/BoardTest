<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.message.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>

</head>
<body>

	<c:if test="${seUser!=null}">
	${seUser.userid} <hr>
		<form action="logout.do" method="post" name="form2">
			<input type="submit" value="로그아웃">
		</form>
	</c:if>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
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
					<td><c:if test="${seUser.userid==v.userid}">
							<a href="edit.do?mnum=${v.mnum}">${v.title}</a>
						</c:if> 
						<c:if test="${seUser.userid!=v.userid}">${v.title}</c:if>
						</td>
					<td>${v.userid}</td>
					<td>${v.wdate}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<input type="button" value="내가 쓴글" class="button" onclick="location.href='list.do?isMine=true'">
	<input type="button" value="글 작성하기" class="button" onclick="location.href='form.jsp'">
	<hr>
	<a href="mypage.jsp">회원정보 수정</a>
	<a href="listdo">메인으로</a>
</body>
</html>