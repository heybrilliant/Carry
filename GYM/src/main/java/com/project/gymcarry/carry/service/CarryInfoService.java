package com.project.gymcarry.carry.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.dao.CarryDao;

@Service
public class CarryInfoService {
	
	@Autowired
	private SqlSessionTemplate template;
	private CarryDao dao;
	
	// 캐리 정보
	public CarryDto getCarryDetail(int crIDX) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryDetail(crIDX);
	}

}
