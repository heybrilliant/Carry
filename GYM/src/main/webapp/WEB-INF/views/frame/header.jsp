<%@page import="javafx.scene.control.Alert"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 로그아웃 및 마이페이지 분리를 위한 은경이 만든 가라헤더 -->
<!-- 로그아웃 및 마이페이지 분리를 위한 은경이 만든 가라헤더 -->
<!-- 로그아웃 및 마이페이지 분리를 위한 은경이 만든 가라헤더 -->

<header class="header">
	<div class="logo">
		<a href="<c:url value="/index"/>">GymCarry</a>
	</div>
	<nav class="nav">
		<ul>
			<li><a href="#">ABOUT</a></li>
			<li><a href="<c:url value="/carry/allList"/>">1:1MATCHING</a></li>
			<li><a href="<c:url value="/place/all"/>">PLACE</a></li>
			<li><a href="<c:url value="/community/boardlist"/>">COMMUNITY</a></li>
			<li><a href="<c:url value="/mypage/mypage"/>">MY BODY</a></li>
			<%-- <c:choose>
				<c:when test="${session eq carry}">
					<li><a href="<c:url value="/mypage/carrymypage/carrymypage"/>">MY
							BODY</a></li>
				</c:when>
				<c:when test="${session eq member}">
					<li><a value="MY BODY" href="/mypage/mypage"/>MY BODY</a></li>
				</c:when>
				<c:when test="${session eq null}">
					<li><a value="MY BODY" href="/member/login"/>MY BODY</a></li>
				</c:when>
			</c:choose> --%>
		</ul>
	</nav>
	<div class="sub_nav">
		<div class="chatting">
			<a href="<c:url value="/chatting/chatList"/>"> <img
				src="<c:url value="/images/icon/chatting_icon.png"/>" alt="chatting">
			</a>
		</div>
		<c:if test="${loginSession eq null}">
		<a href="<c:url value="/member/login"/>" class="login"> LOGIN </a>
		</c:if>
		<c:if test="${loginSession ne null}">
		<a href="<c:url value="/member/logOut"/>" class="login"> LOGOUT </a>
		</c:if>
	</div>
</header>