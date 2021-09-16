package com.project.gymcarry.dao;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.mypage.CarryMyPageDto;

public interface CarryMyPageDao {

	// 캐리 정보 수정
	int updateCarryModify(CarryMyPageDto carryMyPageDto) throws Exception;

	// 캐리 가격 수정
    int updateCarryPrice(int proprice1,int proprice2,int proprice3,int proprice4,int cridx);
    
    // 캐리 기본 정보 수정에 필요한 값 출력
    CarryDto selectCarryBasicInfo(int cridx) throws Exception;
    
    // 캐리 기본 정보 수정 완료
    Integer updateCarryBasicInfo(CarryJoinDto carryJoinDto) throws Exception;
    
    
}
