<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
<link rel="stylesheet" href="/gym/css/place/placeList.css">
<link rel="stylesheet" href="/gym/css/place/placeList.css">

<script type="text/javascript"
        src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ql9vcy7uun"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
        crossorigin="anonymous"></script>

</head>
<body>
<!-- header -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>


<!-- Contents -->
<div class="container container_fix place_list_section">
    <h1 class="page_title">내 주변 운동시설 찾아보기</h1>
    <ul class="place_menu">
        <li><a href="<c:url value="/place/all"/>">전체</a></li>
        <li><a href="<c:url value="/place/health"/>">헬스</a></li>
        <li class="on"><a href="<c:url value="/place/pilates"/>">필라테스</a>
        </li>
        <li><a href="<c:url value="/place/yoga"/>">요가</a></li>
    </ul>
    <div class="place_search_bar">
        <input type="text" name="search" id="search"
               placeholder="센터명을 검색해보세요.">
        <button type="submit">
            <img src="<c:url value="/images/icon/search_icon.png"/>"
                 alt="search">
        </button>
    </div>
    <div id="map" class="map_section"></div>

    <div class="place_list">
        <c:forEach items="${placePilatesList}" var="placeList" varStatus="status">
            <!-- 대표 이미지 추출 -->
            <c:set var="imgUrl" value="${placeList.placeimg}"/>
            <c:set var="imageList" value="${fn:split(imgUrl, ',')}"/>
            <c:set var="length" value="${fn:length(imageList[0])}"/>
            <c:set var="img" value="${fn:substring(imageList[0], 2, length-1)}"/>

            <div class="place_content">
                <div class="place_info">
                    <h3>${placeList.placename}</h3>
                    <p>${placeList.placeaddress}</p>
                    <a href="<c:url value="/place/detail?placeidx=${placeList.placeidx}"/>">더 알아보기</a>
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

<!-- 지도[s] -->
<div id="map" style="width: 100%; height: 500px; margin-top: 50px"></div>

<script type="text/javascript">
    $(function() {
        initMap();
    });
    function initMap() {
        const areaArr = [];  // 지역을 담는 배열 ( 지역명/위도경도 )
        <c:forEach items="${placePilatesList}" var="placeList" varStatus="status">
            areaArr.push(
                /*지역구 이름*/			               /*위도*/					/*경도*/
                {location : '${placeList.placename}' , lat : ${placeList.latitude} , lng : ${placeList.longitude}}  // 중심좌표
        );
        </c:forEach>
        console.log(areaArr[0])
        let markers = []; // 마커 정보를 담는 배열
        let infoWindows = []; // 정보창을 담는 배열
        var map = new naver.maps.Map('map', {
            center: new naver.maps.LatLng(37.55528086061827, 126.93683578593966), //지도 시작 지점
            zoom: 15
        });
        for (var i = 0; i < areaArr.length; i++) {
            // 지역을 담은 배열의 길이만큼 for문으로 마커와 정보창을 채워주자 !
            var marker = new naver.maps.Marker({
                map: map,
                title: areaArr[i].location, // 지역구 이름
                position: new naver.maps.LatLng(areaArr[i].lat , areaArr[i].lng),
                icon: {
                    content: [
                        '<div style="padding-top:5px;padding-bottom:5px;padding-left:5px;padding-right:5px;">' +
                        '<div> <img src="/gym/images/icon/muscles.png" style="width:60px; height:60px;"></div>' +
                        '</div>'
                    ].join(''),
                    size: new naver.maps.Size(38, 58),
                    anchor: new naver.maps.Point(19, 58),
                },// 지역구의 위도 경도 넣기
            });
            /* 정보창 */
            var infoWindow = new naver.maps.InfoWindow({
                content: '<div style="width:200px;text-align:center;padding:10px;"><b>' + areaArr[i].location + '</b></div>'
            }); // 클릭했을 때 띄워줄 정보 HTML 작성
            markers.push(marker); // 생성한 마커를 배열에 담는다.
            infoWindows.push(infoWindow); // 생성한 정보창을 배열에 담는다.
        }
        function getClickHandler(seq) {
            return function(e) {  // 마커를 클릭하는 부분
                var marker = markers[seq], // 클릭한 마커의 시퀀스로 찾는다.
                    infoWindow = infoWindows[seq]; // 클릭한 마커의 시퀀스로 찾는다
                if (infoWindow.getMap()) {
                    infoWindow.close();
                } else {
                    infoWindow.open(map, marker); // 표출
                }
            }
        }
        for (var i=0, ii=markers.length; i<ii; i++) {
            console.log(markers[i] , getClickHandler(i));
            naver.maps.Event.addListener(markers[i], 'click', getClickHandler(i)); // 클릭한 마커 핸들러
        }
    }
</script>


<!-- 지도[e] -->


<!-- footer -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>