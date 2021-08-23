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
             <li class="on">
                 전체
             </li>
             <li>
                 헬스
             </li>
             <li>
                 필라테스
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
         
         
         
         
<!-- 지도[s] -->    
    <div id="map" style="width:100%;height:50%; margin:auto; margin-top:10px;"></div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=42be5e09039a963ee3f9a39d4bcb5af4"></script>
    <script>
        var container = document.getElementById('map'); //지도 표시 div
        var options = {
            center: new kakao.maps.LatLng(36.300442, 127.574917), //지도의 중심좌표
            level: 3 //지도의 확대 레벨
        };
 
        var map = new kakao.maps.Map(container, options);
        
        // 마커가 표시될 위치
        var markerPosition  = new kakao.maps.LatLng(36.300442, 127.574917); 
 
        // 마커 생성
        var marker = new kakao.maps.Marker({
            position: markerPosition
        });
 
        // 마커가 지도 위에 표시되도록 설정
        marker.setMap(map);
 
        // 아래 코드는 지도 위의 마커를 제거하는 코드
        // marker.setMap(null);  
        
    </script>
    <!-- 지도[e] -->
         
         
         
         
         
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
	