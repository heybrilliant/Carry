<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>DashBoard : GymCarry Admin</title>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>

<script src="/gym/js/scripts.js"></script>
<script src="/gym/js/datatables-simple-demo.js"></script>
<script src="/gym/assets/demo/chart-area-demo.js"></script>
<script src="/gym/assets/demo/chart-bar-demo.js"></script>
        
<%@ include file="/WEB-INF/views/frame/metaheader_admin.jsp"%>
<link rel="stylesheet" href="/gym/css/admin/adminStyle.css">

    <body class="sb-nav-fixed">

	<!-- header -->
	<%@ include file="/WEB-INF/views/frame/header_admin.jsp"%>
	<!-- sidebar -->
	<%@ include file="/WEB-INF/views/frame/sidebar_admin.jsp"%>



	<!-- 컨텐츠 시작 -->
            <div id="layoutSidenav_content">
                <div class="container-fluid px-4">
                    <h1 class="mt-4">대시보드</h1>
                    <ol class="breadcrumb mb-4">
                        <li class="breadcrumb-item"><a href="#">Dashboard</a></li>
                    </ol>
                    <div class="card mb-4">
                        <div class="card-body">
                           	GymCarry DashBoard
                        </div>
                    </div>
                   
                <div>



                        </div>


                </div>
                
                
		<!-- footer -->
		<%@ include file="/WEB-INF/views/frame/footer_admin.jsp"%>
		
		
		
</body>
</html>
		
		