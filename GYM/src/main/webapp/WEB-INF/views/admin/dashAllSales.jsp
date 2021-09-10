<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>DashBoard : GymCarry Admin</title>
<link rel="stylesheet" href="/gym/css/admin/adminStyle.css">
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed" id="sb-nav">

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header_admin.jsp"%>
	<!-- sidebar -->
	<%@ include file="/WEB-INF/views/frame/sidebar_admin.jsp"%>


	<!-- 컨텐츠 시작 -->
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">전체매출</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="<c:url value="/admin/dashboard"/>">Dashboard</a></li>
					<li class="breadcrumb-item active">전체매출</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">
						GymCarry의 전체매출 그래프 입니다. 
						<select name="month" id="select_month">
							<option value="1">1월</option>								
							<option value="2">2월</option>								
							<option value="3">3월</option>								
							<option value="4">4월</option>								
							<option value="5">5월</option>								
							<option value="6">6월</option>								
							<option value="7">7월</option>								
							<option value="8">8월</option>								
							<option value="9">9월</option>								
							<option value="10">10월</option>								
							<option value="11">11월</option>								
							<option value="12">12월</option>								
						</select>
					</div>
				</div>
				<div class="card mb-4">
					<div class="card-header">
						<i class="fas fa-chart-area me-1"></i> Area Chart Example
					</div>
					<div class="card-body">
						<canvas id="myAreaChart" width="100%" height="30"></canvas>
					</div>
					<div class="card-footer small text-muted">Updated yesterday
						at 11:59 PM</div>
				</div>
				<div class="row">
					<div class="col-lg-6">
						<div class="card mb-4">
							<div class="card-header">
								<i class="fas fa-chart-bar me-1"></i> Bar Chart Example
							</div>
							<div class="card-body">
								<canvas id="myBarChart" width="100%" height="50"></canvas>
							</div>
							<div class="card-footer small text-muted">Updated yesterday
								at 11:59 PM</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card mb-4">
							<div class="card-header">
								<i class="fas fa-chart-pie me-1"></i> Pie Chart Example
							</div>
							<div class="card-body">
								<canvas id="myPieChart" width="100%" height="50"></canvas>
							</div>
							<div class="card-footer small text-muted">Updated yesterday
								at 11:59 PM</div>
						</div>
					</div>
				</div>
			</div>
		</main>
		<!-- footer -->
		
		
		    
		<script>
		$('#select_month').change(function(){
		    var total = [];
		    var crname = [];
		    var month = [];
		    var select = $('#select_month').val();
		       $.ajax({
		          type : 'get',
		          url : '<c:url value="/admin/allSaleMan"/>',
		          dataType : 'json',
		          data : {
		             month : select
		          },
		          success : function(data){
		          $.each(data, function(index, item){
		             total.push(item.total);
		             crname.push(item.crname);
		             month.push(item.month);
		          }); 
		          $('#sb-nav').html();
		          getPie(total, crname, month);
		          }
		       });
		 });
			
		</script>          
        
        
		<%@ include file="/WEB-INF/views/frame/footer_admin.jsp"%>
		
	</div>
		
		
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="/gym/js/scripts.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="/gym/js/assets/demo/chart-area-demo.js"></script>
        <script src="/gym/js/assets/demo/chart-bar-demo.js"></script>
        <script src="/gym/js/assets/demo/chart-pie-demo.js"></script>
    
        
</body>
</html>

