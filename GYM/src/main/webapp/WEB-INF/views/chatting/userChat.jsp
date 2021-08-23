<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>1:1Chatting</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/user_chat.css">

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	
	
	
	<div id="chatwarp">
        <nav class="chat_ul">
            <div class="chatid">
                <h3>접속자 아이디</h3>
            </div>
            <div class="chatRoom_nav">
            	<c:if test=""></c:if>
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
                <a href="javascript:chatList(${list.chatidx})">
                    <div class="float_left">
                        <img src="<c:url value="/images/icon/profile2.png"/>">
                    </div>
                    <div class="float_left chat_name">
                        <h3>${list.crnick}</h3>
                    </div>
                    <div class="chat_title">
                        <span>${list.centername}</span>
                    </div>
                    <div class="chat_content">
                        <span>${list.chatcontent}</span>
                    </div>
                    <div class="chat_date">
                        <span>${list.chatdate}</span>
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
// 채팅방 대화내용 리스트
function chatList(num){
	
	$.ajax({
		type : 'GET',
		url : '<c:url value="/chatting/dochat"/>',
		datType : 'json',
		data : {
			chatidx : num
		},
		success : function (data) {
			console.log(data)
			$.each(data, function(index, item){
			
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
