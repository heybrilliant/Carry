package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.mypage.*;

import java.util.List;

public interface CarryMyPageDao {

	// 캐리 정보 수정
	int updateCarryModify(CarryDto carryMyPageDto) throws Exception;

}
