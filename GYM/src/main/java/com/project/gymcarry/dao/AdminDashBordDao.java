package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.admin.DashTableAddDto;
import com.project.gymcarry.admin.DashTableDto;

public interface AdminDashBordDao {

	// 캐리매출 1~5위
	List<AllSalesDto> selectAllSales(int month);

	// 월별 매출
	List<AllSalesDto> selectMonthSales();

	// 일별매출
	List<AllSalesDto> selectDaySales(int month);

	// 월별 캐리매출 1위
	List<AllSalesDto> selectMonthRank();
	
	// 매출테이블 전체리스트
	List<DashTableDto> selectAllDashTable();
	
	// 요일별 테이블 리스트
	List<DashTableAddDto> selectDayTable(int month);
	

}
