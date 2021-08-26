<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Servey</title>




<link rel="stylesheet" href="/gym/css/grid.css">

<!-- jQuery -->
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>

<!-- bootstrap -->
<link rel="stylesheet" href="/gym/css/bootstrap.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>


</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div class="contents_main">
		<div class="contents">

			<div class="col">
				<div class="col-left">

					<div class="my-info">

						<div class="col-profile">
							<img id="loadingimg" class="display_none"
								src="<c:url value="/images/icon/user.png"/>">

						</div>

						<div class="col-name">
							<div style="text-align: right; width: 55%; float: left;">
								<h3>이름</h3>
							</div>
							<div style="text-align: left; width: 35%; padding-left: 2%">버튼</div>
						</div>

						<div class="col-profile"></div>


					</div>
					<div class="my-info-develope">
						<h3 class="info_title">My page</h3>
						<ul class="info_contents">

							<li class="info_list"><a href="#">내 기본 정보 수정</a></li>
							<li class="info_list"><a href="#">내가 작성한 글</a></li>
							<li class="info_list"><a href="#">내 결제 내역</a></li>
							<li class="info_list"><a href="#">내가 찜한 캐리</a></li>
						</ul>
					</div>
				</div>
				<div class="col-right">





					<div class="col-right-top">
						<h2>2021-08-23</h2>
					</div>
					<div class="col-right-top-memo">
						<h3>일일 메모</h3>

						<a class="" data-toggle="modal" href="#registerModal1"><img
							class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>

					</div>


					<div class="col-right-left">
						<h3>눈 바디</h3>
						<a class="" data-toggle="modal" href="#registerModal2"><img
							class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

					<div class="col-right-right">
						<h3>몸무게</h3>
						<a class="" data-toggle="modal" href="#registerModal3"><img
							class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

					<div class="col-right-right2">
						<h3>식단</h3>
						<a class="" data-toggle="modal" href="#registerModal4"><img
							class="edit_text" src="<c:url value="/images/icon/edit.png"/>"></a>
					</div>

				</div>
			</div>
			<div class="modal fade" id="registerModal1" tabindex="-1"
				role="dialog" aria-labelledby="modal4" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">

							<h3>2021-08-23 1</h3>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="close">
								<span aria-hidden="true"> X </span>
							</button>

						</div>
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<input type="submit" value="작성 완료">
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="registerModal2" tabindex="-1"
				role="dialog" aria-labelledby="modal4" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">

							<h3>2021-08-23 2</h3>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="close">
								<span aria-hidden="true"> X </span>
							</button>

						</div>
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<input type="submit" value="작성 완료">
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="registerModal3" tabindex="-1"
				role="dialog" aria-labelledby="modal4" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">

							<h3>2021-08-23 3</h3>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="close">
								<span aria-hidden="true"> X </span>
							</button>

						</div>
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<input type="submit" value="작성 완료">
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="modal fade" id="registerModal4" tabindex="-1"
				role="dialog" aria-labelledby="modal4" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">

							<h3>2021-08-23 4</h3>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="close">
								<span aria-hidden="true"> X </span>
							</button>

						</div>
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<input type="submit" value="작성 완료">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</body>

<footer>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</footer>

</html>

