package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.admin.AllSales;

public interface AdminDashBordDao {
	
	// 전체 매출
	List<AllSales> selectAllSales();

}
