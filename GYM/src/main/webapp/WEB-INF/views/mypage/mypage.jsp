<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servey</title>
<!-- jQuery -->
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/grid.css">

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div class="contents_main">
		<div class="contents">

			<div class="col">
				<div class="col-left">

					<div class="my-info">

						<div class="col-profile">
							<img id="loadingimg" class="display_none"
								src="<c:url value="/images/icon/user.png"/>">

						</div>

						<div class="col-name">
							<div style="text-align: right; width: 55%; float: left;">
								<h3>이름</h3>
							</div>
							<div style="text-align: left; width: 35%; padding-left: 2%">버튼</div>
						</div>

						<div class="col-profile">
							<-----------------------------------------------------------------------------------------------------------------------
							캘린더 섹션
							-----------------------------------------------------------------------------------------------------------></div>
					</div>
					<div class="my-info-develope">
						<h3 class="info_title">My page</h3>
						<ul class="info_contents">

							<li class="info_list"><a href="#">내 기본 정보 수정</a></li>
							<li class="info_list"><a href="#">내가 작성한 글</a></li>
							<li class="info_list"><a href="#">내 결제 내역</a></li>
							<li class="info_list"><a href="#">내가 찜한 캐리</a></li>
						</ul>
					</div>
				</div>
				<div class="col-right">



					<div class="col-right-top">
						<h2>2021-08-23</h2>
					</div>
					<div class="col-right-top-memo">
						<h3>일일 메모</h3>


						<a href="#"><img class="edit_text"
							src="<c:url value="/images/icon/edit.png"/>"></a>

					</div>


					<div class="col-right-left">
						<h3>눈 바디</h3>
						<a href="#"><img class="edit_text"
							src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

					<div class="col-right-right">
						<h3>몸무게</h3>
						<a href="#"><img class="edit_text"
							src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

					<div class="col-right-right2">
						<h3>식단</h3>
						<a href="#"><img class="edit_text"
							src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>