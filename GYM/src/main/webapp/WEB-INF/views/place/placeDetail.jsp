<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/place/placeDetail.css">
<script src="/gym/js/placeDetail.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	
	<!-- Contents -->
	<c:set var="placeDetail" value="${placeDetail}"/>
    <div class="container place_detail_section">
        <div class="place_image swiper-container mySwiper">
            <ul class="swiper-wrapper">
           		<c:set var="imageLists" value="${placeDetail.placeimg}"/>
             	<c:set var="length" value="${fn:length(imageLists)}"/>
				<c:set var="img" value="${fn:substring(imageLists, 0, length-1)}"/>
				<c:set var="imageurl" value="${fn:split(img, ',')}"/>
				
				<c:forEach items="${imageurl}" var="image" varStatus="status">
            		<li class="swiper-slide">
            			<c:set var="urlLength" value="${fn:length(image)}"/>
            			<c:set var="Image" value="${fn:substring(image, 2, urlLength-1)}"/>
	                    <img src="<c:out value="${Image}"/>">
	                </li>
                </c:forEach>
            </ul>
            <div class="swiper-pagination"></div>
        </div>
        <div class="place_info container_fix">
            <div class="place_info_content">
                <h2 class="place_name">
                   	${placeDetail.placename}
                </h2>
                <p class="place_introduce">
	            	${placeDetail.placeintro}
                </p>
                <div class="place_address">
                    <h3>위치</h3>
                    <p>${placeDetail.placeaddress}</p>
                    <p>${placeDetail.placephone}</p>
                </div>
                <div class="place_time">
                    <h3>운영시간</h3>
                    <ul>
                    	<c:set var="timeList" value="${placeDetail.openhour}"/>
		             	<c:set var="timeListlength" value="${fn:length(timeList)}"/>
						<c:set var="times" value="${fn:substring(timeList, 0, timeListlength-1)}"/>
						<c:set var="timearr" value="${fn:split(times, ',')}"/>
						
						<c:forEach items="${timearr}" var="time" varStatus="status">
		            		<li>
		            			<c:set var="timelength" value="${fn:length(time)}"/>
		            			<c:set var="opentime" value="${fn:substring(time, 2, timelength-1)}"/>
			                    ${opentime}
			                </li>
		                </c:forEach>
                        <!-- <li>
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
                        </li> -->
                    </ul>
                </div>
                <div class="place_parking">
                    <h3>이용정보</h3>
                    <ul>
                    	<c:set var="placeinfo" value="${placeDetail.placeinfo}"/>
	            		<c:set var="infoList" value="${fn:split(placeinfo, ',')}"/>
	            		<c:forEach items="${infoList}" var="info">
	            			<li>${info}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="place_map">
                    <h3>지도</h3>
                    <div id="map" style="width:100%;height:300px;"></div>
                </div>
            </div>
            <div class="place_banner">
            
	            <c:set var="rightimg" value="${fn:split(imageLists, ',')}"/>
				<c:set var="rightImglength" value="${fn:length(rightimg[0])}"/>
				<c:set var="rightImage" value="${fn:substring(rightimg[0], 2, rightImglength-1)}"/>
				
                <c:if test="${empty img}">
               		<img src="<c:url value="/images/review1.jpg"/>">
               	</c:if>
               	<c:if test="${!empty img}">
                  	<img src="<c:out value="${rightImage}"/>">
                </c:if>
                <h4 class="place_name">
                    ${placeDetail.placename}
                </h4>
                <div class="place_tel">
                    ${placeDetail.placephone}
                </div>
            </div>
        </div>
    </div>
    <!-- Contents end -->
	
	
	<!-- kakao map api -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2791d61cfcb1bc044154adc4c6bc431"></script>
	<script>
	var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new kakao.maps.LatLng(${placeDetail.latitude}, ${placeDetail.longitude}), // 지도의 중심좌표
        level: 2 // 지도의 확대 레벨
    };

	var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
	
	// 마커가 표시될 위치입니다 
	var markerPosition  = new kakao.maps.LatLng(${placeDetail.latitude}, ${placeDetail.longitude}); 
	
	// 마커를 생성합니다
	var marker = new kakao.maps.Marker({
	    position: markerPosition
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker.setMap(map);
	</script>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	
	<!-- swiper plugin -->
	<script>
        // place 이미지 슬라이드
        var swiper = new Swiper(".mySwiper", {
        spaceBetween: 0,
        slidesPerView: 6,
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