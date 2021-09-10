package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AllSalesDto;

public interface AdminDashBordDao {
	
	// 전체 매출
	List<AllSalesDto> selectAllSales(int month);

}
