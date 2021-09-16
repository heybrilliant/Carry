package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.mypage.*;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CarryMyPageDao {

	// 캐리 정보 수정
	int updateCarryModify(CarryMyPageDto2 carryMyPageDto2) throws Exception;

	// 캐리 가격 수정
    int updateCarryPrice(int proprice1,int proprice2,int proprice3,int proprice4,int cridx);
}
