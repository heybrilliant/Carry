@@ -0,0 +1,213 @@
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>GYM CARRY : SNS회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="/gym/css/joinlogin/regform.css">
<link rel="stylesheet" href="/gym/css/payment/payment.css">

</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- Contents -->
	<div class="container_fix container join_wrap">
		<h1>SNS 회원가입</h1>
		
		<!-- Form 시작 -->
		<form action = <c:url value="" /> method="post">

				<div>
					<span class="noticemsg">** 추가적으로 입력해주시면 회원가입이 정상적으로 완료됩니다. **</span>
					
					<div class="nickForm">
					<p>
						닉네임 <span style="color: blue">*</span>
					</p>
					<input type="text" class="input_box" placeholder="닉네임을 입력해주세요."
						name="memnick" id = "memnick" required>
					</div>	
						
					<div class="phoneForm">
					<p>
						연락처 <span style="color: blue">*</span>
					</p>
					<input type="text" class="input_box" placeholder="'-'없이 번호만 11자리 형식으로 입력해주세요."
						name="payphone" id="memphone" required> <br> <br> <br> <br>
					</div>
					
				<br>
				
				<div class="btn_wrap2">
					<input type="submit" class= "submit_btn" value="회원가입">
					<input type="button" value="취소" onclick="location.href='javascript:window.history.back();'">
				</div>
		</div>
		
		</form>
		<!-- Form 끝 -->
		
		
	</div>
</div>

	<!-- Contents end -->



	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>

</body>


<script>


	//모든 공백 체크 정규식
	var empJ = /\s/g;

	// 이메일, 닉네임, 휴대폰 번호, 생일, 성별 순

	
	// 이메일 -> DB다녀와야함 
	console.log('이메일 도달');
	// 이메일 검사 정규식 : 이메일 형식(ㅇㅇㅇ@ㅇㅇㅇ.ㅇㅇ)
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	$("#mememail").focusout(function() {
		if (mailJ.test($('#mememail').val())) {
				console.log(mailJ.test($('#mememail').val()));
				$("#emailcheck").text('');
		// 이메일 이맞으면 ajax 실행		
		$.ajax({
			type : 'POST',
			url : '<c:url value="/member/emailCheck"/>',
			data : { 
				mememail : $(this).val()
			},
			success : function(data) {
				if(data == 0){
					$('#msg').html('사용가능');
					$('#msg').addClass('color_blue');
					$('#msg').removeClass('display_none');
				} else {
					$('#msg').html('사용 불가능');
					$('#msg').addClass('color_red');
					$('#msg').removeClass('display_none');
					$('#mememail').val('');
				}
			}
		});
				
		} else {
			$('#emailcheck').text('이메일 형식으로 입력해주세요.');
			$('#emailcheck').css('color', 'red');
		}
		error : console.log('이메일 실패');
	});
	
	
	
	// 휴대폰 번호
	// 휴대폰 번호 정규식 : 010(필수)+ 숫자로만 8글자
	var phoneJ = /^010([0-9]{8})$/;
	$('#memphone').focusout(function(){
		if(phoneJ.test($('#memphone').val())){
			console.log(phoneJ.test($('#memphone').val()));
			$("#phonecheck").text('');
			// 번호가 맞으면 ajax 실행
			$.ajax({
				type : 'POST',
				url : '<c:url value="/member/phoneCheck"/>',
				data : { 
					memphone : $(this).val()
				},
				success : function(data) {
					if(data == 0){
						$('#msg_phone').html('사용가능');
						$('#msg_phone').addClass('color_blue');
						$('#msg_phone').removeClass('display_none');
					} else {
						$('#msg_phone').html('사용 불가능');
						$('#msg_phone').addClass('color_red');
						$('#msg_phone').removeClass('display_none');
						$('#memphone').val('');
					}
				}
			});
		} else {
			$('#phonecheck').text('휴대폰번호를 확인해주세요.');
			$('#phonecheck').css('color', 'red');
		}
		error : console.log('휴대폰 번호 실패');
	});
	
	


	var nickJ = /^[가-힣a-zA-Z]{2,6}$/;
	$("#memnick").focusout(function() {
		if (nickJ.test($('#memnick').val())) {
				console.log(nickJ.test($('#memnick').val()));
				$("#nickcheck").text('');
				// 닉네임이맞으면 ajax 실행
				$.ajax({
					type : 'POST',
					url : '<c:url value="/member/nickCheck"/>',
					data : { 
						memnick : $(this).val()
					},
					success : function(data) {
						if(data == 0){
							$('#msg_nick').html('사용가능');
							$('#msg_nick').addClass('color_blue');
							$('#msg_nick').removeClass('display_none');
						} else {
							$('#msg_nick').html('사용 불가능');
							$('#msg_nick').addClass('color_red');
							$('#msg_nick').removeClass('display_none');
							$('#memnick').val('');
						}
						
					}
				});
				
		} else {
			$('#nickcheck').text('2~6글자의 한글, 영어만 사용 가능합니다.');
			$('#nickcheck').css('color', 'red');
		}
		error : console.log('닉 실패');
	});	
		
</script>
<!-- alert('입력해주신 이메일로 인증 메일이 발송되었습니다. 이메일 인증을 완료해주세요.') -->

<!-- 회원가입 이메일,닉네임,핸드폰 중복체크 ajax -->
<script>
$('#mememail, #memnick, #memphone').focusin(function() {
	$('#msg').addClass('display_none');
	$('#msg').removeClass('color_blue');
	$('#msg').removeClass('color_red');
	$('#msg').val('');
	$('#msg_nick').addClass('display_none');
	$('#msg_nick').removeClass('color_blue');
	$('#msg_nick').removeClass('color_red');
	$('#msg_phone').addClass('display_none');
	$('#msg_phone').removeClass('color_blue');
	$('#msg_phone').removeClass('color_red');
});
	
</script>

</html>




