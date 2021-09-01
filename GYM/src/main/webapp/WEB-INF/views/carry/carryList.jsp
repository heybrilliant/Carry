 	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CarryList</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/carry/carryList.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	<!-- Contents -->
  <div class="content_main">
    <div class="content">
      <h1 class="title">당신과 어울리는 캐리는 ?</h1>
      <nav class="community_nav">
        <ul>
          <li>
            <input type="button" value="지금 바로 1:1 매치하러가기" onclick="location.href='<c:url value="/survey/servey"/>'">
          </li>
        </ul>
        <div class="caary_navfont">
          <span>찜순 / 가격순</span>
        </div>
      </nav>
      <div class="card_main">
      <c:forEach items="${carryList}" var="list">
        <div class="card">
          <div class="board_sidebar">
            <img class="profile_image" src="<c:url value="/images/icon/profile.png"/>" />
            <div class="nickname">캐리사진</div>
			<input type="hidden" value="${sv1}" name="sv1">
			<input type="hidden" value="${sv4}" name="sv4">
          </div>
          <div class="board_main">
            <button class="title_btn" type="button" onclick="">${list.crnick}<span>Carry</span></button>
            <div class="carry_price">
              <span>1회 코칭 가격</span>
              <h3>${list.proprice1}원</h3>
            </div>
            <div class="board_title">
              <span>${list.placename}</span>
              <span class="address_font">서울특별시 마포구</span>
            </div>
            <div class="btnflex">
              <div class="board_post">
                <span class="pt_nopt">경력사항</span><span class="pt_nopt2"><img src="<c:url value="/images/icon/movie.png"/>">비대면 PT 가능</span>
                <ul>
                  <li>어쩌고</li>
                  <li>저쩌고</li>
                  <li>저쩌고</li>
                </ul>
              </div>
              <div class="board_bottom">
                <ul class="board_btn">
                  <li><input type="button" value="1:1문의" class="inquiry_btn" onclick="location.href='<c:url value="/chatting/chatInquire?cridx=${list.cridx}&memidx=${member.memidx}"/>'"></li>
                  <li>
                    <input type="button" value="더 알아보기" class="details_btn">
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
		</c:forEach>	

      </div>
    </div>
  </div>
  <!-- Contents end -->
	
	
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>