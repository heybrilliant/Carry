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
			<div id="chatlist_wrap">
			<div class="chatid">
				<h3>${member.memnick}</h3>
			</div>
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
			</div>
				<!-- 채팅방 리스트 끝 -->
			<div id="chatcontent_warp">
			<form onsubmit="return sendMessage();">
				<div class="message_warp">
					<ul>
					<li class="back_button"><input type="button" value="dd" onclick="history.go(0)"></li>
					<li><a href="#"><img src="<c:url value="/images/icon/heart2.png"/>" style="width: 40px;"></a></li>
					<li><a href="#"><img src="<c:url value="/images/icon/ellipsis-h-solid.svg"/>" style="width: 40px;"></a></li>
					<li class="order_button"><input type="button" value="결제하기"></li>
					</ul>
				</div>
				<div class="chat_null">
					<div class="carry_line">
						<img src="<c:url value="/images/icon/profile2.png"/>">';
					</div>
					<div class="carry_chat">
						<div class="message">
							<div class="message_color">
								<span>안녕하세요. 김자바 캐리입니다.</span>
							</div>
						</div>
						<div class="time_line">
							<span>10:53AM</span>
						</div>
					</div>
				<div class="user_message_warp">
					<div class="user_chat">
						<div class="user_message">
							<div>
						<span><!-- ' + item.chatcontent + ' --> 안녕하세요.</span>
							</div>
						</div>
						<div class="time_line2">
							<span><!-- ' + item.chatdate +' --> 10:56AM</span>
						</div>
					</div>
				</div>
				</div>
				<div class="chatting_write">
				<input type="text" placeholder="메세지 입력.." id="msg">
				<button type="submit" class="btn" id="btnSend">
				<img src="<c:url value="/images/icon/icoin.png"/>">
				</button>
				</div>
				</form>
			</div>
			<div id="chatcontent_off">
				<div class="not_message">
					<img src="<c:url value="/images/icon/chat.png"/>"
						style="width: 80px;">
					<h3>채팅할 상대를 선택해주세요</h3>
				</div>
			</div>
		</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>

	<script>
		//채팅룸 선택시 이벤트
		$(document).ready(function() {
			$('.message_warp').hide();
			$('.chatting_write').hide();
			$('.chat_null').hide();
			
			$(".chatlist .on_btn").click(function() {
				$(".chatlist .on_btn").removeClass('active');
				$(this).addClass('active');
				$("#chatcontent_off").hide();
				$('#span_off').hide();
			});
				

		});
	</script>


	<script>
		var socket = new SockJS("<c:url value='/echo'/>");

		// open - 커넥션이 제대로 만들어졌을 때 호출
		socket.onopen = function(e) {
			// 방오픈 됫는지 확인 메세지
			console.log('connection opend.')
		};
		
		// onmessage - 커넥션이 메세지 호출
		socket.onmessage = function(message) {
			var data = message.data;
			console.log(data);
			var jsonData = JSON.parse(data);
			console.log(jsonData);
			appendMessage(jsonData.message);
			
		};

		// close - 커넥션이 종료되었을 때 호출
		socket.onclose = function(event) {
			console.log('connection closed.');
		};

		// error - 에러가 생겼을 때 호출
		socket.onerror = function(error) {
			console.log('connection Error.')
		};
		
		// 객체를 json형태로 담아 보냄
		function sendMessage(e) {
			// send 되는지 확인
			e.preventDefault();
			console.log('send message');
			
			// 메세지 입력값이 빈공간이 아니면 멤버닉네임, 캐리닉네임, 대화내용 담기
			var msg = $('#msg').va();
			var msg = {
				memnick : '${member.memnick}',
				crnick : 'ss',
				message : $('#msg').val()
			};
			console.log(msg);
			
			// 사용자닉네임, 캐리닉네임, 메세지 send 보낸다.
			socket.send(JSON.stringify(msg));
			return false;
		}; 
		
		function appendMessage(msg){
			if(msg == ''){
				return false;
			} else {
				$('#ss').append('<b>'+msg+'</b>');
				
			}
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
							
							// onsubmit으로 sendMessage() 메소드를 리턴 한다. 
							// ajax안에 있는 함수에서 함수를 작업할수 없다
						var htmlStr = '<form onsubmit="return sendMessage();">'
							htmlStr += '<div class="message_warp">';
							htmlStr += '</div>';
							htmlStr += '<div class="chat_null">';
							htmlStr += '<b id="ss">asdasd</b>';
							htmlStr += '</div>';
							htmlStr += '<div class="chatting_write">';
							htmlStr += '<input type="text" placeholder="메세지 입력.." id="msg">';
							htmlStr += '<button type="submit" class="btn" id="btnSend">';
							htmlStr += '<img src="<c:url value="/images/icon/icoin.png"/>">';
							htmlStr += '</button>';
							htmlStr += '</div>';
							htmlStr += '</form>';

							$('#chatcontent_warp').html(htmlStr);
							$('.message_warp').html(htmlNav);

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