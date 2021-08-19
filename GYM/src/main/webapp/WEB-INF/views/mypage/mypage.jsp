<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/grid.css">
<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet" href="../css/swiper.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="../js/index.js"></script>
<!-- Initialize Swiper -->

<title>GymCarry Mypage</title>

</head>

<body>
	<!-- Header -->

	<!-- Header End -->
	<!-- Contents -->
	<div class="container">

		<section class="review_section container_fix swiper-container">

		<div class="col-3"> aa </div>
		
		<div class="col-9"> aa </div>

		</section>
		

	</div>
	<!-- Contents end -->
	<!-- Footer -->
	<header>
		<%@ include file="/WEB-INF/views/frame/header.jsp"%>
		<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	</header>
	</footer>
	</div>
	<script>
		// review slider
		var swiper = new Swiper('.swiper-container', {
			slidesPerView : 4,
			direction : getDirection(),
			navigation : {
				nextEl : '.swiper-button-next',
				prevEl : '.swiper-button-prev',
			},
			on : {
				resize : function() {
					swiper.changeDirection(getDirection());
				},
			},
		});

		function getDirection() {
			var windowWidth = window.innerWidth;
			var direction = window.innerWidth <= 760 ? 'vertical'
					: 'horizontal';

			return direction;

		}
	</script>
</body>

</html>