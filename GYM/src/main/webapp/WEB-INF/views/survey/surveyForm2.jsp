<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>당신과 어울리는 캐리는?</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/survey/survey.css">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<div id="survey_wrap">
		<div class="survey_box">
			<div class="formstyle">
				<div class="survey_box2">
					<div class="survey_h1">
						<div class="survey_page">
							<p>
								<span>02</span> / 05
							</p>
						</div>
						<h1>당신의 연령대는 ?</h1>
					</div>
					
					<form action="<c:url value='/survey/survey3'/>" method="post">
					<div class="survey_ul">
						<ul>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>15~19세</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>20~24세</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>25~29세</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>30~34세</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>35~39세</span></label>
							</li>
							<li><label class="box-radio-input"> <input
									type="radio" name="cp_item" checked="checked"> <span>40~50세</span></label>
							</li>
						</ul>
						<div class="next_btn">
							<input type="submit" value="다음">
						</div>
					</div>
					<input type="hidden" value="${sv1}" name="sv1">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>