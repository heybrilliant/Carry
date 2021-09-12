<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>DashBoard : GymCarry Admin</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link rel="stylesheet" href="/gym/css/admin/adminStyle.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header_admin.jsp"%>
	<!-- sidebar -->
	<%@ include file="/WEB-INF/views/frame/sidebar_admin.jsp"%>



	<!-- 컨텐츠 시작 -->
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">대시보드</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">Dashboard</li>
				</ol>
				<div class="row">
					<div class="col-xl-3 col-md-6">
						<div class="card bg-primary text-white mb-4">
							<div class="card-body">2021년 월별 총 매출</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link" href="#">View
									2021년 월별 총 매출</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-warning text-white mb-4">
							<div class="card-body">최근 월별 총 매출</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link a_month" href="#">View
									월별 총 매출</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-success text-white mb-4">
							<div class="card-body">최근 요일 별 매출</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link a_rank" href="javascript:callDay(${date});">View
									요일 별 매출</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-3 col-md-6">
						<div class="card bg-danger text-white mb-4">
							<div class="card-body">최근 월별 캐리 매출 판매왕!</div>
							<div
								class="card-footer d-flex align-items-center justify-content-between">
								<a class="small text-white stretched-link a_year" href="#">View
									월별 캐리 매출 판매왕!</a>
								<div class="small text-white">
									<i class="fas fa-angle-right"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-6">
						<div class="card mb-4">
							<div class="card-header">
								<i class="fas fa-chart-area me-1"></i> 2021년 월별 총 매출
							</div>
							<div class="card-body">
								<canvas id="myAreaChart" width="100%" height="40"></canvas>
							</div>
						</div>
					</div>
					<div class="col-xl-6">
						<div class="card mb-4">
							<div class="card-header">
								<i class="fas fa-chart-bar me-1"></i> <span class="nums">2021년 월별 판매왕!</span> 
							</div>
							<div class="card-body">
								<canvas id="myBarChart" width="100%" height="40"></canvas>
							</div>
						</div>
					</div>
				</div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-table me-1"></i> DataTable Example
					</div>
					<div class="card-body">
						<table id="datatablesSimple">
							<thead>
								<tr>
									<th>결제자 명</th>
									<th>결제자 연락처</th>
									<th>결제 수업횟수</th>
									<th>캐리 이름</th>
									<th>결제 날짜</th>
									<th>결제 금액</th>
								</tr>
							</thead>
							<tbody class="addList">
							</tbody>
							<%-- <c:forEach items="${allDashTable}" var="list">
							<tbody class="addList">
								<tr>
									<td>${list.payname}</td>
									<td>${list.payphone}</td>
									<td>${list.paynum}</td>
									<td>${list.crname}</td>
									<td>${list.paydate}</td>
									<td>₩ ${list.payprice}</td>
								</tr>
							</tbody>
							</c:forEach> --%>
						</table>
					</div>
				</div>
			</div>
		</main>
		
		<!-- footer -->
		<%@ include file="/WEB-INF/views/frame/footer_admin.jsp"%>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="/gym/js/scripts.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="/gym/js/assets/demo/chart-area-demo.js"></script>
    <script src="/gym/js/assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="/gym/js/datatables-simple-demo.js"></script>
	<script>
    var total = [];
    var month = [];
       $.ajax({
          type : 'get',
          url : '<c:url value="/admin/dash"/>',
          dataType : 'json',
          success : function(data){
          $.each(data.monthDash, function(index, item){
        	  total.push(item.total);
        	  month.push(item.engmonth);
          });
          getArea(total, month);
          
          total = [];
          month = [];
          $.each(data.rankDash, function(index, item){
        	  total.push(item.total);
        	  month.push(item.engmonth);
          });
          getBar(total, month);
          
          }
       });
       
       
	function callDay(num){
		var day = [];
		var sum = [];
		$.ajax({
			type : 'get',
	        url : '<c:url value="/admin/daylist"/>',
	        dataType : 'json',
	        data : { month:num },
	        success : function(data){
	        		var html = '<tr>'
	        	$.each(data.dayList, function(index, item){
	        		    html += '<td>'+ item.payname +'</td>'
	        		    html += '<td>'+ item.payphone +'</td>'
	        		    html += '<td>'+ item.paynum +'</td>'
	        		    html += '<td>'+ item.crname +'</td>'
	        		    html += '<td>'+ item.paydate +'</td>'
	        		    html += '<td>₩ '+ item.payprice +'</td>'
	        		    html += '</tr>'
	        	});
	        		$(".addList").html(html);
	        	
	        	$.each(data.dayDash, function(index, item){
	        		sum.push(item.total);
	        		day.push(item.day);
	        	});
	        	getBar(sum, day);
	        	sum.unshift(0);
	            day.unshift(0);
	            getArea(sum, day);
	        	$(".nums").html('최근 요일 별 매출 입니다.');
	        }
		});
	};
	
    </script>
    
</body>
</html>

