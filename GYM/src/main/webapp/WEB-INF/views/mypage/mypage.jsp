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
<script>
	function printName() {
		const name = document.getElementById('alternate').value;
		var infodate = document.getElementsByName("infodate")

		infodate[0].value = name;
		infodate[1].value = name;
		infodate[2].value = name;
		infodate[3].value = name;
	}

	function reviewList() {

		$.ajax({
			url : '<c:url value="/myapge/select"/>',
			type : 'POST',
			datatype : 'JSON',
			data : {
				cridx : $("# EMPTY ").val()
			},
			success : function(data) {
				var tag = '<div>'
				$.each(data, function(index, item) {

				});

				$('#TEST').html(tag);
			},

			error : function() {
				alert("error");

			}

		});

	}
</script>




</head>
<body style="padding-right: 0px">
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div class="contents_main">
		<div class="contents">

			<div class="col">

				<div class="col-right-top">
					<h2 style="float: none;">
						<input type="text" id="alternate" class="datepick" size="30"
							readonly>
					</h2>
				</div>
				<div class="col-flex">
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

							<div id="datepicker" onclick="printName()"></div>
						</div>

						<div class="my-info-develope">
							<h3 class="info_title">My page</h3>
							<ul class="info_contents">
								<li data-tab="info" class="list_tab info_list" id="default"><a>내
										메모</a></li>

								<li class="info_list"><a
									href="<c:url value="/mypage/myinfo"/>">내 기본 정보 수정</a></li>

								<li class="info_list"><a
									href="<c:url value="/mypage/mycommunity"/>">내가 작성한 글</a></li>

								<li data-tab="mycash" class="list_tab info_list"><a>내
										결제 내역</a></li>

								<li class="info_list"><a
									href="<c:url value="/mypage/mycarry"/>">내가 찜한 캐리</a></li>

							</ul>
						</div>
					</div>
					<div class="col-right"></div>
				</div>

			</div>

		</div>
	</div>
</body>

<footer>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</footer>
<!-- 탭 ajax-->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script>
	$(function() {
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

			});
		});

		$('#default').click();

		$.datepicker.setDefaults({
			dateFormat : 'yymmdd',
			prevText : '이전 달',
			nextText : '다음 달',
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
					'9월', '10월', '11월', '12월' ],
			dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			showMonthAfterYear : true,
			yearSuffix : '년',
			currentText : '오늘 날짜'
		});

		$("#datepicker").datepicker({
			altField : "#alternate",
			altFormat : "yy년 mm월 dd일"

		});

	});
</script>


</html>

