<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
<!--개인 css-->
<link rel="stylesheet" href="/gym/css/mypage/grid.css">

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


<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
</head>
<body>


	<div class="col-right-top-memo">
		<h3>일일 메모</h3>

		<a class="" data-toggle="modal" href="#registerModal1"
			data-backdrop="static"><img onclick="printName()"
			class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>

	</div>

	<div class="col-right-left">
		<h3>눈 바디</h3>
		<a class="" data-toggle="modal" href="#registerModal2"
			data-backdrop="static"><img class="edit_text"
			src="<c:url value="/images/icon/upload.png"/>"></a>
	</div>

	<div class="col-right-right">
		<h3>몸무게</h3>
		<a class="" data-toggle="modal" href="#registerModal3"
			data-backdrop="static"> <img class="edit_text"
			src="<c:url value="/images/icon/edit.png"/>"></a>
	</div>

	<div class="col-right-right2">
		<h3>식단</h3>
		<a class="" data-toggle="modal" href="#registerModal4"
			data-backdrop="static"><img class="edit_text"
			src="<c:url value="/images/icon/edit.png"/>"></a>
	</div>

	<section>
		<div class="modal fade" id="registerModal1" tabindex="-1"
			role="dialog" aria-labelledby="modal4" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h3>일일 메모</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="close">
							<span aria-hidden="true"> X </span>
						</button>

					</div>
					<form id="memoform" name="memoform" class="reg_form" method="post">
						<div class="modal-body modal-mypage">
							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control memo_input" name="infocontent"
										id="infocontent" style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<input type="submit" value="등록" class="write_btn" id="write_btn"
									onClick="fn_review()">
							</div>
							<input type="text" id="infodate" name="infodate" /> <input
								type="text" id="memidx" name="memidx" value="${memidx}" /> <input
								type="text" name="infotype" id="infotype" value="memo" />
						</div>
					</form>

				</div>
			</div>
		</div>

		<div class="modal fade" id="registerModal2" tabindex="-1"
			role="dialog" aria-labelledby="modal4" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h3>눈바디</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="close">
							<span aria-hidden="true"> X </span>
						</button>

					</div>
					<form>
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<button class="btn" type="button" id="">확인</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="registerModal3" tabindex="-1"
			role="dialog" aria-labelledby="modal4" aria-hidden="true">
			<div class="modal-dialog modal-kg">
				<div class="modal-content">
					<div class="modal-header">

						<h3>몸무게</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="close">
							<span aria-hidden="true"> X </span>
						</button>

					</div>
					<form class="reg_form3">
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="editor"> <input class="form-control"
									name="contents" maxlength="3" id="contents">

								</span>
								<div class="modal-kg-kg">
									<h1>kg</h1>
								</div>


							</div>

							<div class="btn modal-submit-btn">
								<button class="btn" type="button">확인</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="registerModal4" tabindex="-1"
			role="dialog" aria-labelledby="modal4" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">

						<h3>식단</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="close">
							<span aria-hidden="true"> X </span>
						</button>

					</div>
					<form class="reg_form4">
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<button class="btn" type="button"">확인</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</section>
</body>


</html>

