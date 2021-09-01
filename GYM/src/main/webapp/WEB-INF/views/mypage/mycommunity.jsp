<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mycommunity</title>
<link rel="stylesheet" href="/gym/css/community/community.css">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<!--제이쿼리 CDN-->

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- bootstrap -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div class="contents_main">
		<div class="contents">
			<h1 class="title">
				<a href="<c:url value="/mypage/mycommunity"/>">MY COMMUNITY</a>
			</h1>
			<nav class="community_nav">
				<ul>
					<!-- 정렬을 위해 왼쪽에 버튼 숨겨놓은 것 -->
					<button class="board_write2" type="button" onclick="">
						<img class="write_icon" src="/gym/images/icon/edit.png">
					</button>
				</ul>
			</nav>
			<div class="card_main">
				<div class="card">
					<div class="board_sidebar">
						<img class="profile_image" img
							src="<c:url value="/images/icon/profile2.png"/>" alt="img">
						<div class="nickname">닉네임</div>

					</div>
					<div class="board_main">
						<button class="title_btn" type="button" onclick="">소통</button>
						<h2 class="board_title">
							<a href="<c:url value="/community/postContent"/>">서강대 칼만두 맛집
								추천 합니다 !!</a>
						</h2>
						<p class="board_post">
							<a href="<c:url value="/community/postContent"/>"> 제가 오늘 서강대
								건너편 옥정이라는 평양식 만두국집 다녀왔는데요, 너무 맛있네요. 밥도 무료로 주세요. 대신 점심 장사라 2시까지만
								합니다. 웨이팅도 있는데 금방 빠져요. 인생 칼만두집을 찾았네요. 이열치열 지대로 느끼고 싶으신 분들 다녀오세요.
								입 힐링합니다^^</a>
						</p>
						<div class="board_bottom">
							<div class="write_date">2021.08.11 17:18:23 PM</div>
							<ul class="board_btn">
								<li><a href="#"> <img class="board_icon" img
										src="<c:url value="/images/icon/heart.png"/>" alt="img">2
								</a></li>
								<li><a href="#"><img class="board_icon" img
										src="<c:url value="/images/icon/speech-bubble.png"/>"
										alt="img">15</a></li>
							</ul>
						</div>
					</div>


				</div>

			</div>
		</div>
	</div>
</body>

<footer>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</footer>

</html>

