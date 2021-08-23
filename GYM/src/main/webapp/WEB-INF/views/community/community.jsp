<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/css/community/community.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

    <!-- Contents -->
    <div class="contents_main">
        <div class="contents">
            <h1 class="title"><a href="#">COMMUNITY</a></h1>
            <nav class="community_nav">
                <ul>
                    <li>
                        <a class="menulink1" href="#">전체 </a>
                    </li>
                    <li>
                        <a class="menulink2" href="#">소통</a>
                    </li>
                    <li>
                        <a class="menulink3" href="#">질문답변</a>
                    </li>

                    <a class="board_write" href="#"><img class="write_icon" src="/images/icon/edit.png"></a>

                    <!-- 정렬을 위해 왼쪽에 버튼 숨겨놓은 것 -->
                    <button class="board_write2" type="button" onclick=""><img class="write_icon"
                                                                               src="/images/icon/edit.png"></button>
                </ul>
            </nav>
            <div class="card_main">
                <div class="card">
                    <div class="board_sidebar">
                        <img class="profile_image" src="/images/icon/profile.png" />
                        <div class="nickname">닉네임</div>

                    </div>
                    <div class="board_main">
                        <button class="title_btn" type="button" onclick="">소통</button>
                        <h2 class="board_title"><a href="#">글제목입니다.</h2></a>
                        <p class="board_post"><a href="#"> 신촌 헬스장 추천해주세요. 신촌 헬스장 추천해주세요. 신촌 헬스장 추천해주세요. 신촌 헬스장 추천해주세요.신촌 헬스장 추천해주세요.
                            신촌 헬스장
                            추천해주세요.
                            신촌 헬스장 추천해주세요. </p></a>
                        <div class="board_bottom">
                            <div class="write_date">2021.08.11 17:18:23 PM</div>
                            <ul class="board_btn">
                                <li><a href="#"><img class="board_icon" src="/images/icon/heart.png">2</a></li>
                                <li>
                                    <a href="#"><img class="board_icon" src="/images/icon/speech-bubble.png">15</a>
                                </li>
                            </ul>
                        </div>
                    </div>


                </div>

            </div>
        </div>
    </div>
    </div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	

