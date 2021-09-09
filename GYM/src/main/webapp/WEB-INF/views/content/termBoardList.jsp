<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GymCarry : 약관 및 정책</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp"%>
<link rel="stylesheet" href="/gym/css/term&notice/term&notice.css">

</head>
<body>

	<%@ include file="/WEB-INF/views/frame/header.jsp"%>

	<!-- Content 시작 -->
	
	
	<div id="layoutSidenav_content">
		
			<div class="content">
				<div class="container">
					<h2 class="mb-5">관리자 게시판</h2>

					<div class="table-responsive">

						<table class="table table-striped custom-table">
							<thead>
								<tr>
									<th scope="col">No.</th>
									<th scope="col">카테고리</th>
									<th scope="col">제목 / 내용</th>
									<th scope="col">작성 날짜</th>
									<th scope="col"></th>
								</tr>
							</thead>

							<tbody>
							
							<c:forEach items="${termList}" var="list">

								<tr scope="row">
									<td>${termList.idx}</td>
									<td>${termList.category}</a></td>
									<td>
										<a href="#">${termList.title}</a>
										<small class="d-block text-over-cut">${termList.content}</small>
									</td>
									<td>${termList.date}</td>
									<td><a href="#" class="more">Details</a></td>

								</tr>
							</c:forEach>

							</tbody>
						</table>
					</div>


				</div>

			</div>


			<script src="/gym/js/adminjquery-3.3.1.min.js"></script>
			<script src="/gym/js/admin/popper.min.js"></script>
			<script src="/gym/js/adminbootstrap.min.js"></script>
			<script src="/gym/js/admin/main.js"></script>
	
	
	
	
	
	
	<!-- Content 끝 -->


	<%@ include file="/WEB-INF/views/frame/footer.jsp"%>
</body>
</html>