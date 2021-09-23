<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>짐캐리 화상 피티</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<body>
	상대방
	<video id="remoteVideo" autoplay></video>
	나
	<video id="localVideo" autoplay></video>
	<button id="startCall">시작</button>
	<button id="stopCall">종료</button>
	<div id="channelId"></div>
	<footer>
		<p>짐캐리 GYM CARRY 제공</p>
	</footer>


	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
	<!-- adapter.js, remon.js 파일을 추가하고 config를 만듭니다. -->
	<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@remotemonster/sdk/remon.min.js"></script>
	<script>
	  const config = {      
		        credential: {        
		        	 serviceId: 'a7969170-97e7-4639-b8ab-3bebcda337d7',
		             key: '8deb9631b5eae19b041470b8e06fb34c6cb4e317a269a594218d8b49e2fc9030'
		        },      
		        view: {        
		          remote: '#remoteVideo',        
		          local: '#localVideo'      
		        }    
		      };
	  
	  const listener = {
		        onConnect(chid) {
		          $('#channelId').text(chid);
		          console.log(`onConnect: ${chid}`);
		        }
		      };

		      const remonCall = new Remon({
		        config: config,
		        listener: listener
		      });

		      $('#startCall').click(function() {
		        remonCall.connectCall('my-first-channel');
		      });
		      
		   // "종료" 버튼을 클릭하면 통화채널에서 나갑니다.    
		      $('#stopCall').click(function() {
		        remonCall.close();    
		      });  
	</script>