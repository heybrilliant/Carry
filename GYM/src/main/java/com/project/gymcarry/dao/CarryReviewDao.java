package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.carryreview.CarryReviewDto;

public interface CarryReviewDao {

	// 캐리 리뷰 리스트
	List<CarryReviewDto> selectCarryReview(int crIDX);
	
	
}
