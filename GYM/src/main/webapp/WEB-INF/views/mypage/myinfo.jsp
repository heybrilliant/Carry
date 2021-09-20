<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Myinfo</title>


<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"
	integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
	crossorigin="anonymous"></script>
<!--제이쿼리 CDN-->

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/gym/css/mypage/bootstrap.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="/gym/css/mypage/infoupdate.css">


<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>

</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<script>
		function loginLog() {
			printName()
			$.ajax({
				type : "POST",
				url : '<c:url value="/mypage/mypass"/>',
				dataType : 'JSON',

				data : {
					arg0 : $("#memidx").val(),
					arg1 : $("#infodate").val()
				},

				success : function(data) {
					console.log(data);
				},
				error : function() {

					alert("error");

				}
			});
		}
	</script>


	<div class="contents_main">
		<div class="contents">

			<div class="col">

				<form action="<c:url value='/mypage/myinfoUpdate'/>" method="post">

					<c:forEach items="${memberList}" var="memberList">
						<input type="hidden" name="MEMIDX" id="MEMIDX"
							value="${memberList.MEMIDX}">

						<div class="my-info">
							<img id="loadingimg" class="display_none"
								src="/gym/images/icon/user.png">
							<h3>사진 수정</h3>
						</div>

						<div class="col-2">
							<div class="col-3">
								<h3>이름</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input value="${memberList.MEMNAME}" type="text"
									class="readonly" readonly />
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>이메일 주소</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input value="${memberList.MEMEMAIL}" type="text"
									class="readonly" readonly>
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>비밀번호 수정</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input type="text">
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>비밀번호 수정 확인</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input type="text">
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>닉네임</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input name="MEMNICK" id="MEMNICK" value="${memberList.MEMNICK}"
									type="text">
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>핸드폰 번호</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input name="MEMPHONE" id="MEMPHONE"
									value="${memberList.MEMPHONE}" type="text">
							</div>
						</div>
						<div class="col-2">
							<div class="col-3">
								<h3>생년월일</h3>
							</div>
							<div class="col-9" style="float: right;">
								<input value="${memberList.MEMBIRTH}" type="text"
									class="readonly" readonly>
							</div>
						</div>
						<div class="col-2"
							style="margin-top: 7%; width: 100%; display: flex;">
							<div class="col-2" style="width: 50%; margin: auto;">
								<div class="col-2"
									style="width: 50%; /* margin: auto; */ /* padding: 10%; */ float: left;">
									<input value="수정" class="btn on" type="submit" id="reg_submit">
								</div>
								<div class="col-2"
									style="width: 50%; /* margin: auto; */ /* padding: 10%; */ float: right;">
									<a href="javascript:window.history.back();"> <input
										value="취소" class="btn off" type="button" id="reg_submit">
									</a>
								</div>
							</div>
						</div>
					</c:forEach>
				</form>
			</div>
		</div>
	</div>

</body>

<footer>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</footer>

</html>

