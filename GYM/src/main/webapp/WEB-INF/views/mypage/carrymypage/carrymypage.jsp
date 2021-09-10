<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
<meta charset="UTF-8">
<!-- 화면 해상도에 따라 글자 크기 대응(모바일 대응) -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">

<script src=" http://code.jquery.com/jquery-latest.js">
	
</script>
<script src="js/index.js"></script>

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

</head>

<style>
/* body 스타일 */
html, body {
	overflow: scroll;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

/* 캘린더 위의 해더 스타일(날짜가 있는 부분) */
.fc-header-toolbar {
	padding-top: 1em;
	padding-left: 1em;
	padding-right: 1em;
}

#container {
	display: flex;
	flex-wrap: wrap;
	width: 70%;
	margin: 140px auto;
	justify-content: center;
	gap: 20px;
}

.main {
	padding-top: 20px;
	text-align: center;
	width: 1200px;
	min-width: 500px;
	height: auto;
	background-color: snow;
}

#container>.main>img {
	width: 200px;
	height: 200px;
	margin-top: 20px;
}

#container>.main>.nameline {
	list-style-type: none;
	text-align: center;
	margin: 0;
	padding: 0;
	vertical-align: middle;
}

.edit1 {
	width: 20px;
	height: 20px;
	background-color: transparent;
	border: none;
	float: left;
	visibility: hidden;
}

#container>.main>.nameline>a>#edit2 {
	width: 20px;
	height: 20px;
	margin-left: 5px;
}

#calendar {
	padding: 0 60px 50px;
}

#container>.main>#calendar {
	width: 80%;
	margin-top: 20px;
	margin-bottom: 50px;
	height: auto;
	display: inline-block;
	text-align: center;
	justify-content: center;
}

#container>.mypage .todaylist {
	display: inline-flex;
}

.second-line {
	display: flex;
	min-width: 500px;
	width: 1200px;
	flex-wrap: nowrap;
	gap: 20px;
}

.title {
	font-size: 20px;
	margin: 20px auto;
	display: inline-block;
}

.modi-list {
	background-color: lavender;
	width: 35%;
	height: auto;
	padding: 10px;
}

.modi-list>h3 {
	margin-bottom: 10px;
}

.today-schedule {
	background-color: honeydew;
	width: 65%;
	height: auto;
	padding: 10px;
}

.today-schedule>li>h3 {
	display: inline-block;
}

.today-schedule>li>.insert>img {
	width: 20px;
	height: 20px;
	vertical-align: middle;
	display: flex;
	float: right;
}
</style>

<body>
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<div id="container">
		<div class="main">
			<p>바탕색은 구분을 위한 임시배경색입니다</p>
			<img src="/images/icon/profile.png"><br>
			<div class="nameline">
				<!-- 정렬을 위해 왼쪽에 숨겨둘 것 -->
				<button class="edit1" type="button" onclick>
					<img id="edit1" src="image/icon/edit.png">
				</button>
				<!-- 여기까지 -->
				<h3 class="title">캐리 이름</h3>
				<a href="modifycarrybasicinfo.html"> <img id="edit2"
					src="image/icon/edit.png">
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
					<li><a href="modifycarrybasicinfo.html">기본 정보 수정</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
					<li><a href="modifycarryinfo.html">캐리 정보 수정</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
					<li><a href="carry_mymemberlist.html">내 회원 리스트</a> <!-- <a href="<c:url value="/"/>"> -->
					</li>
					<br>
				</ul>
			</div>

			<div class="today-schedule">
				<li>
					<h3>오늘의 일정</h3> <a class="insert" href="#"> <img
						src="/images/icon/edit.png">
				</a>
				</li>
			</div>
		</div>
	</div>
	<!-- Contents end -->



	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>