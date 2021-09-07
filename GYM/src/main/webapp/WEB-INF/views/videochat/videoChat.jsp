<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>VIDEO CHAT TEST</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/videochat/videoCaht.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<h1>VIDEO CHAT TEST with WebRTC</h1>

	<div id="videos">
		<video id="localVideo" autoplay muted playsinline></video>
		<video id="remoteVideo" autoplay playsinline></video>
	</div>

	<!-- This file is automatically added/served when running "node index.js". -->
	<script src="/socket.io/socket.io.js"></script>
	<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
	<script src="/gym/js/videoChat.js"></script>


	<!-- Contents end -->


	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>