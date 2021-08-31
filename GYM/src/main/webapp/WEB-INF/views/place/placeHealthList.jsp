<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
             <li>
                 <a href="<c:url value="/place/list"/>">전체</a>
             </li>
             <li class="on">
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
             <div class="place_content">
                 <div class="place_info">
                     <h3>킹짐</h3>
                     <p>안산시 단원구 선부동</p>
                     <a href="<c:url value="/place/detail"/>">더 알아보기</a>
                 </div>
                 <div class="place_img">
                     <img src="<c:url value="/images/review1.jpg"/>">
                 </div>
             </div>
             <div class="place_content">
                 <div class="place_info">
                     <h3>어쩌고짐</h3>
                     <p>안산시 단원구 초지동</p>
                     <a href="#">더 알아보기</a>
                 </div>
                 <div class="place_img">
                     <img src="<c:url value="/images/review2.jpg"/>">
                 </div>
             </div>
             <div class="place_content">
                 <div class="place_info">
                     <h3>핏플리짐</h3>
                     <p>안산시 단원구 원곡동</p>
                     <a href="#">더 알아보기</a>
                 </div>
                 <div class="place_img">
                     <img src="<c:url value="/images/review3.jpg"/>">
                 </div>
             </div>
             <div class="place_content">
                 <div class="place_info">
                     <h3>베스트휘트니스</h3>
                     <p>안산시 단원구 선부동</p>
                     <a href="#">더 알아보기</a>
                 </div>
                 <div class="place_img">
                     <img src="<c:url value="/images/review4.jpg"/>">
                 </div>
             </div>
         </div>
     </div>

     <!-- Contents end -->

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c2791d61cfcb1bc044154adc4c6bc431"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div  
		    mapOption = { 
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };
		
		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		 
		// 마커를 표시할 위치와 내용을 가지고 있는 객체 배열입니다 
		var positions = [
		    {
		        content: '<div>카카오</div>', 
		        latlng: new kakao.maps.LatLng(33.450705, 126.570677)
		    },
		    {
		        content: '<div>생태연못</div>', 
		        latlng: new kakao.maps.LatLng(33.450936, 126.569477)
		    },
		    {
		        content: '<div>텃밭</div>', 
		        latlng: new kakao.maps.LatLng(33.450879, 126.569940)
		    },
		    {
		        content: '<div>근린공원</div>',
		        latlng: new kakao.maps.LatLng(33.451393, 126.570738)
		    }
		];
		
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
	</script>