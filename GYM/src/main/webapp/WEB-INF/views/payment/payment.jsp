<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>결제 페이지</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/payment/payment.css">

  <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>

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
                <input type="button" value="결제하기" onclick="requestPay();">
                <%-- <input type="submit" value="결제하기" onclick="location.href='<c:url value = "/payment/complete"/>'"> --%>
                </div>
      
      
            </div>



        <!-- Contents end -->


	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>


	<script>
	
		var IMP = window.IMP; // 생략 가능
		IMP.init("imp65837574"); // 예: imp00000000

		function requestPay() {
			// IMP.request_pay(param, callback) 결제창 호출
			IMP.request_pay({ // param
				pg : 'html5_inicis', //ActiveX 결제창은 inicis를 사용
				pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
				merchant_uid : "ORD20180131-0000014",
				name : "수업 10회 이용권",
				amount : 100,
				buyer_email : "gildong@gmail.com",
				buyer_name : "홍길동",
				buyer_tel : "010-4242-4242",
				buyer_addr : "서울특별시 강남구 신사동",
				buyer_postcode : "01181"
			}, function(rsp) { // callback
				if (rsp.success) {
					// 결제 성공 시 로직,
					location.href = "<c:url value="/payment/complete"/>";
				} else {
					// 결제 실패 시 로직,
					alert('결제가 취소되었습니다.');
				}
			});
		}

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