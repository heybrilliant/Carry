<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>1:1Chatting</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/user_chat.css">
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>



	<div id="chatwarp">
		<nav class="chat_ul">
			<div class="chatid">
				<h3>${member.memnick}</h3>
			</div>
			<div class="chatRoom_nav">
				<ul>
					<li><span style="margin-left: 350px; font-size: 30px;">GymCarry</span></li>
				</ul>
				<%-- <ul>
                    <li class="back_button"><input type="button" value="김자바"></li>
                    <li><a href="#"><img src="<c:url value="/images/icon/heart2.png"/>" style="width: 40px;"></a></li>
                    <li><a href="#"><img src="<c:url value="/images/icon/ellipsis-h-solid.svg"/>" style="width: 40px;"></a></li>
                    <li class="order_button"><input type="button" value="결제하기"></li>
                </ul> --%>

			</div>
		</nav>

		<div id="chatlist_wrap">
			<!-- 채팅방 리스트 시작 -->
			<c:forEach items="${chatList}" var="list">
				<div class="chatlist">
					<button type="button" value="${list.crnick}"
						onclick="location.href='javascript:chatList(${list.chatidx})'"
						class="on_btn">
						<div class="float_left">
							<img src="<c:url value="/images/icon/profile2.png"/>">
						</div>
						<div class="float_left chat_name">
							<h3>${list.crnick}</h3>
						</div>
						<div class="chat_title">
							<span>${list.placename}</span>
						</div>
						<div class="chat_content">
							<span> <%-- ${list.chatcontent} --%>
							</span>
						</div>
						<div class="chat_date">
							<span> <%-- ${list.chatdate} --%>
							</span>
						</div>
					</button>
				</div>
			</c:forEach>
			<!-- 채팅방 리스트 끝 -->
		</div>
		<div id="chatcontent_warp">
			<div class="not_message">
				<img src="<c:url value="/images/icon/chat.png"/>"
					style="width: 80px;">
				<h3>채팅할 상대를 선택해주세요</h3>
			</div>

		</div>
		<div class="chatting_write"></div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>

	<script>
		//채팅룸 선택시 이벤트
		$(document).ready(function() {
			$(".chatlist .on_btn").click(function() {
				$(".chatlist .on_btn").removeClass('active');
				$(this).addClass('active');
			});

		});
	</script>


	<script>
		var socket = new SockJS("<c:url value='/echo'/>");

		// open - 커넥션이 제대로 만들어졌을 때 발생함
		socket.onopen = function(e) {
			// 방오픈 됫는지 확인 메세지
			console.log('connection opend.')
			$('.ss').append("<b>채팅방에 참여했습니다</b>")
			
		};
		
		// onmessage - 커넥션이 메세지 발생함
		socket.onmessage = function(message) {
			var jsonData = JSON.parse(message.data);
			console.log(message.data);
		}

		// close - 커넥션이 종료되었을 때 발생함
		socket.onclose = function(event) {
			console.log('connection closed.');
		}

		// error - 에러가 생겼을 때 발생함
		socket.onerror = function(error) {
			console.log('connection Error.')
		};
		
		// 객체를 json형태로 담아 보냄
		function sendMessage() {
			// send 되는지 확인
			console.log('send message');
			var msg = {
				memnick : '${member.memnick}',
				to : 'ss',
				message : $('#msg').val()
			};
			console.log(msg);
			
			// 사용자idx, 캐리idx, 메세지 send 보낸다.
			socket.send(JSON.stringify(msg));
			return false;
		} 
	</script>

	<script>
		// 채팅방 대화내용 리스트
		function chatList(num) {

			$.ajax({
				type : 'GET',
				url : '<c:url value="/chatting/dochat"/>',
				dataType : 'json',
				data : {
					chatidx : num
					},
					success : function(data) {
						console.log(data)
						if (data == 0) {
						var htmlNav = '<ul>';
							htmlNav += '<li class="back_button"><input type="button" value="dd" onclick="history.go(0)"></li>';
							htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/heart2.png"/>" style="width: 40px;"></a></li>'
							htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/ellipsis-h-solid.svg"/>" style="width: 40px;"></a></li>'
							htmlNav += '<li class="order_button"><input type="button" value="결제하기"></li>'
							htmlNav += '</ul>'
							
							
							/* $('form').submit(function(){
								console.log('send');
								sendMessage();
								var msg = $('#msg').val('');
								return false;
							}); */
							// onsubmit으로 sendMessage() 메소드를 리턴 한다. 
							// ajax안에 있는 함수에서 함수를 작업할수 없다 (위에있는 함수안에 sendMessage()를 호출할 수 없다.)
						var htmlStr = '<form onsubmit="return sendMessage();">'
							htmlStr += '<div class="chat_null">';
							htmlStr += '<b id="ss"></b>';
							htmlStr += '</div>';
							htmlStr += '<div class="chatting_write">';
							htmlStr += '<input type="text" placeholder="메세지 입력.." id="msg">';
							htmlStr += '<button type="submit" class="btn" id="btnSend">';
							htmlStr += '<img src="<c:url value="/images/icon/icoin.png"/>">';
							htmlStr += '</button>';
							htmlStr += '</div>';
							htmlStr += '</form>';

							$('#chatcontent_warp').html(htmlStr);
							$('.chatRoom_nav').html(htmlNav);

							// 처음 접속시, 메세지 입력창에 focus 시킴
							$('#msg').focus();
							// 메세지 입력창 내용 보내고 지우기.
							$('#msg').val("");
							

						} else {
							$.each(data, function(index, item) {
							console.log(index, item);
							var html = '<div class="carry_line">';
							html += '<img src="<c:url value="/images/icon/profile2.png"/>">';
							html += '</div>';
							html += '<div class="carry_chat">';
							html += '<div class="message">';
							html += '<div class="message_color">';
							html += '<span>안녕하세요. 김자바 캐리입니다.</span>';
							html += '</div>';
							html += '</div>';
							html += '<div class="time_line">';
							html += '<span>10:53AM</span>';
							html += '</div>';
							html += '</div>';
							html += '<div class="user_message_warp">';
							html += '<div class="user_chat">';
							html += '<div class="user_message">';
							html += '<div>';
							html += '<span>' + item.chatcontent + '</span>';
							html += '</div>';
							html += '</div>';
							html += '<div class="time_line2">';
							html += '<span>' + item.chatdate +'</span>';
							html += '</div>';
							html += '</div>';
							html += '<div class="chatting_write">';
							html += '<input type="text" placeholder="메세지 입력..">';
							html += '<button type="submit" class="btn">';
							html += '<img src="<c:url value="/images/icon/icoin.png"/>">';
							html += '</button>';
							html += '</div>';

							$('#chatcontent_warp').html(html);
						})
					}
				}
			})
		}
	</script>