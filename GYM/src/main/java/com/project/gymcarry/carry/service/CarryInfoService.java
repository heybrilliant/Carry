package com.project.gymcarry.carry.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.carry.CarryCertiDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.dao.CarryDao;
import com.project.gymcarry.place.PlaceDto;

@Service
public class CarryInfoService {

	@Autowired
	private SqlSessionTemplate template;
	private CarryDao dao;

	// 캐리 정보
	public CarryDto getCarryDetail(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryDetail(cridx);
	}

	// 캐리 수업 가격 정보
	public CarryPriceDto getCarryPrice(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryPrice(cridx);
	}

	// 캐리 자격 및 경력 정보
	public CarryCertiDto getCarryCerti(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryCerti(cridx);
	}

	// 캐리 리뷰 리스트
	public List<CarryReviewDto> getCarryReviewList(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryReviewList(cridx);
	}

	// 플레이스 정보(캐리 상세페이지 내)
	public PlaceDto getCarryPlaceInfo(int cridx) {
		dao = template.getMapper(CarryDao.class);
		return dao.selectCarryPlaceDetail(cridx);
	}

	// 캐리 리뷰 등록
	public int addCarryReview(CarryReviewDto reviewDto) {
		dao = template.getMapper(CarryDao.class);
		return dao.addCarryReview(reviewDto);
	}

	
}
