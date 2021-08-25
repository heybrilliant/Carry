<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<style type="text/css">
.center{
	width: 60%;
	margin: 200px auto;
	border: 3px solid #8AC007;
	padding: 10px;
}
</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 임의로 만든 로그인 -->
	<div class="center">
		<h1>멤버로그인</h1>
		<form action="<c:url value="/member/memberLogin"/>" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name=mememail size="20"></td>
				</tr>

				<tr>
					<td>패스워드</td>
					<td><input type="password" name="mempw" size="20"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="로그인"></td>
				</tr>
			</table>
		</form>

		<a href="<c:url value="/carry/login"/>">캐리로그인</a>
		<a href="<c:url value="/member/join"/>">멤버회원가입</a>
		<a href="<c:url value="/carry/join"/>">캐리회원가입</a>
	</div>
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>