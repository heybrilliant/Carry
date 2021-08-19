<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GymCarry</title>
<!-- index css -->
<link rel="stylesheet" href="/gym/css/swiper.css">
<!-- index js -->
<script src="/gym/js/index.js"></script>
<script src="/gym/js/swiper.js"></script>
<!-- JQuery, header css, footer css -->
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>
<body>
	
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	

	<!-- Contents -->
	<div class="container">
		<section class="video_section">
			<div class="video">
				<video src="<c:url value="/video/video3.mp4"/>" autoplay muted loop></video>
			</div>
			<div class="survey">
				<h3>혼자 하는 운동이 막막하고 어려우신가요?</h3>
				<h2>당신의 맞춤 전문 코치를 찾아드릴게요 !</h2>
				<a href="<c:url value='/member/servey'/>" class="btn">시작</a>
			</div>
		</section>
		<section class="review_section container_fix swiper-container">
			<h1 class="title">Carry Review</h1>
			<div class="review_contaier swiper-wrapper">
				<div class="review_content swiper-slide">
					<div class="review_img">
						<img src="<c:url value="/images/review1.jpg"/>" alt="img">
					</div>
					<div class="review">
						<h2 class="title">트레이너 이름</h2>
						<p>리뷰 내용입니다 최대 60자까지 노출 리뷰 내용입니다 최대 60자까지 노출리뷰 내용입니다 최대 60자까지
							노출</p>
					</div>
				</div>
				<div class="review_content swiper-slide">
					<div class="review_img">
						<img src="<c:url value="/images/review2.jpg"/>" alt="img">
					</div>
					<div class="review">
						<h2 class="title">트레이너 이름</h2>
						<p>리뷰 내용입니다 최대 60자까지 노출 리뷰 내용입니다 최대 60자까지 노출리뷰 내용입니다 최대 60자까지
							노출</p>
					</div>
				</div>
				<div class="review_content swiper-slide">
					<div class="review_img">
						<img src="<c:url value="/images/review3.jpg"/>" alt="img">
					</div>
					<div class="review">
						<h2 class="title">트레이너 이름</h2>
						<p>리뷰 내용입니다</p>
					</div>
				</div>
				<div class="review_content swiper-slide">
					<div class="review_img">
						<img src="<c:url value="/images/review4.jpg"/>" alt="img">
					</div>
					<div class="review">
						<h2 class="title">트레이너 이름</h2>
						<p>리뷰 내용입니다 최대 60자까지 노출 리뷰 내용입니다 최대 60자까지 노출리뷰 내용입니다 최대 60자까지
							노출</p>
					</div>
				</div>
				<div class="review_content swiper-slide">
					<div class="review_img">
						<img src="<c:url value="/images/review1.jpg"/>" alt="img">
					</div>
					<div class="review">
						<h2 class="title">트레이너 이름</h2>
						<p>리뷰 내용입니다 최대 60자까지 노출 리뷰 내용입니다 최대 60자까지 노출리뷰 내용입니다 최대 60자까지
							노출</p>
					</div>
				</div>
			</div>
			<div class="swiper-button-next"></div>
			<div class="swiper-button-prev"></div>
		</section>
	</div>
	<!-- Contents end -->
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>	
	
<!-- review slider script -->	
<script>
        var swiper = new Swiper('.swiper-container', {
            slidesPerView: 4,
            direction: getDirection(),
            navigation: {
                nextEl: '.swiper-button-next',
                prevEl: '.swiper-button-prev',
            },
            on: {
                resize: function () {
                    swiper.changeDirection(getDirection());
                },
            },
        });

        function getDirection() {
            var windowWidth = window.innerWidth;
            var direction = window.innerWidth <= 760 ? 'vertical' : 'horizontal';

            return direction;
        }
</script>	
	
</body>
</html>