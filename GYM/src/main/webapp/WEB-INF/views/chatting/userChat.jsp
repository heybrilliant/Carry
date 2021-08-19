<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1:1Chatting</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/user_chat.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	<div id="chatwarp">
        <nav class="chat_ul">
            <div class="chatid">
                <h3>접속자 아이디</h3>
            </div>
            <ul>
                <li><span  style="margin-left: 350px; font-size: 30px;">GymCarry</span></li>
            </ul>
        </nav>


        <div id="chatlist_wrap">
            <!-- 채팅방 리스트 시작 -->

            <div class="chatlist">
                <a href="#">
                    <div class="float_left">
                        <img src="<c:url value="/images/프로필사진.png"/>">
                    </div>
                    <div class="float_left chat_name">
                        <h3>김자바</h3>
                    </div>
                    <div class="chat_title">
                        <span>핏블리짐</span>
                    </div>
                    <div class="chat_content">
                        <span>네 안녕하세요. pt문의좀 하려는데요</span>
                    </div>
                    <div class="chat_date">
                        <span>10:56AM</span>
                    </div>
                </a>

            </div>

            <!-- 채팅방 리스트 끝 -->

            <!-- 임의로 하나더 만듬! 나중에필요없음! -->
            <div class="chatlist">
                <a href="#">
                    <div class="float_left">
                        <img src="<c:url value="/images/프로필사진.png"/>">
                    </div>
                    <div class="float_left chat_name">
                        <h3>홍길동</h3>
                    </div>
                    <div class="chat_title">
                        <span>라이프휘트니스</span>
                    </div>
                    <div class="chat_content">
                        <span>저기요~ 문의좀요</span>
                    </div>
                    <div class="chat_date">
                        <span>12:46PM</span>
                    </div>
                </a>
            </div>


        </div>

        <div id="chatcontent_warp">
            <div class="not_message">
                <img src="<c:url value="/images/chatting_icon.png"/>" style="width: 80px;">
                <h3>채팅할 상대를 선택해주세요</h3>
            </div>
        </div>
    </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	
</body>
</html>