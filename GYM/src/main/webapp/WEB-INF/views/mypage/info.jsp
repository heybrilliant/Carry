<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>

<!-- 개인 css -->
<link rel="stylesheet" href="/gym/css/mypage/grid.css">

<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>

<!--제이쿼리 CDN-->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/gym/css/mypage/bootstrap.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>


</head>
<body>

	<div class="col-right-top">
		<input type="text" id="alternate" size="30">
	</div>
	<div class="col-right-top-memo">
		<h3>일일 메모</h3>

		<a class="" data-toggle="modal" href="#registerModal1"><img
			class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>

	</div>

	<div class="col-right-left">
		<h3>눈 바디</h3>
		<a class="" data-toggle="modal" href="#registerModal2"><img
			class="edit_text" src="<c:url value="/images/icon/upload.png"/>"></a>
	</div>

	<div class="col-right-right">
		<h3>몸무게</h3>
		<a class="" data-toggle="modal" href="#registerModal3"><img
			class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>
	</div>

	<div class="col-right-right2">
		<h3>식단</h3>
		<a class="" data-toggle="modal" href="#registerModal4"><img
			class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>
	</div>


</body>


</html>

