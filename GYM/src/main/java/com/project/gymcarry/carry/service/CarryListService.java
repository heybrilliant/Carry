package com.project.gymcarry.carry.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.dao.CarryDao;

@Service
public class CarryListService {

	@Autowired
	private SqlSessionTemplate template;
	private CarryDao dao;

	// 매칭 캐리리스트 - 여자
	public List<CarryDto> getCarryListF(){
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryListF();
	}
	
	// 매칭 캐리리스트 - 남자
	public List<CarryDto> getCarryListM(){
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryListM();
	}
	
	
	
}
