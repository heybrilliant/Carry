package com.project.gymcarry.mypage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.gymcarry.carry.CarryJoinDto;
import com.project.gymcarry.carry.CarryToInfoDto;
import com.project.gymcarry.carry.CarryToJoinDto;


public interface CarryMyPageService {

    // 캐리 정보 수정
    public int updateCarryModify(CarryToInfoDto carryToInfoDto, HttpServletResponse response, HttpServletRequest request) throws Exception;

    int updateCarryPrice(int proprice1, int proprice2, int proprice3, int proprice4, int cridx);

    // 캐리 기본 정보 수정 출력
    public CarryJoinDto selectCarryBasicInfo(int cridx) throws Exception;

    // 캐리 기본 정보 수정 완료
    public int updateCarryBasicInfo(CarryToJoinDto carryToJoinDto, HttpServletResponse response, HttpServletRequest request) throws Exception;

}
