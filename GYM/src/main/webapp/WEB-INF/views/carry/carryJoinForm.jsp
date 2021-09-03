<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>캐리 회원가입</title>

<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/joinlogin/regform.css">

</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- 은경 -->

	<!-- Contents -->
	<div class="wrap wd668">
		<div class="container">
			<form method="post">
				<%-- <form action="<c:url value="/member/carryJoin"/>" method="post"
					enctype="multipart/form-data"> --%>
				<div class="form_txtInput">
					<h1 class="sub_tit_txt">캐리 회원가입</h1>
					<p class="exTxt">회원가입시 이메일 인증을 반드시 진행하셔야 합니다.</p>


					<div class="join_form">
						<div class="profile_form">
							<img src="/gym/images/icon/profile.png"><br> <a
								href="<input type=" file" name="carryphoto" name="crphoto">">프로필
								사진 등록</a>
						</div>
						<table>
							<colgroup>
								<col width="30%" />
								<col width="auto" />
							</colgroup>
							<tbody>
								<tr>
									<th><span>이름</span></th>
									<td><input type="text" name="crname" placeholder=""></td>
								</tr>

								<tr class="email">
									<th><span>이메일</span></th>
									<td><input type="text" class="email" name="cremail"
										placeholder="id@email.com/net 형식으로 입력해주세요."> <!-- <a href="javascript:;" class="btn_confirm">인증메일 발송</a> -->
									</td>
								</tr>

								<tr>
									<th><span>비밀번호</span></th>
									<td><input type="password" name="crpw"
										placeholder="비밀번호를 입력해주세요."></td>
								</tr>
								<tr>
									<th><span>비밀번호 확인</span></th>
									<td><input type="password" placeholder="비밀번호를 확인하세요"></td>
								</tr>

								<!-- <tr>
									<th><span>소속플레이스</span></th>
									<div class="place">
										<button type="submit">
											<a href="#"><img src="/gym/images/icon/search_icon.png"
												alt="search"></a>
										</button>
										<td><input type="text" name="placename" placeholder=""></td>
										쿼리문 수정되면  name="placename" 추가 여부 확인
									</div>
								</tr> -->

								<tr>
									<th><span>닉네임</span></th>
									<td><input type="text" name="crnick" placeholder=""></td>
								</tr>

								<tr>
									<th><span>휴대폰 번호</span></th>
									<td><input type="text" name="crphone" placeholder="11자리 형식의 숫자로만 입력해주세요."></td>
								</tr>

								<!-- <tr>
									<th><span>생년월일</span></th>
									<td><input type="text" placeholder="8자리 형식의 숫자로만 입력해주세요."></td>
								</tr> -->
								<tr>
									<th><span>성별</span></th>
									<td>
										<div class="selectbox">
											<input type="radio" name="crgender" value="남자"> 남자 <input
												type="radio" name="crgender" value="여자"> 여자
										</div>
									</td>
								</tr>
							</tbody>
						</table>
			</form>
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
	</div>
	<!-- content E-->
	</form>

	</div>
	<!-- container E -->
	</div>

	<!-- Contents end -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>





