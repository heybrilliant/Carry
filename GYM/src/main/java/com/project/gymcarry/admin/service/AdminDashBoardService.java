package com.project.gymcarry.admin.service;

import java.util.List;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.admin.DashTableDto;

public interface AdminDashBoardService {

	List<AllSalesDto> getAllSales(int month);

	List<AllSalesDto> getMonthSales();

	List<AllSalesDto> getDaySales(int month);

	List<AllSalesDto> getMonthRank();

	List<DashTableDto> getAllDasghTable();

}
