<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/place/placeList.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	
	 <!-- Contents -->
     <div class="container container_fix place_list_section">
         <h1 class="page_title">
             내 주변 운동시설 찾아보기
         </h1>
         <ul class="place_menu">
             <li class="on">
                 <a href="<c:url value="/place/list"/>">전체</a>
             </li>
             <li>
                 <a href="<c:url value="/place/list?placenum=1"/>">헬스</a>
             </li>
             <li>
                 <a href="<c:url value="/place/pilates"/>">필라테스</a>
             </li>
             <li>
                 요가
             </li>
         </ul>
         <div class="place_search_bar">
             <input type="text" name="search" id="search" placeholder="센터명을 검색해보세요.">
             <button type="submit">
                 <img src="<c:url value="/images/icon/search_icon.png"/>" alt="search">
             </button>
         </div>
         <div id="map" class="map_section">
             
         </div>
         <div class="place_list">
             <c:forEach items="${placeList}" var="placeList" varStatus="status">
             	 <!-- 대표 이미지 추출  -->
	             <c:set var="imgUrl" value="${placeList.placeimg}"/>
	             <c:set var="imageList" value="${fn:split(imgUrl, ',')}"/>
				 <c:set var="length" value="${fn:length(imageList[0])}"/>
				 <c:set var="img" value="${fn:substring(imageList[0], 2, length-1)}"/>
			 
			 
	             <div class="place_content">
	                 <div class="place_info">
	                     <h3>${placeList.placename}</h3>
	                     <p>${placeList.placeaddress}</p>
	                     <a href="#">더 알아보기</a>
	                 </div>
	                 <div class="place_img">
	                 	<c:if test="${empty img}">
	                 		<img src="<c:url value="/images/review1.jpg"/>">
	                 	</c:if>
	                 	<c:if test="${!empty img}">
	                    	<img src="<c:out value="${img}"/>">
	                    </c:if>
	                 </div>
	             </div>
             </c:forEach>
         </div>
     </div>

     <!-- Contents end -->


	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2791d61cfcb1bc044154adc4c6bc431"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
	    mapOption = { 
	        center: new kakao.maps.LatLng(37.556305974393915, 126.9399847935459), // 지도의 중심좌표
	        level: 4 // 지도의 확대 레벨
	    };
	
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		 
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
		var positions = new Array();
		
		<c:forEach items="${placeList}" var="placeList" varStatus="status">
			positions.push({content : '<div class="map_in_place_name">${placeList.placename}</div>', latlng : new kakao.maps.LatLng(${placeList.latitude}, ${placeList.longitude})});
		</c:forEach> 
		
		console.log(positions[0])
		

		for (var i = 0; i < positions.length; i ++) {
		    // 마커를 생성합니다
		    var marker = new kakao.maps.Marker({
		        map: map, // 마커를 표시할 지도
		        position: positions[i].latlng // 마커의 위치
		    });
		
		    // 마커에 표시할 인포윈도우를 생성합니다 
		    var infowindow = new kakao.maps.InfoWindow({
		        content: positions[i].content // 인포윈도우에 표시할 내용
		    });
		
		    // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
		    // 이벤트 리스너로는 클로저를 만들어 등록합니다 
		    // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
		    kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
		    kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
		    kakao.maps.event.addListener(marker, 'click', makeClickListener(marker, i));
		}
		
		// 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
		function makeOverListener(map, marker, infowindow) {
		    return function() {
		        infowindow.open(map, marker);
		    };
		}
		
		// 인포윈도우를 닫는 클로저를 만드는 함수입니다 
		function makeOutListener(infowindow) {
		    return function() {
		        infowindow.close();
		    };
		}
		
		// 마커 클릭시 해당하는 place list로 스크롤 이동
		function makeClickListener(marker, i){
			return function(){
				var idx = i + 1;
				var window_y = window.scrollY;
				var content_top = $('.place_list .place_content:nth-child(' + idx + ')').offset().top
				
				window.scrollTo({
					top: content_top - 200,
					behavior: 'smooth'
				});
				
				
				$('.place_list .place_content:nth-child(' + idx + ')').addClass('on');
				
				
				$(window).scroll(function(){
					var window_top = $(window).scrollTop() + 500;
					if(window_top > content_top) {
						$('.place_list .place_content:nth-child(' + idx + ')').addClass('on');
					} else {
						$('.place_list .place_content:nth-child(' + idx + ')').removeClass('on');
					}		
				})
			}
		}
	</script>
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>