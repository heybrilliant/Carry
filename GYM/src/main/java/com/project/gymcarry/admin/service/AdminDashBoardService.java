package com.project.gymcarry.admin.service;

import java.util.List;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.admin.DashTableAddDto;
import com.project.gymcarry.admin.DashTableDto;

public interface AdminDashBoardService {

	// 전체그래프
	List<AllSalesDto> getAllSales(int month);

	// 월별그래프
	List<AllSalesDto> getMonthSales();

	// 요일별그래프
	List<AllSalesDto> getDaySales(int month);
	
	// 1~5위
	List<AllSalesDto> getMonthRank();
	
	// 전체테이블리스트
	List<DashTableDto> getAllDasghTable();
	
	// 최근요일별 리스트
	List<DashTableAddDto> getDayTable(int month);

}
