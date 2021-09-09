<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title>Community</title>


<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>

<link href="${pageContext.request.contextPath}/css/community/community.css" rel="stylesheet"/>


</head>

<c:url var="getBoardList" value="/community/boardList/">
    <c:param name="page" value="${pagination.page}"/>
    <c:param name="range" value="${pagination.range}"/>

</c:url>


<body>
<!-- header -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>

<!-- Contents -->
<div class="contents_main">
    <div class="contents">
        <h1 class="title">
            <a href="<c:url value="/community/boardList"/>">COMMUNITY</a>
        </h1>

        <!-- 카테고리 영역 -->
        <nav class="community_nav">
            <ul>
                <li>
                    <a href="<c:url value="/community/boardList"/>">전체</a>
                </li>
                <li>
                    <a class="menulink2" href="#">소통</a>
                </li>
                <li>
                    <a class="menulink3" href="#">질문답변</a>
                </li>

                <a class="board_write" href="<c:url value="/community/write"/>">
                    <img class="write_icon" img src="<c:url value="/images/icon/edit.png"/>" alt="img"></a>

                <!-- 정렬을 위해 왼쪽에 버튼 숨겨놓은 것 -->
                <button class="board_write2" type="button" onclick="">
                    <img class="write_icon" src="/gym/images/icon/edit.png"></button>
            </ul>
        </nav>
        <!-- /카테고리 영역 -->

        <!-- 게시판 출력 영역 -->
        <div class="card_main">
            <c:forEach items="${boardList}" var="list">
                <div class="card">
                    <div class="board_sidebar">
                        <img class="profile_image"
                             img src="<c:url value="/images/icon/profile2.png"/>" alt="img">
                        <div class="nickname">${list.postnick}</div>

                    </div>
                    <div class="board_main">
                        <button class="title_btn" type="button" onclick="">${list.boardcategory}</button>
                        <h2 class="board_title">
                            <a href="<c:url value="/community/postContent"/>">${list.postname}</a>
                        </h2>
                        <p class="board_post">
                            <a href="<c:url value="/community/postContent"/>">
                                    ${list.postcontent}</a>
                        </p>
                            <%--날짜, 조회수--%>
                        <div class="board_bottom">
                            <div class="write_date">

                                <li>
                                    <img class="left_board_icon" img src="<c:url value="/images/icon/time.png"/>"
                                         alt="img">
                                        <%--시간 데이터 포맷 변경--%>
                                    <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${list.postdate}"/>
                                </li>
                                <li>
                                    <img class="left_board_icon2"
                                         img src="<c:url value="/images/icon/board.png"/>" alt="img">
                                        ${list.postview}
                                </li>
                            </div>
                            <ul class="board_btn">

                                <li>
                                    <a href="#">
                                        <img class="board_icon" img src="<c:url value="/images/icon/heart.png"/>"
                                             alt="img">2
                                    </a>
                                </li>
                                <li>
                                    <a href="#"><img class="board_icon" img
                                                     src="<c:url value="/images/icon/speech-bubble.png"/>" alt="img">15</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <!-- /게시판 출력 영역 -->

        <%--pagination--%>
        <nav aria-label="Page navigation example">
            <ul class="pagination pagination-sm justify-content-center">

                <c:if test="${pagination.prev}">
                    <li class="page-item">
                        <a class="page-link" href="#"
                           onclick="fn_prev('${pagination.page}','${pagination.range}','${pagination.range}','${pagination.rangeSize}')">
                            <span>&laquo;</span>
                        </a>
                    </li>
                </c:if>

                <c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
                    </li>
                    <li class="page-item
            <c:out value="${pagination.page == idx ? 'active' :''}"/> ">
                        <a class="page-link" href="#"
                           onclick="fn_pagination('${idx}','${pagination.range}','${pagination.rangeSize}')">${idx}</a>
                    </li>
                </c:forEach>

                <c:if test="${pagination.next}">
                    <li class="page-item">
                        <a class="page-link" href="#"
                                             onclick="fn_next('${pagination.range}','${pagination.range}','${pagination.rangeSize}')">
                        <span>&raquo;</span>
                    </a>
                    </li>
                </c:if>
            </ul>
        </nav>
        <%-- /pagination--%>
    </div>

</div>


<!-- Contents end -->


    <script src="http://code.jquery.com/jquery-latest.js"></script>


<script>
    // 카테고리 버튼
    $(function(){
        $("button").on('click',function(){
            var kind = $(this).val();  //버튼이 클릭 되었을 때 그 버튼의 value를 var kind로 가져와서
            $.ajax({
                url : "<c:url value='/community/boardList'/>", // 이 주소로
                type : "post", // 포스트 방식으로 보내는데
                cache: false,
                headers: {"cache-control":"no-cache", "pragma": "no-cache"},
                data : {"kind" : kind}, // kind를 kind로 명명하여 보내겠다
                success : function(data){
                    console.log(data);

                    $('body').html(data); //성공할시에 body부분에 data라는 html문장들을 다 적용시키겠다
                },
                error : function(data){
                    alert('error');

                }//error
            })//ajax
        });//click
    });//ready



    // 페이징 처리
    // 이전 버튼 이벤트
    function fn_prev(page, range, rangeSize) {
        var page = ((range - 2) * rangeSize) + 1;
        var range = range - 1;

        var url = "${pageContext.request.contextPath}/community/boardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }

    //페이지 번호 클릭
    function fn_pagination(page, range, rangeSize, searchType, keyword) {
        var url = "${pageContext.request.contextPath}/community/boardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }

    //다음 버튼 이벤트
    function fn_next(page, range, rangeSize) {
        var page = parseInt((range * rangeSize)) + 1;
        var range = parseInt(range) + 1;

        var url = "${pageContext.request.contextPath}/community/boardList";
        url = url + "?page=" + page;
        url = url + "&range=" + range;

        location.href = url;
    }


</script>

<!-- footer -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
	

