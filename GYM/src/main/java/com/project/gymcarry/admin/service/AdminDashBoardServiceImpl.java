package com.project.gymcarry.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.admin.DashTableDto;
import com.project.gymcarry.dao.AdminDashBordDao;

@Service
public class AdminDashBoardServiceImpl {
	
	@Autowired
	private SqlSessionTemplate template;
	private AdminDashBordDao dao;
	
	public List<AllSalesDto> getAllSales(int month) {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectAllSales(month);
	}

	public List<AllSalesDto> getMonthSales() {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectMonthSales();
	}

	public List<AllSalesDto> getDaySales(int month) {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectDaySales(month);
	}

	public List<AllSalesDto> getMonthRank() {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectMonthRank();
	}

	public List<DashTableDto> getAllDasghTable() {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectAllDashTable();
	}
	
	
}
