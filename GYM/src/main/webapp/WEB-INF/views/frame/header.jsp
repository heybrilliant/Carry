<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="../css/style.css">
  <link rel="stylesheet" href="../css/index.css">
  <link rel="stylesheet" href="../css/swiper.css">
  <script src="http://code.jquery.com/jquery-latest.js"></script>
  <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
  <script src="../js/index.js"></script>
  <!-- Initialize Swiper -->

  <title>GymCarry</title>
</head>

<body>
  <div class="wrap">
    <!-- Header -->
    <header class="header">
      <div class="logo">
        <a href="#">GymCarry</a>
      </div>
      <nav class="nav"> 
      <nav>
		
	</nav>
        <ul>
          <li>
            <a href="#">ABOUT</a>
          </li>
          <li>
            <a href="#">1:1매칭</a>
          </li>
          <li>
            <a href="#">운동시설</a>
          </li>
          <li>
            <a href="#">커뮤니티</a>
          </li>
          <li>
           	<a href="<c:url value='/mypage/mypage '/>">마이페이지</a>
          </li>
        </ul>
      </nav>
      <div class="sub_nav">
        <div class="chatting">
          <img src="../image/icon/chatting_icon.png" alt="chatting">
        </div>
        <a href="#" class="login">
          로그인
        </a>
      </div>
    </header>
    <!-- Header End -->

</body>

</html>