package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryDto;

// matching DAO
public interface CarryDao {
	
	// 캐리 정보
	CarryDto selectCarryDetail(int crIDX);
	
}
