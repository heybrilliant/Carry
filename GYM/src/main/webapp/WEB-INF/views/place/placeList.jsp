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
         <div class="map_section">
             <iframe
                 src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3162.3482559449353!2d126.98313801564814!3d37.57041633166289!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2e88bffbb25%3A0x47dbc264f2cc5695!2z67mE7Yq47Lqg7ZSE!5e0!3m2!1sko!2skr!4v1629288115032!5m2!1sko!2skr"
                 width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy">
             </iframe>
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
	