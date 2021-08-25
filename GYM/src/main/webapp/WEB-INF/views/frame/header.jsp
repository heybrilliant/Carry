<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="header">
	<div class="logo">
		<a href="<c:url value="/index"/>">GymCarry</a>
	</div>
	<nav class="nav">
		<ul>
			<li><a href="#">ABOUT</a></li>
			<li><a href="<c:url value="/chatting/carryLists"/>">1:1MATCHING</a></li>
			<li><a href="<c:url value="/place/list"/>">PLACE</a></li>
			<li><a href="<c:url value="/community/community"/>">COMMUNITY</a></li>
			<li><a href="<c:url value="/mypage/mypage"/>">MY BODY</a></li>
		</ul>
	</nav>
	<div class="sub_nav">
		<div class="chatting">
			<a href="<c:url value="/chatting/chatList"/>">
			<img src="<c:url value="/images/icon/chatting_icon.png"/>" alt="chatting">
			</a>
		</div>
		<c:if test="${member eq null}">
		<a href="<c:url value="/member/login"/>" class="login"> LOGIN </a>
		</c:if>
		<c:if test="${member ne null}">
		<a href="<c:url value="/member/logOut"/>" class="login"> LOGOUT </a>
		</c:if>
	</div>
</header>