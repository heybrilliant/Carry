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
								<span>01</span> / 05
							</p>
						</div>
						<h1>PT목적은 무엇인가요?</h1>
					</div>

					<form action="<c:url value='/survey/survey2'/>" method="post">
					<div class="survey_ul">
					
						<ul>
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="다이어트" id="rd1" checked="checked">
								<span>다이어트</span></label>
							</li>
							
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="근력강화" id="rd2" checked="checked">
								<span>근력강화</span></label>
							</li>
							
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="체중증가" id="rd3" checked="checked">
								<span>체중증가</span></label>
							</li>
							
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="체형교정" id="rd4" checked="checked">
								<span>체형교정</span></label>
							</li>
							
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="재활/통증 케어" id="rd5" checked="checked">
								<span>재활/통증 케어</span></label>
							</li>
							
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="바디프로필" id="rd6" checked="checked">
								<span>바디프로필</span></label>
							</li>
						
							<li>
								<label class="box-radio-input">
								<input type="radio" name="sv1" value="대회준비" id="rd7" checked="checked">
								<span>대회준비</span></label>
							</li>
						
						</ul>
					
						
						<div class="next_btn">
							<input type="submit" value="다음">
						</div>
						
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>