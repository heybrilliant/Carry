package com.project.gymcarry.dao;

import java.util.List;
import java.util.Map;

import com.project.gymcarry.carry.CarryCertiDto;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.carry.CarryPriceDto;
import com.project.gymcarry.carry.CarryReviewDto;
import com.project.gymcarry.carry.Criteria;
import com.project.gymcarry.place.PlaceDto;

public interface CarryDao {
	
	// 캐리 전체 정보
	CarryDto selectCarryDetail(int cridx);
	// 캐리 프로그램별 가격 정보 (전체)
	CarryPriceDto selectCarryPrice(int cridx);
	// 캐리 자격 및 경력 정보
	CarryCertiDto selectCarryCerti(int cridx);
	// 캐리 상세페이지 내  플레이스 정보
	PlaceDto selectCarryPlaceDetail(int cridx);
	// 캐리 리뷰 리스트
	List<CarryReviewDto> selectCarryReviewList(int cridx);
	// 캐리 리뷰 작성
	int addCarryReview(CarryReviewDto reviewDto);
	// 캐리 리뷰 카운트
	int carryReviewCnt();
	// 캐리 리뷰 리스트 (페이징 처리)
	List<Map<String, Object>> pagingReviewList(Criteria cri);
	
	
	// 전체 캐리 리스트
	List<CarryListDto> selectAllCarryList();
	// 전체 캐리 리스트 - 가격순
	List<CarryListDto> selectAllCarryListP();
	
	// 매칭 캐리 리스트 - [여자/헬스]
	List<CarryListDto> selectCarryListFH();
	// 매칭 캐리 리스트 - [여자/필라테스]
	List<CarryListDto> selectCarryListFF();
	// 매칭 캐리 리스트 - [여자/요가]
	List<CarryListDto> selectCarryListFY();
	
	// 매칭 캐리 리스트 - [남자/헬스]
	List<CarryListDto> selectCarryListMH();
	// 매칭 캐리 리스트 - [남자/필라테스]
	List<CarryListDto> selectCarryListMF();
	// 매칭 캐리 리스트 - [남자/요가]
	List<CarryListDto> selectCarryListMY();

	
	
}
