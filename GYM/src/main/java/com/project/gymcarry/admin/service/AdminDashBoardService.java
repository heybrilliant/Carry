package com.project.gymcarry.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.admin.AllSalesDto;
import com.project.gymcarry.dao.AdminDashBordDao;

@Service
public class AdminDashBoardService {
	
	@Autowired
	private SqlSessionTemplate template;
	private AdminDashBordDao dao;
	
	public List<AllSalesDto> getAllSales(int month) {
		dao = template.getMapper(AdminDashBordDao.class);
		return dao.selectAllSales(month);
	}
	
	
}
