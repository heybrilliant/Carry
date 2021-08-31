package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.carry.CarryCertiDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.place.PlaceDto;

public interface CarryDao {
	
	// 캐리 전체 정보
	CarryDto selectCarryDetail(int cridx);
	// 캐리 프로그램별 가격 정보 (전체)
	CarryPriceDto selectCarryPrice(int cridx);
	// 캐리 자격 및 경력 정보
	CarryCertiDto selectCarryCerti(int cridx);
	// 캐리 리뷰 리스트
	List<CarryReviewDto> selectCarryReviewList(int cridx);
	// 캐리 상세페이지 내  플레이스 정보
	PlaceDto selectCarryPlaceDetail(int cridx);
	// 캐리 리뷰 작성
	int addCarryReview(CarryReviewDto reviewDto);
	
	
}
