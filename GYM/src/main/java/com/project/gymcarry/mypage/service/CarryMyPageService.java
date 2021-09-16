package com.project.gymcarry.mypage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.carry.CarryToJoinDto;
import com.project.gymcarry.mypage.CarryMyPageDto;


public interface CarryMyPageService {

    public int updateCarryModify(CarryMyPageDto carryMyPageDto) throws Exception;

    int updateCarryPrice(int proprice1, int proprice2, int proprice3, int proprice4, int cridx);

    // 캐리 기본 정보 수정 출력
    public CarryDto selectCarryBasicInfo(int cridx) throws Exception;
    
    // 캐리 기본 정보 수정 완료
    public int updateCarryBasicInfo(CarryToJoinDto carryToJoinDto, HttpServletResponse response, HttpServletRequest request) throws Exception;

}
