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

<!-- 탭 ajax-->
<script>
	$(function() {
		// 탭 오퍼레이터	
		$('.list_tab').click(function() {

			var activeTab = $(this).attr('data-tab');
			$.ajax({
				type : 'GET',
				url : activeTab,
				dataType : "html",

				success : function(data) {
					$('.col-right').html(data);

				},

				error : function() {

					alert('나가 임마');
				},

			})
		})
		$('#default').click();
	})
</script>


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
								<h3>${name}</h3>
								<!-- 세션 네임 -->


							</div>
							<div style="text-align: left; width: 35%; padding-left: 2%">
								<img class="edit_text2"
									src="<c:url value="/images/icon/edit.png"/>">
							</div>
						</div>


						<script
							src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
						<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
						<script>
							$.datepicker
									.setDefaults({
										dateFormat : 'yymmdd',
										prevText : '이전 달',
										nextText : '다음 달',
										monthNames : [ '1월', '2월', '3월', '4월',
												'5월', '6월', '7월', '8월', '9월',
												'10월', '11월', '12월' ],
										monthNamesShort : [ '1월', '2월', '3월',
												'4월', '5월', '6월', '7월', '8월',
												'9월', '10월', '11월', '12월' ],
										dayNames : [ '일', '월', '화', '수', '목',
												'금', '토' ],
										dayNamesShort : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										dayNamesMin : [ '일', '월', '화', '수',
												'목', '금', '토' ],
										showMonthAfterYear : true,
										yearSuffix : '년'
									});

							$(function() {
								$("#datepicker").datepicker({
									altField : "#alternate",
									altFormat : "yy - MM - dd"

								});
							});
						</script>
						<div id="datepicker"></div>
					</div>

					<div class="my-info-develope">
						<h3 class="info_title">My page</h3>
						<ul class="info_contents">
							<li data-tab="info" class="list_tab info_list">내 일정</li>

							<li class="info_list"><a
								href="<c:url value="/mypage/myinfo"/>">내 기본 정보 수정</a></li>

							<li class="info_list"><a
								href="<c:url value="/mypage/mycommunity"/>">내가 작성한 글</a></li>

							<li data-tab="mycash" class="list_tab info_list" id="default"><a
								href="#">내 결제 내역</a></li>

							<li class="info_list"><a href="#">내가 찜한 캐리</a></li>
						</ul>
					</div>
				</div>
				<div class="col-right"></div>
			</div>
		</div>
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
					<form class="reg_form">
						<div class="modal-body modal-mypage">

							<div class="content">
								<span class="left"></span> <span class="editor"> <textarea
										class="form-control" name="contents" id="contents"
										style="resize: none;"></textarea>
								</span>
							</div>
							<div class="btn modal-submit-btn">
								<button class="btn" type="button" id="reg_submit">확인</button>
							</div>
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

						<h3>일일 메모</h3>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="close">
							<span aria-hidden="true"> X </span>
						</button>

					</div>
					<form class="reg_form2">
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
								<button class="btn" type="button"">확인</button>
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

<footer>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</footer>

</html>

