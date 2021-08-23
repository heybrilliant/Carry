<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/community/postContent.css">
<script src="/gym/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	
  <!-- Contents -->
  <div class="contents_wrap">
    <div class="contents">

      <!-- Nav -->
      <div class="post_back">
        <a class="post_back_link" href="#">
          <img class="arrow_img" src="image/icon/arrow.png"> 글 목록
        </a>

      </div>

      <!-- Profile -->
      <div class="space_between">
        <div class="btn_right">
          <button class="title_btn" type="button" onclick="">소통</button>
          <h2 class="board_title"><a href="#">서강대 칼만두 맛집 추천 합니다 !! </h2></a>
        </div>
        <div class="profile">
          <div class="profile_img">
            <img alt="" src="image/icon/profile.png">
          </div>
          <div class="profile_left">
            <div id="nickname">닉네임</div>
            <div id="write_date"> 2021.08.11 17:18:23 PM </div>
            <div class="content_right">
              <ul>
                <li>
                  <a class="con_edit" href="#">수정 </a>
                </li>
                <li>
                  <a class="con_delete" href="#">삭제</a>
                </li>
              </ul>
            </div>
          </div>


        </div>

      </div>
      <!-- /Profile -->
      <!-- /Nav-->

      <!-- Content -->
      <div class="content_wrap">


        <div class="post_content">
          <p class="post">제가 오늘 서강대 건너편 옥정이라는 평양식 만두국집 다녀왔는데요, 너무 맛있네요. 밥도 무료로 주세요. 대신 점심 장사라 2시까지만 합니다. 웨이팅도 있는데 금방
            빠져요. 인생
            칼만두집을 찾았네요. 이열치열 지대로 느끼고 싶으신 분들 다녀오세요. 입 힐링합니다^^</p>
        </div>
      </div>
      <div class="postbtn_wrap">
        <div class="post_btn">
          <a href="#"><img class="post_icon" src="image/icon/heart.png">2</a>
          <a href="#"><img class="post_icon" src="image/icon/speech-bubble.png">15</a>
        </div>
      </div>
      <!-- /Content -->

      <!-- Comment -->
      <div class="comment_wrap">
        <div class="profile">
          <div class="profile_img">
            <img alt="" src="image/icon/profile2.png">
          </div>
          <div class="profile_left">
            <div id="nickname">입맛고급</div>
            <div id="write_date"> 2021.08.11 17:18:23 PM </div>
          </div>
          <div class="text_wrap">
            <div class="comment_text">
              <p>오우 맛집 찾아 여기까지 왔네요ㅎ 감사합니다.</p>
            </div>
          </div>

        </div>
      </div>
      <!-- /Comment -->

      <!-- Comment Input -->
      <div class="comment_input_wrap">
        <div class="search_wrap search_wrap_6">
          <div class="search_box">
            <input type="text" class="input" placeholder="댓글을 작성해주세요.">
            <div class="btn">
              <p class="btn_input">입력</p>
            </div>
          </div>
        </div>
      </div>
      <!-- /Comment Input -->

    </div>
    <!-- /Content -->

  </div>
  <!-- /Contents -->
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	

