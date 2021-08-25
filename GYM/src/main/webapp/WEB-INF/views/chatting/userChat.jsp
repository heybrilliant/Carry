<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>1:1Chatting</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/user_chat.css">
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
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
                <a href="javascript:chatList(${list.chatidx})" onclick="">
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
                        <span><%-- ${list.chatcontent} --%></span>
                    </div>
                    <div class="chat_date">
                        <span><%-- ${list.chatdate} --%></span>
                    </div>
                </a>
            </div>
			</c:forEach>
            <!-- 채팅방 리스트 끝 -->
        </div>
		
        <div id="chatcontent_warp">
            <div class="not_message">
                <img src="<c:url value="/images/icon/chat.png"/>" style="width: 80px;">
                <h3>채팅할 상대를 선택해주세요</h3>
            </div>
        	
        </div>
        <div class="chatting_write">
        </div>
    </div>
	
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
	
	
<script>
$(document).ready(function(){
	$(".chatlist").click(function(){
		$(".chatlist").css("background-color","#eee");
	});
});

// 채팅방 대화내용 리스트
function chatList(num){
	
	$.ajax({
		type : 'GET',
		url : '<c:url value="/chatting/dochat"/>',
		dataType : 'json',
		data : {
			chatidx : num
		},
		success : function (data) {
			console.log(data)
			if(data == 0){
				var htmlNav = "<ul>"
					<c:forEach items="${chatList}" var="list">
					htmlNav += '<li class="back_button"><input type="button" value="${list.crnick}" onclick="history.go(0)"></li>'
					</c:forEach>
					htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/heart2.png"/>" style="width: 40px;"></a></li>'
					htmlNav += '<li><a href="#"><img src="<c:url value="/images/icon/ellipsis-h-solid.svg"/>" style="width: 40px;"></a></li>'
					htmlNav += '<li class="order_button"><input type="button" value="결제하기"></li>'
					htmlNav += '</ul>'
				var	htmlStr = '<form>';
				 	htmlStr += '<div class="chat_null">';
					htmlStr += '</div>';
					htmlStr += '<div class="chatting_write">';
					htmlStr += '<input type="text" placeholder="메세지 입력.." id="dd">';
					htmlStr += '<button type="submit" class="btn" id="ss">';
					htmlStr += '<img src="<c:url value="/images/icon/icoin.png"/>">';
					htmlStr += '</button>';
					htmlStr += '</div>';
					htmlStr += '</form>';
					
					
					$('.chatRoom_nav').html(htmlNav);
					$('#chatcontent_warp').html(htmlStr); 
			} else {
				$.each(data, function(index, item){
				console.log(index, item);
				var	html = '<div class="carry_line">';
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
					html += '<span>'+ item.chatcontent +'</span>';
					html += '</div>';
					html += '</div>';
					html += '<div class="time_line2">';
					html += '<span>'+ item.chatdate+'</span>';
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


/* var html = "<ul>"
	html += "<li class="back_button"><input type="button" value="김자바"></li>"	
	html += "<li><a href="#"><img src="../img/heart2.png" style="width: 40px;"></a></li>"
	html += "<li><a href="#"><img src="../img/heart2.png" style="width: 40px;"></a></li>"
	html += "<li><a href="#"><img src="../img/heart2.png" style="width: 40px;"></a></li>"
	html += "<li><a href="#"><img src="../img/heart2.png" style="width: 40px;"></a></li>"
    html += "<li class="order_button"><input type="button" value="결제하기"></li>"
    html += "</ul>"
	$('.chatRoom_nav').html(html); */



</script>	

<script>
	// 웹소켓 커넥션을 만들려면 new WebSocket을 호출하면되는데, 이때 ws라는 특수 프로토콜을 사용한다.
	var socket = new SockJS("<c:url value='/echo'/>");
	
	// open - 커넥션이 제대로 만들어졌을 때 발생함
	socket.onopen = function(e){
		console.log('connection opend.')
		socket.send("My name is m");
	};
	
	// message - 데이터를 수신하였을 때 발생함
	socket.onmessage = function(event){
		var data = event.data; 
		console.log(data);
	};
	
	$(document).ready(function(){
		$('form').submit(function(){
			console.log('send message....');
			sendMessage();
			
			// 메시지 입력한값
			$('#message').val('');
			
		})
	});
	
	
	// close - 커넥션이 종료되었을 때 발생함
	socket.onclose = function(event){
		console.log('connection closed.');
	}
	
	// error - 에러가 생겼을 때 발생함
	socket.onerror = function(error) {
		console.log('connection Error.')
	};
	
	
	// Connection: Upgrade – 클라이언트 측에서 프로토콜을 바꾸고 싶다는 신호를 보냈다는 것을 나타냅니다.
	// Upgrade: websocket – 클라이언트측에서 요청한 프로토콜은 'websocket’이라는걸 의미합니다.
	// Sec-WebSocket-Key – 보안을 위해 브라우저에서 생성한 키를 나타냅니다.
	// Sec-WebSocket-Version – 웹소켓 프로토콜 버전이 명시됩니다. 예시에서 버전은 13입니다.
	
	
	
</script>



