<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GymCarry : 약관 및 정책</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/term&notice/term&notice.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- Content 시작 -->
	<div class="allWrap">
		<div class="title">
			<h1>${term.title}</h1>
			<p>${term.date}</p>
		</div>

		<div class="content_textarea">
		<span>
			<textarea rows="40" readonly><c:out value="${term.content}" /></textarea>
		</span>
		</div>
		<div class="prevBtn">
			<input type="button" value= "< 목록으로" onclick="location.href='<c:url value="/admin/content/termlist"/>'">
		</div>



	</div>
	<!-- Contents end -->






	<!-- Content 끝 -->


	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>