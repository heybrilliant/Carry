<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캐리 로그인</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/joinlogin/loginform.css">

</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- Contents -->
	<div class="wrap wd668">
		<div class="form_txtInput">

			<form action="<c:url value="/carry/carryLogin"/>" method="post">
				<h1 class="sub_tit_txt">캐리 로그인</h1>
				<div class="login_form">
	
					<div class="tb">
						<div id="catebox">
							<label id="cate"><grid>이메일</grid></label>
						</div>
						
						<input type="text" id="into" name="cremail">
						<div class="check_font" id="emailcheck" style=float:left></div>
					</div>

					<div class="tb">
						<div id="catebox">
							<label id="cate"><grid>비밀번호</grid></label>
						</div>
						
						<input type="password" id="into" name="crpw">
						<div class="check_font" id="pwcheck"></div>
					</div>


					<div class="selectbox">
						<input type="checkbox" value="on" id="recremail"
							${cookie.recremail ne null? 'checked' : ''}> 이메일 기억하기 <input
							type="hidden" name="redirectUri"
							value="${redirectUri ne null ? redirectUri : ''}">
					</div>

					<div id="btnbox">
						<div class="btn_wrap">
							<!-- <a input type="submit" value="로그인">로그인</a> -->
							<input type="submit" id="loginbtn" value="로그인">
						</div>
						<a id="alter" href="<c:url value="/member/login"/>">멤버로그인</a><br>
						<!-- 언더라인, 캐리로그인 변환 링크 -->
					</div>
				</div>
				<!-- login_form E  -->
			</form>

			<hr>
			<div class="change">
				<ul>
					<li><a href="<c:url value="/carry/join"/>">캐리 회원가입</a></li>
					<li class="tab2"><a href="<c:url value="/find/findcarryid"/>">캐리 아이디
							찾기</a></li>
					<li class="tab2"><a href="<c:url value="/find/findcarrypassword"/>">캐리 비밀번호
							찾기</a></li>
				</ul>
			</div>
		</div>
		<!-- form_txtInput E -->
	</div>
	<!-- content E-->

	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>