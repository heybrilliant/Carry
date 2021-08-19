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
			<li><a href="#">1:1MATCHING</a></li>
			<li><a href="#">PLACE</a></li>
			<li><a href="#">COMMUNITY</a></li>
			<li><a href="#">MY BODY</a></li>
		</ul>
	</nav>
	<div class="sub_nav">
		<div class="chatting">
			<a href="<c:url value="chatting/chat"/>">
			<img src="<c:url value="/images/chatting_icon.png"/>" alt="chatting">
			</a>
		</div>
		<a href="#" class="login"> LOGIN </a>
	</div>
</header>