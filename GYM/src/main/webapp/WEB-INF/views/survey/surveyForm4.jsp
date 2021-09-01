<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Servey</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/survey/survey.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div id="survey_warp">
		<div class="survey_box">
			<form action="#">
				<div class="survey_box2">
					<div class="survey_h1">
						<div class="survey_page">
							<p>
								<span>04</span> / 05
							</p>
						</div>
						<h1>선호하는 코치 성별</h1>
					</div>
					<div class="servey_ul">
						<ul>
							<li><label class="box-radio-input"> <input
									type="hidden" name="cp_item" checked="checked"> <span></span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="hidden" name="cp_item" checked="checked"> <span></span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>남자</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>여자</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="hidden" name="cp_item" checked="checked"> <span></span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="hidden" name="cp_item" checked="checked"> <span></span></label>
							</li>
						</ul>
						<div class="next_btn">
							<input type="button" value="다음" onclick="location.href='<c:url value="/survey/servey5"/>'">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>