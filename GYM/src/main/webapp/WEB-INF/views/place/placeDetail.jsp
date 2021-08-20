<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/place/placeDetail.css">
<script src="/gym/js/placeDetail.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	
	<!-- Contents -->
    <div class="container place_detail_section">
        <div class="place_image swiper-container mySwiper">
            <ul class="swiper-wrapper">
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img1.jpg"/>">
                </li>
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img2.jpg"/>">
                </li>
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img3.jpg"/>">
                </li>
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img4.jpg"/>">
                </li>
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img5.jpg"/>">
                </li>
                <li class="swiper-slide">
                    <img src="<c:url value="/images/place/img6.jpg"/>">
                </li>
            </ul>
            <div class="swiper-pagination"></div>
        </div>
        <div class="place_info container_fix">
            <div class="place_info_content">
                <h2 class="place_name">
                    킹짐
                </h2>
                <p class="place_introduce">
                    안녕하세요^^<br>
                    안산 선부동 500평규모의 대규모 토탈휘트니스센터 킹짐3호점입니다.<br><br>
                    <킹짐3호점><br>
                    1.새벽6~저녁12시 까지 운영<br>
                    2.유산소&웨이트기구 150대 구비<br>
                    3.명문체육대학 출신 선생님들 대기<br>
                    4.다양한 GX수업!!<br><br>
                    회원님 한분한분 대표인 제가 직접 신경쓰고 발로뛰면서 <br>
                    안산 선부동에서 1등 헬스장 보단 만족 1등을 하기 위해 최선을
                    다하겠습니다^^
                </p>
                <div class="place_address">
                    <h3>위치</h3>
                    <p>경기 안산시 단원구 선부광장1로 72 4층</p>
                    <p>0507-1388-6848</p>
                </div>
                <div class="place_time">
                    <h3>운영시간</h3>
                    <ul>
                        <li>
                            <span>평일</span> 06:00 - 24:00
                        </li>
                        <li>
                            <span>토요일</span> 09:00 - 19:00
                        </li>
                        <li>
                            <span>일요일</span> 휴무
                        </li>
                        <li>
                            <span>공휴일</span> 12:00 - 18:00
                        </li>
                    </ul>
                </div>
                <div class="place_parking">
                    <h3>이용정보</h3>
                    <ul>
                        <li>주차 가능</li>
                        <li>남/녀 화장실 구분</li>
                        <li>지역화폐(카드형)</li>
                        <li>지역화폐(모바일형)</li>
                    </ul>
                </div>
                <div class="place_map">
                    <h3>지도</h3>
                    <iframe
                        src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3162.3482559449353!2d126.98313801564814!3d37.57041633166289!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2e88bffbb25%3A0x47dbc264f2cc5695!2z67mE7Yq47Lqg7ZSE!5e0!3m2!1sko!2skr!4v1629288115032!5m2!1sko!2skr"
                        width="100%" height="300px" style="border:0;" allowfullscreen="" loading="lazy">
                    </iframe>
                </div>
            </div>
            <div class="place_banner">
                <img src="<c:url value="/images/place/img1.jpg"/>" alt="img">
                <h4 class="place_name">
                    킹짐
                </h4>
                <div class="place_tel">
                    02) 0000 - 0000
                </div>
            </div>
        </div>
    </div>
    <!-- Contents end -->
	
	
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	
	
	<script>
        // place 이미지 슬라이드
        var swiper = new Swiper(".mySwiper", {
        spaceBetween: 0,
        slidesPerView: 4,
        centeredSlides: false,
        autoplay: {
          delay: 2500,
          disableOnInteraction: false,
        },
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
      });
    </script>