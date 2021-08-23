<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>캐리 상세페이지</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/carry/carryDetail.css">
<script src="/gym/js/carryDetail.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<!-- Contents -->
	<div class="container">
		<div class="carry_image swiper-container mySwiper">
			<ul class="swiper-wrapper">
				<li class="swiper-slide"><img src="<c:url value="/images/review1.jpg"/>"></li>
				<li class="swiper-slide"><img src="<c:url value="/images/review2.jpg"/>"></li>
				<li class="swiper-slide"><img src="<c:url value="/images/review3.jpg"/>"></li>
				<li class="swiper-slide"><img src="<c:url value="/images/review4.jpg"/>"></li>
				<li class="swiper-slide"><img src="<c:url value="/images/review1.jpg"/>"></li>
				<li class="swiper-slide"><img src="<c:url value="/images/review2.jpg"/>"></li>
			</ul>
			<div class="swiper-pagination"></div>
		</div>



		<!-- quickmenu section START -->
		<div class="quickmenu_section">
			<nav class="quickmenu">
				<ul>
					<li><a href="#">소개</a></li>
					<li><a href="#">후기</a></li>
					<li><a href="#">전문분야</a></li>
					<li><a href="#">소속 플레이스</a></li>
					<li><a href="#">위치</a></li>
					<li><a href="#">자격/경력</a></li>
					<li><a href="#">이용가격</a></li>
				</ul>
			</nav>
		</div>
		<!-- quickmenu section END -->


		<hr>


		<div class="place_info container_fix">

			<div class="place_info_content">
				<!-- carry info section START -->

				<div class="carryinfo_section">

					<div id="c1"></div>

					<table class="carry_info_message">
						<tr>
							<td><span class="carry_name">김자바</span></td>
						</tr>
						<tr>
							<td><span class="carry_introduce">"캐리소갯 말입니다캐리소갯말입니다
									캐리소갯말<br>말입니다캐리소갯말입니다 캐리소갯말입캐리소갯 말입니다캐리소갯말입니다 캐리소갯말입입니다."
							</span></td>
						</tr>
						<tr>
							<td>
								<div class="carry_procategory">
									<span style="color: #AAA">전문분야</span> <br> <span>바른
										체형, 근력 강화, 바디 프로필</span>
								</div>

							</td>
						</tr>
					</table>
				</div>
				<!-- carry info section END -->


				<div class="carry_carrer">
					<h3>자격 및 경력</h3>
					<ul>
						<li>어쩌고저쩌고</li>
						<li>어쩌고저쩌고어쩌</li>
						<li>어쩌고어</li>
						<li>어쩌고어쩌고저쩌고저</li>
						<li>어쩌고어쩌고저쩌고저쩌</li>
						<li>어쩌고어쩌고저</li>
					</ul>
				</div>



				<!-- carry review section all wrap START -->
				<div class="carry_review_wrap">
					<div class="carry_review_title">
						<h2>캐리 후기</h2>
						<input type="button" value="후기작성" id="write_review_btn">
					</div>

					<div class="review_list_section">
						<div class="member_profile_image">
							<img src="<c:url value="/images/icon/profile.png"/>" style="width: 50px">
						</div>

						<div class="review_content">
							<span class="review_name">박회원</span> <span class="review_date">2021.08.20</span>
							<br> <span>어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고저쩌고어쩌고</span>
						</div>

					</div>

						<div class = "review_write display_none">
							<input type = "text" class="review_input" placeholder="캐리 리뷰를 작성해주세요.">
							<input type = "submit" value="작성" class="write_btn">
						</div>

				</div>
				<!-- carry review section all wrap END -->



				<!-- 소속 플레이스 section all wrap START -->
				<div class="carry_place_title">
					<h2>소속 플레이스</h2>
					<div class="carry_place_content">
						<img src="http://placehold.it/570x380"> <span><a
							href="#">어쩌고짐 신촌점</a></span>
					</div>
				</div>
				<!-- 소속 플레이스 section all wrap END -->



				<div class="place_map">
					<h3>지도</h3>
					<div class="place_address">
						<p>경기 안산시 단원구 선부광장1로 72 4층</p>
						<p>0507-1388-6848</p>
					</div>
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3162.3482559449353!2d126.98313801564814!3d37.57041633166289!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2e88bffbb25%3A0x47dbc264f2cc5695!2z67mE7Yq47Lqg7ZSE!5e0!3m2!1sko!2skr!4v1629288115032!5m2!1sko!2skr"
						width="100%" height="300px" style="border: 0;" allowfullscreen=""
						loading="lazy"> </iframe>
				</div>
			</div>
			
			
			<!-- 우측 배너 START -->
			<div class="right_banner">
			
				<div id="c2" class="circle"></div>
				<h2>김자바</h2>
				
				<div class="program_all">
				
					<div class="program">
						<div class="program_info">
							<span>수업 1회 이용권</span> <br>
							<h4>50,000원</h4>
						</div>
						<div id="purchase_btn">
							<input type="button" value="구매하기" class="button">
						</div>
					</div>

					<div class="program">
						<div class="program_info">
							<span>수업 5회 이용권</span> <br>
							<h4>230,000원</h4>
						</div>
						<div id="purchase_btn">
							<input type="button" value="구매하기" class="button">
						</div>
					</div>

					<div class="program">
						<div class="program_info">
							<span>수업 10회 이용권</span> <br>
							<h4>460,000원</h4>
						</div>
						<div id="purchase_btn">
							<input type="button" value="구매하기" class="button">
						</div>
					</div>

					<div class="program">
						<div class="program_info">
							<span>수업 20회 이용권</span> <br>
							<h4>930,000원</h4>
						</div>
						<div id="purchase_btn">
							<input type="button" value="구매하기" class="button">
						</div>
					
					</div>
				
				</div>
			</div>
			<!-- 우측 배너 END -->

		</div>
	</div>


	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>


	<script>
		// place 이미지 슬라이드
		var swiper = new Swiper(".mySwiper", {
			spaceBetween : 0,
			slidesPerView : 4,
			centeredSlides : false,
			autoplay : {
				delay : 2500,
				disableOnInteraction : false,
			},
			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
		});
	</script>