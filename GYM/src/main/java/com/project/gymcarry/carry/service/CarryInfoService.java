package com.project.gymcarry.carry.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryAllDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.dao.CarryDao;

@Service
public class CarryInfoService {
	
	@Autowired
	private SqlSessionTemplate template;
	private CarryDao dao;
	
	// 캐리 정보
	public CarryAllDto getCarryDetail(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryDetail(cridx);
	}
	
	// 캐리 리뷰 리스트
	public List<CarryReviewDto> getCarryReviewList(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryReviewList(cridx);
	}
	
	

}
