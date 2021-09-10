package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.mypage.MypageDto;

public interface MypageDao {

	int insertMemo(MypageDto mypDto);

	List<MypageDto> selectMemo(String arg0 ,String arg1, String arg2);

	int updateMemo(MypageDto mypDto);

}
