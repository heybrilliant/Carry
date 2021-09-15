package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.carry.CarryListDto;
import com.project.gymcarry.mypage.MypageDto;
import com.project.gymcarry.mypage.MypagepaymentDto;


public interface MypageDao {

	int insertMemo(MypageDto mypDto);

	List<MypageDto> selectMemo(String arg0 ,String arg1, String arg2);

	int updateMemo(MypageDto mypDto);
	
	List<MypagepaymentDto> selectpayment(int i);

	List<CarryListDto> getMyCarryList(int i);

	int getBoardListCnt(int i);

	List<BoardDto> getBoardList(Pagination pagination);
}
