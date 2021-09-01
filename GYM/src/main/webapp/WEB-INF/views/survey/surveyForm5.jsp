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
								<span>05</span> / 05
							</p>
						</div>
						<h1>지역을 선택해주세요</h1>
					</div>
					<%-- <form action="<c:url value='/survey/survey2'/>" method="post"> --%>
					<form action="<c:url value='/carry/carryLists'/>" method="get">
					<div class="survey_ul">
						<div class="next_btn">
							<div class="select_op">
								<select>
									<option>강남구</option>
									<option>구로구</option>
									<option>금천구</option>
									<option>동대문구</option>
									<option>마포구</option>
									<option>서대문구</option>
									<option>성북구</option>
									<option>서초구</option>
									<option>송파구</option>
									<option>은평구</option>
								</select>
							</div>
							<input type="submit" value="결과 보기">
						</div>
						<input type="hidden" value="${sv1}" name="sv1">
						<input type="hidden" value="${sv4}" name="sv4">
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>