<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>1:1Chatting</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/chat/user_chat.css">
<script
	src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>



	<div id="chatwarp">
		<div id="chatlist_wrap">
			<!-- 유저가 보는 캐리 채팅방리스트 -->
			<c:if test="${loginSession.memnick ne null}">
				<div class="chatid">
					<h3>${loginSession.memnick}</h3>
				</div>
				<!-- 채팅방 리스트 시작 -->
				<div class="chatList_scr">
					<c:forEach items="${chatList}" var="list">
						<div class="chatlist">
							<button type="button" value="${list.chatidx}"
								onclick="getChat(${list.chatidx},${list.memidx},${list.cridx},'${list.memnick}','${list.crnick}');
							location.href='javascript:chatList(${list.chatidx})'"
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
								<c:if test="${list.chatread == 1}">
								<div class="chat_title_img"></div>
								</c:if>
								<div class="chat_content">
									<span class="chatMessage">${list.chatcontent}</span>
								</div>
								<fmt:formatDate value="${now}" pattern="HH:mm" var="now" />
								<div class="chat_date">
									<span>${now}</span>
								</div>
							</button>
						</div>
					</c:forEach>
				</div>
			</c:if>
			<!-- 캐리가 보는 유저 채팅방리스트 -->
			<c:if test="${loginSession.crnick ne null}">
				<div class="chatid">
					<h3>${loginSession.crnick}</h3>
				</div>
				<c:forEach items="${carryChatList}" var="list">
					<div class="chatlist">
						<button type="button" value="${list.crnick}"
							onclick="getChat(${list.chatidx},${list.memidx},${list.cridx},'${list.memnick}','${list.crnick}'); location.href='javascript:chatList(${list.chatidx})'"
							class="on_btn">
							<div class="float_left">
								<img src="<c:url value="/images/icon/profile2.png"/>">
							</div>
							<div class="float_left chat_name">
								<h3>${list.memnick}</h3>
							</div>
							<div class="chat_title">
								<span></span>
							</div>
							<c:if test="${list.chatread == 0}">
								<div class="chat_title_img"></div>
							</c:if>
							<div class="chat_content">
								<span>
									${list.chatcontent}
								</span>
							</div>
							<div class="chat_date">
								<span> ${list.chatdate}
								</span>
							</div>
						</button>
					</div>
				</c:forEach>
			</c:if>
		</div>
		<!-- 채팅방 리스트 끝 -->
		<div id="chatcontent_warp">
			<div id="chatcontent_off">
				<div class="not_message">
					<img src="<c:url value="/images/icon/chat.png"/>"
						style="width: 80px;">
					<h3>채팅할 상대를 선택해주세요</h3>
				</div>
			</div>
		</div>


	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function() {
			$(".chatlist .on_btn").click(function() {
				$(".chatlist .on_btn").removeClass('active');
				$(this).addClass('active');
			});
		});
		
		function chatNav(){
			var htmlNav = '<ul>';
			htmlNav += '<li class="back_button"><a href="#" onclick="history.go(0)"><img src="<c:url value="/images/icon/arrow.png"/>"</a></li>';
			htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/ellipsis-h-solid.svg"/>" style="width: 40px;"></a></li>'
			<c:if test="${loginSession.memnick ne null}">
			htmlNav += '<li class="onlike"><button class="likeBtn" onclick="chatLike()" value="0"><img src="<c:url value="/images/icon/heart2.png"/>" style="width: 40px;"></button></li>'
			</c:if>
			htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/garbage.png"/>" style="width: 40px;"></a></li>'
			htmlNav += '<li class="order_button"><input type="button" value="결제하기"></li>'
			htmlNav += '</ul>'
			$('.message_warp').html(htmlNav);
		}
		
		var chatIdx;
		var memidx;
		var cridx;
		var memnicks;
		var crnicks;
		function getChat(num, mnum, crnum, memnick, crnick){
			chatIdx = num;
			memidx = mnum;
			cridx = crnum;
			memnicks = memnick;
			crnicks = crnick;
		}
		
		function chattting(){
			var htmlStr = '<div>'
				htmlStr += '<div class="message_warp"></div>'
				htmlStr += '<div class="chat_null" id="output">'
				htmlStr += '	<div class="carry_message_warp">'
				htmlStr += '		<div class="carry_chat">'
				htmlStr += '		<div class="time_line"><span></span></div>'
				htmlStr += '		</div>'
				htmlStr += '	</div>'
				htmlStr += '</div>'
				htmlStr += '<div class="chatting_write">'
				htmlStr += '<input type="text" placeholder="메세지 입력.." id="msg"">'
				htmlStr += '<input type="hidden" value="${loginSession.memnick}" id="memberId">'
				htmlStr += '<input type="hidden" value="${loginSession.crnick}" id="carryId">'
				htmlStr += '<button type="button" class="btn" id="btnSend">'
				htmlStr += '<img src="<c:url value="/images/icon/icoin.png"/>">'
				htmlStr += '</button>'
				htmlStr += '</div>'					
				htmlStr += '</div>'
			$('#chatcontent_warp').html(htmlStr);			
			chatNav();
			
			// 처음 접속시, 메세지 입력창에 focus 시킴
			$('#msg').focus();
			
			$('#btnSend').click(function(event){
				if ($('input#msg').val().trim().length >= 1) {
					event.preventDefault();
					var msg = $('input#msg').val();
					sendMessage();
					//lastMessage();
					// 메세지 입력창 내용 보내고 지우기.
					$('#msg').val('');
				}
			});	
			
			$('#msg').keypress(function(event){
				if (event.keyCode == 13 && $('input#msg').val().trim().length >= 1) {
					event.preventDefault();
					var msg = $('input#msg').val();
					//sock.send(msg);
					sendMessage();
					//lastMessage();
					// 메세지 입력창 내용 보내고 지우기.
					$('#msg').val('');
				}
				
			});	
		}
	</script>

	<script>
	
	var socket = new SockJS("<c:url value='/echo'/>");
	sock = socket;
	// open - 커넥션이 제대로 만들어졌을 때 호출
	socket.onopen = function() {
		// 방오픈 됫는지 확인 메세지
		console.log('connection opend.');
	};
	
	var memsession = '${loginSession.memnick}';
	var crsession = '${loginSession.crnick}';
	
	
	// onmessage - 커넥션이 메세지 호출
	socket.onmessage = function(message) {
		var data = message.data;
		var jsonData = JSON.parse(data);
		
		var currentuser_session1 = $('#memberId').val();
		var currentuser_session2 = $('#carryId').val();
		
		if(chatIdx == jsonData.chatidx){
			if (jsonData.memnick == currentuser_session1) {
				var htmlStr = '	<div class="user_message_warp">'
					htmlStr += '		<div class="user_chat">'
					htmlStr += '			<div class="user_message">'
					htmlStr += '				<div>'
					htmlStr += '					<span>'+jsonData.chatcontent+'</span>'
					htmlStr += '				</div>'
					htmlStr += '			</div>'
					htmlStr += '			<div class="time_line2">'
					htmlStr += '				<span>'+jsonData.chatdate+'</span>'
					htmlStr += '			</div>'
					htmlStr += '		</div>'
					htmlStr += '	</div>'
				
				$('.chat_null').append(htmlStr);
				$("#output").scrollTop($("#output")[0].scrollHeight);
				
			} else if(jsonData.memnick != currentuser_session1) {
				if (jsonData.crnick == currentuser_session2) {
					var htmlStr = '	<div class="user_message_warp">'
						htmlStr += '		<div class="user_chat">'
						htmlStr += '			<div class="user_message">'
						htmlStr += '				<div>'
						htmlStr += '					<span>'+jsonData.chatcontent+'</span>'
						htmlStr += '				</div>'
						htmlStr += '			</div>'
						htmlStr += '			<div class="time_line2">'
						htmlStr += '				<span>'+jsonData.chatdate+'</span>'
						htmlStr += '			</div>'
						htmlStr += '		</div>'
						htmlStr += '	</div>'
					$('.chat_null').append(htmlStr);
					$("#output").scrollTop($("#output")[0].scrollHeight);
					
				} else {
					var htmlSt = '<div class="carry_message_warp">'
						htmlSt += '<div class="carry_chat">'
						htmlSt += '<div class="carry_line"><img src="<c:url value="/images/icon/profile2.png"/>"></div>'
						htmlSt += '<div class="message">'
						htmlSt += '<div class="message_color">'
						htmlSt += '<span>'+jsonData.chatcontent+'</span>'
						htmlSt += '</div>'
						htmlSt += '</div>'
						htmlSt += '<div class="time_line"><span></span></div>'
						htmlSt += '</div>'
						htmlSt += '</div>'
					$('.chat_null').append(htmlSt);
					$("#output").scrollTop($("#output")[0].scrollHeight);
				}
			}
			$('.chatlist .active .chat_content').html('<span>'+ jsonData.chatcontent+'</span>');
		} 
		
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
	function sendMessage() {
		var msg = {
			memnick : '${loginSession.memnick}',
			crnick : '${loginSession.crnick}',
			cridx : cridx,
			memidx : memidx,
			chatidx : chatIdx,
			chatcontent : $('#msg').val()
		};
		
		console.log(msg);
		
		// 사용자닉네임, 캐리닉네임, 메세지 send 보낸다.
		socket.send(JSON.stringify(msg));
	}; 
	</script>

	<script>
	function chatLike(){
		var like = $('.likeBtn').val();
		$.ajax({
			type : 'GET',
			url : '<c:url value="/chatting/like"/>',
			dataType : 'json',
			data : {
				likechaeck : like,
				cridx : cridx
			},
			success : function(data){
				$('.message_warp .onlike').html('<button class="likeBtn" onclick="chatLike()" value="0"><img src="<c:url value="/images/icon/heart.png"/>" style="width: 40px;"></button>');
			}
		});
	};	
	
	// 채팅방 대화내용 리스트
	function chatList(num) {
		$.ajax({
			type : 'POST',
			url : '<c:url value="/chatting/dochat"/>',
			dataType : 'json',
			data : {
				chatidx : num
				},
				success : function(data) {
					$('.chatlist .active .chat_title_img').removeClass();
					if (data == 0) {
						chattting();
						chatNav();
					} else {
						var htmlStr = '<div class="carry_message_warp">';
						$.each(data, function(index, item) {
							if(memnicks == memsession){
								if(item.contenttype == 1){
									htmlStr += '<div class="carry_chat">'
									htmlStr += '	<div class="carry_line"><img src="<c:url value="/images/icon/profile2.png"/>"></div>'
									htmlStr += '	<div class="message">'
									htmlStr += '		<div class="message_color">'
									htmlStr += '			<span>'+item.chatcontent+'</span>'
									htmlStr += '		</div>'
									htmlStr += '	</div>'
									htmlStr += '	<div class="time_line"><span>'+item.chatdate+'</span></div>'
									htmlStr += '	</div>'
									htmlStr += '</div>'
								} 
								if(item.contenttype == 0){
									htmlStr += '	<div class="user_message_warp">'
									htmlStr += '		<div class="user_chat">'
									htmlStr += '			<div class="user_message">'
									htmlStr += '				<div>'
									htmlStr += '					<span>'+item.chatcontent+'</span>'
									htmlStr += '				</div>'
									htmlStr += '			</div>'
									htmlStr += '			<div class="time_line2">'
									htmlStr += '				<span>'+item.chatdate+'</span>'
									htmlStr += '			</div>'
									htmlStr += '		</div>'
									htmlStr += '	</div>'
								}
								chattting();
								$('.carry_message_warp').html(htmlStr);
								$('#output').scrollTop($('#output')[0].scrollHeight);
								if(item.likecheck == 1){
									$('.message_warp .onlike').html('<button class="likeBtn" onclick="chatLike()" value="0"><img src="<c:url value="/images/icon/heart.png"/>" style="width: 40px;"></button>');
								}
								
							} else if(crnicks == crsession){
								if(item.contenttype == 1){
									htmlStr += '	<div class="user_message_warp">'
									htmlStr += '		<div class="user_chat">'
									htmlStr += '			<div class="user_message">'
									htmlStr += '				<div>'
									htmlStr += '					<span>'+item.chatcontent+'</span>'
									htmlStr += '				</div>'
									htmlStr += '			</div>'
									htmlStr += '			<div class="time_line2">'
									htmlStr += '				<span>'+item.chatdate+'</span>'
									htmlStr += '			</div>'
									htmlStr += '		</div>'
									htmlStr += '	</div>'
								} 
								if(item.contenttype == 0){
									htmlStr += '<div class="carry_chat">'
									htmlStr += '	<div class="carry_line"><img src="<c:url value="/images/icon/profile2.png"/>"></div>'
									htmlStr += '	<div class="message">'
									htmlStr += '		<div class="message_color">'
									htmlStr += '			<span>'+item.chatcontent+'</span>'
									htmlStr += '		</div>'
									htmlStr += '	</div>'
									htmlStr += '	<div class="time_line"><span>'+item.chatdate+'</span></div>'
									htmlStr += '	</div>'
									htmlStr += '</div>'
								}
								
								chattting();
								$('.carry_message_warp').html(htmlStr);
								$('#output').scrollTop($('#output')[0].scrollHeight);
							}
					});
				}
			}
		})
	}
	</script>