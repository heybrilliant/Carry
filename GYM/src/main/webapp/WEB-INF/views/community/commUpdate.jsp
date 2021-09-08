<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Community</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/community/commWrite.css">
<script src="/gym/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	<!-- Contents -->
    <div class="community_write container container_fix">
        <h1 class="page_title">
            COMMUNITY
        </h1>
        <div class="board_write">
            <form method="post" id="updateForm">
                <div class="write_form">
                    <div class="category">
                        <span class="left">분류</span>
                        <select class="category_info" name="boardcategory" value="${update.boardcategory}">
                            <option value="소통">소통</option>
                            <option value="질문/답변">질문/답변</option>
                        </select>
                    </div>
                    <div class="name">
                        <span class="left">닉네임</span>
                        <span class="name_info"><input type="text" name="postnick" value="${update.postnick}" readonly></span>
                    </div>
                    <div class="title">
                        <span class="left">제목</span>
                        <span><input type="text" name="postname" value="${update.postname}" required></span>
                    </div>
                    <div class="content">
                        <span class="left">내용</span>
                        <span class="editor">
                            <textarea class="form-control" name="postcontent" id="postcontent" value="${update.postcontent}"></textarea>
                        </span>
                    </div>
                </div>
                <div class="btn">
                    <input type="submit" value="수정 완료" id="updateBtn">
                    <a href="javascript:window.history.back();">취소</a>
                </div>
                <input type="hidden" id="memidx" name="memidx" value="${loginSession.memidx}">
            </form>

        </div>
    </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	<script>
       var oEditors = [];
		
       nhn.husky.EZCreator.createInIFrame({
           oAppRef: oEditors,
           elPlaceHolder: "postcontent",
           sSkinURI: "/gym/smarteditor2/SmartEditor2Skin.html",
           fOnAppLoad : function(){
        	   // 입력된 내용 가져오기
               oEditors.getById["postcontent"].exec("PASTE_HTML", ['${update.postcontent}']); 
           },
           fCreator: "createSEditor2"
       });
       
       
       // 전송 버튼 클릭 이벤트
       $("#updateBtn").click(function(){
	    	// id가 contents인 textarea에 에디터에서 대입
	    	oEditors.getById["postcontent"].exec("UPDATE_CONTENTS_FIELD", []);
	     	
	     	// form submit
	     	$("#updateForm").submit();
       })
	</script>
	
    
    <script>
    	// selected 값 가져오기
		$(document).ready(function(){
			var s_value = '${update.boardcategory}';
			
			$(".category_info").val(s_value).prop("selected", true);
		});
	</script>
