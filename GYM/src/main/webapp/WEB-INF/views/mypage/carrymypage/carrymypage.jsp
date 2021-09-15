<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>GYM CARRY : 캐리 마이페이지</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/mypage/carrymypage.css">

<!-- 캘린더 -->
<!-- jquery CDN -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- fullcalendar CDN -->
<link
	href='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.css'
	rel='stylesheet' />
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/main.min.js'></script>
<!-- fullcalendar 언어 CDN -->
<script
	src='https://cdn.jsdelivr.net/npm/fullcalendar@5.8.0/locales-all.min.js'></script>

</head>
<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<div class="container">
		<div class="main">
			<!-- <p>바탕색은 구분을 위한 임시배경색입니다</p> -->
			<!-- <img src="/images/icon/profile.png"><br> -->
			<img src="<c:url value="/images/icon/profile.png"/>" class="profile" onclick="#">
			<div class="nameline">
				<!-- 정렬을 위해 왼쪽에 숨겨둘 것 -->
				<button class="edit1" type="button" onclick>
				</button>
				<!-- 여기까지 -->
				<h3 class="title">캐리 이름</h3>
				<a href="modifycarrybasicinfo.html">
				<img src="<c:url value="/images/icon/edit.png"/>" class="edit2">
					
				</a>
			</div>
			<!-- calendar 태그 -->
			<div id="calendar_container">
				<div id="calendar"></div>
			</div>

		</div>


		<div class="second-line">
			<div class="modi-list">
				<h3>My Page</h3>
				<ul>
					<li><a href="<c:url value="/mypage/carrymypage/modify"/>">기본 정보 수정</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
					<li><a href="<c:url value="/mypage/carrymypage/carrymodify"/>">캐리 정보 수정</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
					<li><a href="<c:url value="/mypage/carrymypage/mymember"/>">내 회원 리스트</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
				</ul>
			</div>

			<div class="today-schedule">
				<li>
					<h3>오늘의 일정</h3>
					<a class="insert" href="#"><img src="<c:url value="/images/icon/edit.png"/>"></a>
				</li>
			</div>
		</div>
	</div>
	<!-- Contents end -->


	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>


<script>
	(function() {
		$(function() {
			// calendar element 취득
			var calendarEl = $('#calendar')[0];
			// full-calendar 생성하기
			var calendar = new FullCalendar.Calendar(calendarEl, {
				height : '700px', // calendar 높이 설정
				expandRows : true, // 화면에 맞게 높이 재설정
				slotMinTime : '08:00', // Day 캘린더에서 시작 시간
				slotMaxTime : '20:00', // Day 캘린더에서 종료 시간
				// 해더에 표시할 툴바
				headerToolbar : {
					left : 'prev,next today',
					center : 'title',
					right : 'dayGridMonth,timeGridWeek,timeGridDay,listWeek'
				},
				initialView : 'dayGridMonth', // 초기 로드 될때 보이는 캘린더 화면(기본 설정: 달)
				navLinks : true, // 날짜를 선택하면 Day 캘린더나 Week 캘린더로 링크
				editable : true, // 수정 가능?
				selectable : true, // 달력 일자 드래그 설정가능
				nowIndicator : true, // 현재 시간 마크
				dayMaxEvents : true, // 이벤트가 오버되면 높이 제한 (+ 몇 개식으로 표현)
				locale : 'ko', // 한국어 설정
				eventAdd : function(obj) { // 이벤트가 추가되면 발생하는 이벤트
					console.log(obj);
				},
				eventChange : function(obj) { // 이벤트가 수정되면 발생하는 이벤트
					console.log(obj);
				},
				eventRemove : function(obj) { // 이벤트가 삭제되면 발생하는 이벤트
					console.log(obj);
				},
				select : function(arg) { // 캘린더에서 드래그로 이벤트를 생성할 수 있다.
					var title = prompt('Event Title:');
					if (title) {
						calendar.addEvent({
							title : title,
							start : arg.start,
							end : arg.end,
							allDay : arg.allDay
						})
					}
					calendar.unselect()
				}
			// 이벤트 

			});
			// 캘린더 랜더링
			calendar.render();
		});
	})();
</script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
		var calendarEl = document.getElementById('fullcalendar2_wannausing');
		var calendar = new FullCalendar.Calendar(calendarEl, {
			initialView : 'dayGridMonth'
		});
		calendar.render();
	});
</script>
