<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>멤버 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<link rel="stylesheet" href="/gym/css/joinlogin/regform.css">

</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- 은경 -->

	<!-- Contents -->
	<div class="wrap wd668">
		<div class="container">
			<form id="joinForm" action="<c:url value="/member/join"/>"
				method="post" enctype="multipart/form-data">
				<div class="form_txtInput">
					<h1 class="sub_tit_txt">회원 회원가입</h1>
					<p class="exTxt">회원가입시 이메일 인증을 반드시 진행하셔야 합니다.</p>


					<div class="join_form">
						<div class="profile_form">
							<div class="profileimg">
								<img src="/gym/images/icon/profile.png"><br>
							</div>
							<input type="button" value="업로드" class="profilebtn" name="memphoto"
								onclick=document.all.file.click();>
							<input type="file" name="memphoto" id="file" class="profilebtn" style="display: none;" />
							<!-- <input type="button" id="realinput" name="memphoto" accept="image/jpeg, image/jpg, image/png" onclick="document.all.file.click()">
						<button class="profilebtn" type="submit">프로필 사진</button>위아래 margin값 주기 -->
						</div>

						<div class="form-box">
							<label id="cate">이름</label> <input type="text" name="memname"
								id="memname" placeholder="이름" required />
							<div class="check_font" id="namecheck"></div>
						</div>

						<div class="form-box">
							<label id="cate">이메일</label> <input type="text" name="mememail"
								id="mememail" placeholder="이메일 형식으로 입력해주세요. 로그인시 아이디로 사용됩니다."
								required>
							<div class="check_font" id="emailcheck" style="float: left"></div>
						</div>

						<div class="form-box">
							<label id="cate">비밀번호</label> <input type="password" name="mempw"
								id="mempw" placeholder="비밀번호를 입력해주세요.">
							<div class="check_font" id="pwcheck"></div>
						</div>

						<div class="form-box">
							<label id="cate">비밀번호 확인</label> <input type="password"
								name="mempw2" id="mempw2" placeholder="비밀번호를 확인해주세요.">
							<div class="check_font" id="mempw2check"></div>
						</div>

						<div class="form-box">
							<label id="cate"><span>닉네임</span></label> <input type="text"
								name="memnick" id="memnick" placeholder="">
							<div class="check_font" id="nickcheck"></div>
						</div>

						<div class="form-box">
							<label id="cate">휴대폰 번호</label> <input type="text"
								name="memphone" id="memphone"
								placeholder="'-'없이 번호만 11자리 형식으로 입력해주세요.">
							<div class="check_font" id="phonecheck"></div>
						</div>

						<div class="form-box">
							<label id="cate">생년월일</label> <input type="text" name="membirth"
								id="membirth" placeholder="8자리 형식의 숫자로만 입력해주세요.ex_19901010">
							<div class="check_font" id="birthcheck"></div>
						</div>

						<div class="selectbox">
							<label id="cate">성별</label> <input type="radio" name="memgender"
								id="male" value="남자"> <label for="male" id="male_label">남자</label>
							<input type="radio" name="memgender" id="female" value="여자">
							<label for="female" id="female_label">여자</label>
							<div class="check_font" id="gendercheck"></div>
						</div>


						<div class="exform_txt">
							<span>표시는 필수적으로 입력해주셔야 가입이 가능합니다.</span>
						</div>
					</div>
					<!-- join_form E  -->



					<div id="btnbox">
						<div class="btn_wrap">
							<!-- 회원가입 -> DB 저장 // 취소 -> 취소되었습니다! 알림 후 index 수정하기 -->
							<input type="submit" id="joinsubmit" value="회원가입">
						</div>
						<div class="btn_wrap2">
							<a href="<c:url value="/index"/>">취소</a>
						</div>
					</div>
				</div>
				<!-- form_txtInput E -->
			</form>
		</div>
		<!-- content E-->
		</form>
	</div>
	<!-- container E -->
	</div>


	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>

</body>

<script>
/* const profilebtn = document.querySelector('.profilebtn');
const realInput = document.querySelector('#realinput');

browseBtn.addEventListener('click',{
	realInput.click();
}); */
</script>

