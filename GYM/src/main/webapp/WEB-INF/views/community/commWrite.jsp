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
            <form>
                <div class="write_form">
                    <div class="category">
                        <span class="left">분류</span>
                        <select class="category_info">
                            <option value="소통">소통</option>
                            <option value="질문/답변">질문/답변</option>
                        </select>
                    </div>
                    <div class="name">
                        <span class="left">작성자</span>
                        <span class="name_info"><input type="text" name="name" value=""></span>
                    </div>
                    <div class="title">
                        <span class="left">제목</span>
                        <span><input type="text" name="title"></span>
                    </div>
                    <div class="content">
                        <span class="left">내용</span>
                        <span>
                            <textarea class="form-control" name="contents" id="contents"></textarea>
                        </span>
                    </div>
                </div>
                <div class="btn">
                    <input type="submit" value="작성 완료">
                    <a href="#">취소</a>
                </div>
            </form>

        </div>
    </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	<script>
        var oEditors = [];

        nhn.husky.EZCreator.createInIFrame({
            oAppRef: oEditors,
            elPlaceHolder: "contents",
            sSkinURI: "/gym/smarteditor2/SmartEditor2Skin.html",
            fCreator: "createSEditor2"
        });
    </script>
