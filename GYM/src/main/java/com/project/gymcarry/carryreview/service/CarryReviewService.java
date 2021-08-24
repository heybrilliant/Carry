package com.project.gymcarry.carryreview.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carryreview.CarryReviewDto;
import com.project.gymcarry.dao.CarryReviewDao;

@Service
public class CarryReviewService {
	
	@Autowired
	private SqlSessionTemplate template;
	private CarryReviewDao dao;
	
	// 리뷰 리스트
	public List<CarryReviewDto> getCarryReview(int crIDX) {
	dao = template.getMapper(CarryReviewDao.class);
	return dao.selectCarryReview(crIDX);
	}
}