<script>

	//모든 공백 체크 정규식
	var empJ = /\s/g;

	// 이름, 이메일, 비밀번호, 비밀번호 확인, 닉네임, 휴대폰 번호, 생일, 성별 순
	
	// 이름에 특수문자 들어가지 않도록 설정
	console.log('이름 도달');
	// 이름 정규식 : 영어, 한글로만 2~6글자 이내 
	var nameJ = /^[가-힣a-zA-Z]{2,6}$/;
	$("#memname").focusout(function() {
		if (nameJ.test($('#memname').val())) {
				console.log(nameJ.test($('#memname').val()));
				$("#namecheck").text('');
		} else {
			$('#namecheck').text('2~6글자의 한글, 영어만 사용 가능합니다.');
			$('#namecheck').css('color', 'red');
		}
		error : console.log('이름 실패');
	});
	
	// 이메일 -> DB다녀와야함 
	console.log('이메일 도달');
	// 이메일 검사 정규식 : 이메일 형식(ㅇㅇㅇ@ㅇㅇㅇ.ㅇㅇ)
	var mailJ = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	$("#mememail").focusout(function() {
		if (mailJ.test($('#mememail').val())) {
				console.log(mailJ.test($('#mememail').val()));
				$("#emailcheck").text('');
		} else {
			$('#emailcheck').text('이메일 형식으로 입력해주세요.');
			$('#emailcheck').css('color', 'red');
		}
		error : console.log('이메일 실패');
	});
	
	
	// 비밀번호 
	console.log('비번 도달');
	// 비밀번호 정규식 : 영어 대소문자, 숫자로 4~15글자 이내 
	var pwJ = /^[A-Za-z0-9]{4,15}$/;
	$("#mempw").focusout(function() {
		if (pwJ.test($('#mempw').val())) {
				console.log(pwJ.test($('#mempw').val()));
				$("#pwcheck").text('');
		} else {
			$('#pwcheck').text('영어 대, 소문자, 숫자로  4~15글자로 작성해주세요 .');
			$('#pwcheck').css('color', 'red');
		}
		error : console.log('비밀번호 실패');
	});
	
	// 비밀번호 확인 
	$("#mempw2").focusout(function() {
		if ($('#mempw2').val() != $('#mempw').val()) {
				console.log($('#mempw2').val(),$('#mempw').val());
				$("#pwcheck").text('비밀번호가 다릅니다. 다시 입력해주세요.');
				$('#pwcheck').css('color', 'red');
		} else {
			$('#pwcheck').text('');
		} 
		error : console.log('비밀번호 확인 실패');
	});
	
	// 휴대폰 번호
	// 휴대폰 번호 정규식 : 010(필수)+ 숫자로만 8글자
	var phoneJ = /^010([0-9]{8})$/;
	$('#memphone').focusout(function(){
		if(phoneJ.test($('#memphone').val())){
			console.log(phoneJ.test($('#memphone').val()));
			$("#phonecheck").text('');
		} else {
			$('#phonecheck').text('휴대폰번호를 확인해주세요.');
			$('#phonecheck').css('color', 'red');
		}
		error : console.log('휴대폰 번호 실패');
	});
	
	
	// 생년월일
	// 생일 정규식 : 숫자로만 8글자 
	var birthJ = /^[0-9]{8}$/;
	$('#membirth').focusout(function(){
		var dateStr = $('#membirth').val();		
	    var year = Number(dateStr.substr(0,4)); // 입력한 값의 0~4자리까지 (연)
	    var month = Number(dateStr.substr(4,2)); // 입력한 값의 4번째 자리부터 2자리 숫자 (월)
	    var day = Number(dateStr.substr(6,2)); // 입력한 값 6번째 자리부터 2자리 숫자 (일)
	    var today = new Date(); // 날짜 변수 선언
	    var yearNow = today.getFullYear(); // 올해 연도 가져옴
	    
	    if (dateStr.length <=8) {
	    	
			// 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환
		    if (1900 > year || year > yearNow){
		    	
		    	$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
				$('#birthcheck').css('color', 'red');
		    	
		    }else if (month < 1 || month > 12) {
		    		
		    	$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
				$('#birthcheck').css('color', 'red'); 
		    
		    }else if (day < 1 || day > 31) {
		    	
		    	$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
				$('#birthcheck').css('color', 'red'); 
		    	
		    }else if ((month==4 || month==6 || month==9 || month==11) && day==31) {
		    	 
		    	$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
				$('#birthcheck').css('color', 'red'); 
		    	 
		    }else if (month == 2) {
		    	 
		       	var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		       	
		     	if (day>29 || (day==29 && !isleap)) {
		     		
		     		$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
					$('#birthcheck').css('color', 'red'); 
		    	
				}else{
					$('#birthcheck').text('');
					birthJ = true;
				}//end of if (day>29 || (day==29 && !isleap))
		     	
		    }else{
		    	
		    	$('#birthcheck').text(''); 
				birthJ = true;
			}//end of if
			
			}else{
				//1.입력된 생년월일이 8자 초과할때 :  auth:false
				$('#birthcheck').text('8자리 숫자형식으로 정확하게 입력해주세요.');
				$('#birthcheck').css('color', 'red');  
			}
	    
		}); //End of method /*
	
	// 성별 
	$(document).ready(function(){
		$('#gendercheck').focusout(function(){
			invalidItem();
		});
		function invalidItem(){
			if($("input[name=memgender]:radio:checked").length < 1){
				$('#gendercheck').text('성별을 선택해주세요.');
				$('#gendercheck').css('color', 'red');  
			} else {
				$('#gendercheck').text('');
			}
		}
	});

		
		
	
</script>
<!-- alert('입력해주신 이메일로 인증 메일이 발송되었습니다. 이메일 인증을 완료해주세요.') -->

</html>





