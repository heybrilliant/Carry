package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.carry.CarryAllDto;
import com.project.gymcarry.carry.CarryReviewDto;

public interface CarryDao {
	
	// 캐리 전체 정보
	CarryAllDto selectCarryDetail(int cridx);
	// 캐리 리뷰 리스트
	List<CarryReviewDto> selectCarryReviewList(int cridx);
}
