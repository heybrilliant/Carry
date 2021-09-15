<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<link rel="stylesheet" href="/gym/css/joinlogin/loginform.css">

</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- 은경 -->

	<!-- Contents -->

	<div class="wrap wd668">
		<div class="form_txtInput">

			<form action="<c:url value="/member/memberLogin"/>" method="post">
				<h1 class="sub_tit_txt">회원 로그인</h1>
				<div class="login_form">
				
				
					<div class="tb">
						<div id="catebox">
							<label id="cate"><grid>이메일</grid></label>
						</div>
						
						<input type="text" id="into" name="mememail">
						<div class="check_font" id="emailcheck" style=float:left></div>
					</div>

					<div class="tb">
						<div id="catebox">
							<label id="cate"><grid>비밀번호</grid></label>
						</div>
						
						<input type="password" id="into" name="mempw">
						<div class="check_font" id="pwcheck"></div>
					</div>

					<div class="selectbox">
						<input type="checkbox" value="true" id="rememberemail"
							name="rememberemail"> 이메일 기억하기 <input type="hidden"
							name="redirectUri">
					</div>

					<div id="btnbox">
						<div class="btn_wrap">
							<input type="submit" id="loginbtn" value="로그인">
						</div>
						<a id="alter" href="<c:url value="/carry/login"/>">캐리로그인</a><br>
					</div>
				</div>
				<!-- join_form E  -->
			</form>

			<hr>
			<div class="change">
				<ul>
					<li><a href="<c:url value="/member/join"/>">일반 회원가입</a></li>
					<li class="tab2"><a href="<c:url value="/find/findid"/>">회원 아이디
							찾기</a></li>
					<li class="tab2"><a href="<c:url value="/find/findpassword"/>">회원 비밀번호
							찾기</a></li>
				</ul>
			</div>

			<ul class="apiLogin">
				<li class="kakao">
					<img src="<c:url value="/images/icon/kakao_login_medium_btn.png"/>" onclick="kakaoLogin()">
				</li>
				<li onclick="kakaoLogout()"><a href="javascript:void(0)">
						<span>카카오 로그아웃</span>
				</a></li>
			</ul>


		</div>
	</div>
	<!-- content E-->



	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>


<!-- 카카오 로그인 API -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
	Kakao.init('0ecec0f1529ce019d44a9de3e0b3bb22'); //발급받은 키 중 javascript키를 사용해준다.
	console.log(Kakao.isInitialized()); // sdk초기화여부판단
	//카카오 로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			/* scope: 'profile, account_email,  gender',  */
			success : function(response) {
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(response) {
						console.log(response)
					},
					fail : function(error) {
						console.log(error)
					},
				})
			},
			fail : function(error) {
				console.log(error)
			},
		})
	}
	
/* 	function kakaoLoginPro(response){
		var data = {id:response.id,email:response.kakao_account.email}
		$.ajax({
			type : 'POST',
			url : '/member/kakaologin',
			data : data,
			dataType : 'json',
			success : function(data){
				console.log(data)
				if(data.JavaData == "YES"){
					alert("로그인되었습니다.");
					location.href = '/index'
				}else if(data.JavaData == "register"){
					$("#kakaoEmail").val(response.kakao_account.email);
					$("#kakaoId").val(response.id);
					$("#kakaoForm").submit();
				}else{
					alert("로그인에 실패했습니다");
				}
				
			},
			error: function(xhr, status, error){
				alert("로그인에 실패했습니다."+error);
			}
		}); */
	
	
	
	//카카오 로그아웃  
	function kakaoLogout() {
		if (Kakao.Auth.getAccessToken()) {
			Kakao.API.request({
				url : '/v1/user/unlink',
				success : function(response) {
					console.log(response)
				},
				fail : function(error) {
					console.log(error)
				},
			})
			Kakao.Auth.setAccessToken(undefined)
		}
	}
</script>

<!-- 
<script>
// input = "userId"  // mememail
// idsavecheck // rememberemail

$(document).ready(function(){
	 
    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
    var key = getCookie("key");
    $("#mememail").val(key); 
     
    if($("#mememail").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
        $("#rememberemail").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
    }
     
    $("#rememberemail").change(function(){ // 체크박스에 변화가 있다면,
        if($("#rememberemail").is(":checked")){ // ID 저장하기 체크했을 때,
            setCookie("key", $("#mememail").val(), 7); // 7일 동안 쿠키 보관
        }else{ // ID 저장하기 체크 해제 시,
            deleteCookie("key");
        }
    });
     
    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
    $("#mememail").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
        if($("#rememberemail").is(":checked")){ // ID 저장하기를 체크한 상태라면,
            setCookie("key", $("#mememail").val(), 7); // 7일 동안 쿠키 보관
        }
    });
});
 
function setCookie(cookieName, value, exdays){
    var exdate = new Date();
    exdate.setDate(exdate.getDate() + exdays);
    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
    document.cookie = cookieName + "=" + cookieValue;
}
 
function deleteCookie(cookieName){
    var expireDate = new Date();
    expireDate.setDate(expireDate.getDate() - 1);
    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
}
 
function getCookie(cookieName) {
    cookieName = cookieName + '=';
    var cookieData = document.cookie;
    var start = cookieData.indexOf(cookieName);
    var cookieValue = '';
    if(start != -1){
        start += cookieName.length;
        var end = cookieData.indexOf(';', start);
        if(end == -1)end = cookieData.length;
        cookieValue = cookieData.substring(start, end);
    }
    return unescape(cookieValue);
}
	
</script>
 -->

</html>