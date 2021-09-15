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

</style>
</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>


	<!-- 은경 -->

	<div class="wrap wd668">
		<div class="form_txtInput">

			<form action="<c:url value="/carry/carryLogin"/>" method="post">
				<h1 class="sub_tit_txt">캐리 로그인</h1>
				<div class="login_form">
					<table>
						<colgroup>
							<col width="30%" />
							<col width="auto" />
						</colgroup>
						<tbody>
							<tr>
								<th><span>아이디</span></th>
								<td><input type="text" name="cremail"
									value="${cookie.reid.value}"></td>
							</tr>
							<tr>
								<th><span>비밀번호</span></th>
								<td><input type="password" name="crpw"></td>
							</tr>
						</tbody>
					</table>


					<div class="selectbox">
						<input type="checkbox" value="on" id="recremail"
							${cookie.recremail ne null? 'checked' : ''}> 아이디 기억하기 <input
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