<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>결제 페이지</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/payment/payment.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<!-- Contents -->
        <div class="container_fix container payment_wrap">
            <h2>결제하기</h2>
                <div>
                    <h3>주문 정보</h3>
                    <div class="order_info">
                        <span>어쩌고짐 : 김자바 캐리</span> <br>
                        <h4>10회 460,000원</h4>
                    </div>

                    <br><br>

                    <h3>결제 정보</h3>
                    <p>이름 <span style="color:blue">*</span></p>
                    <input type="text" class="input_box" required>
                    <p>연락처 <span style="color:blue">*</span></p>
                    <input type="text" class="input_box" required>

                    <br><br><br><br>

                    <h3>대면 / 비대면 여부</h3>
                    <div class="order_info">
                        <input type="checkbox"> 대면
                        <br>
                        <input type="checkbox"> 비대면
                    </div>

                    <br><br>

                    <h3>최종 결제 금액</h3>
                    <div class="pricebox">
                        <ul>
                            10회 강의권
                            <li>
                                460,000원
                            </li>
                        </ul>
                    </div>
                </div>


                <div class = "pay_btn">
                <input type="submit" value="결제하기" onclick="location.href='<c:url value = "/payment/complete"/>'">
                </div>
      
      
            </div>



        <!-- Contents end -->


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