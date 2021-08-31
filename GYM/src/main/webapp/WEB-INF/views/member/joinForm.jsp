<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>regi.jsp</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<style type="text/css">
.center {
	width: 60%;
	margin: 200px auto;
	border: 3px solid #8AC007;
	padding: 10px;
}
</style>

</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<h1>회원등록</h1>
	<p>환영합니다</p>

	<div class="center">

		<form method="post">

			<table border="1">	

				<tr>
					<td>이메일</td>
					<td><input type="text" name="mememail" size="20"></td>
				</tr>

				<tr>
					<td>패스워드</td>
					<td><input type="text" name="mempw" size="20"></td>
				</tr>

				<tr>
					<td>이름</td>
					<td><input type="text" name="memname" size="20"></td>
				</tr>

				<tr>
					<td>닉네임</td>
					<td><input type="text" name="memnick" size="20"></td>
				</tr>
				
				<tr>
					<td>핸드폰번호</td>
					<td><input type="text" name="memphone" size="20"></td>
				</tr>
				<tr>
					<td>생년월일</td>
					<td><input type="text" name="membirth" size="20"></td>
				</tr>
				
				<tr>
					<td>성별</td>
					<td><input type="text" name="memgender" size="20"></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="회원가입"></td>
				</tr>
			</table>
		</form>
		<a href="<c:url value="/index"/>">Home</a>
	</div>

	
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>





