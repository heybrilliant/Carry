<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <div class="contents container_fix">

      <!-- Nav -->
      <div class="post_back">
        <a class="post_back_link" href="<c:url value="/community/boardlist"/>">
          <img class="arrow_img" src="/gym/images/icon/arrow.png"> 글 목록
        </a>
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

      <!-- Profile -->
      <div class="space_between">
        <div class="btn_right">
          <button class="title_btn" type="button" onclick="">${boardDetail.boardcategory}</button>
          <h2 class="board_title"><a href="#">${boardDetail.postname}</a></h2>
        </div>
        <div class="profile">
          <div class="profile_img">
            <img alt="" src="/gym/images/icon/profile.png">
            <div id="nickname">${boardDetail.postnick}</div>
          </div>
          <div class="profile_left">
          	<fmt:formatDate var="dateFmt" pattern="yyyy-MM-dd" value="${boardDetail.postdate}"/>
            <div id="write_date"> <c:out value="${dateFmt}"/> </div>
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
          <div class="like_btn">
          	<img class="post_icon" src="/gym/images/icon/heart.png">
          	<span>2</span>
          </div>
          <div class="comm_length">
          	<img class="post_icon" src="/gym/images/icon/speech-bubble.png">
          	<span><c:out value="${commCount}"/></span>
          </div>
        </div>
      </div>
      <!-- /Content -->

      <!-- Comment -->
      <c:forEach items="${commList}" var="commList" >
	      <div class="comment_wrap">
	         <div class="profile">
	           	<div class="profile_img">
	            	<img alt="" src="/gym/images/icon/profile2.png">
	          	</div>
	          	<div class="profile_left">
		            <div id="nickname">${commList.commentnick}</div>
		            <div id="write_date"> <fmt:formatDate value="${commList.commentdate}" pattern="yyyy-MM-dd"/></div>
	          	</div>
	         </div>
	         <div class="text_wrap">
		     	<div class="comment_text">
		        	<p>${commList.commentcontent }</p>
		     	</div>
	         </div>
	      </div>
      </c:forEach>
      <!-- /Comment -->

      <!-- Comment Input -->
      <div class="comment_input_wrap">
        <div class="search_wrap search_wrap_6">
          <div class="search_box">
              <input type="text" class="input" placeholder="댓글을 작성해주세요.">
              <label name="btn_input">
              	<input type="submit" name="btn_input" class="btn">
              	<img src="/gym/images/icon/input_icon.png" alt="icon">
              </label>
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
	// 댓글 등록하기(Ajax)
	function fn_comment(code){
	    
	    $.ajax({
	        type:'POST',
	        url : "<c:url value='/board/addComment.do'/>",
	        data:$("#commentForm").serialize(),
	        success : function(data){
	            if(data=="success")
	            {
	                getCommentList();
	                $("#comment").val("");
	            }
	        },
	        error:function(request,status,error){
	            //alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	       }
	        
	    });
	}
</script>
	
	
<script>
	// 게시물 삭제
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
	

