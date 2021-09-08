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
	53233
	
  <!-- Contents -->
  <div class="contents_wrap">
    <div class="contents">

      <!-- Nav -->
      <div class="post_back">
        <a class="post_back_link" href="<c:url value="/community/boardlist"/>">
          <img class="arrow_img" src="/gym/images/icon/arrow.png"> 글 목록
        </a>

      </div>

      <!-- Profile -->
      <div class="space_between">
        <div class="btn_right">
          <button class="title_btn" type="button" onclick="">${boardDetail.boardcategory}</button>
          <h2 class="board_title"><a href="#">${boardDetail.postname}</a></h2>
        </div>
        <div class="profile">
          <div class="profile_img">
            <img alt="" src="/gym/images/icon/profile.png">
          </div>
          <div class="profile_left">
            <div id="nickname">${boardDetail.postnick}</div>
            <div id="write_date"> ${boardDetail.postdate} </div>
            <div class="content_right">
              <ul>
                <li>
                  <a class="con_edit" href="<c:url value="/community/update?postidx=${boardDetail.postidx }"/>">수정 </a>
                </li>
                <li>
                  <a class="con_delete">삭제</a>
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
          ${boardDetail.postcontent}
        </div>
      </div>
      <div class="postbtn_wrap">
        <div class="post_btn">
          <a href="#"><img class="post_icon" src="/gym/images/icon/heart.png">2</a>
          <a href="#"><img class="post_icon" src="/gym/images/icon/speech-bubble.png">15</a>
        </div>
      </div>
      <!-- /Content -->

      <!-- Comment -->
      <div class="comment_wrap">
        <div class="profile">
          <div class="profile_img">
            <img alt="" src="/gym/images/icon/profile2.png">
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
	<script>
		$(function(){
			
			var form = $("<form></form>");
			
			$('.con_delete').on("click", function(){
				
				var deletePush = confirm("해당 게시글을 삭제 하시겠습니까?\n\n삭제 후엔 복구가 불가능합니다.")
				
				console.log(deletePush);
				if(deletePush){
					/* form.attr("action", '<c:url value="community/delete?postidx=${boardDetail.postidx}"/>');
					form.attr("method", "get");
					form.submit(); */
					location.href = '<c:url value="/community/delete?postidx=${boardDetail.postidx}"/>';
				}
				
			});
		})
	</script>
	

