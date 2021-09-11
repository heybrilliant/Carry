package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AllSalesDto;

public interface AdminDashBordDao {
	
	// 캐리매출 1~5위
	List<AllSalesDto> selectAllSales(int month);
	
	// 월별 매출
	List<AllSalesDto> selectMonthSales();
	
	// 일별매출
	
	// 년간 매출
	
	
}
