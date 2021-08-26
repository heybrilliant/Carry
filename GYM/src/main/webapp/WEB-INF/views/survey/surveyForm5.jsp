<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Servey</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/survey.css">
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
								<span>05</span> / 05
							</p>
						</div>
						<h1>지역을 선택해주세요</h1>
					</div>
					<div class="servey_ul">
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
							<input type="button" value="다음">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>