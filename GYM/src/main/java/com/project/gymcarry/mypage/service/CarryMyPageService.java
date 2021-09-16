package com.project.gymcarry.mypage.service;

import com.project.gymcarry.mypage.CarryMyPageDto;


public interface CarryMyPageService {

    public int updateCarryModify(CarryMyPageDto carryMyPageDto) throws Exception;

    int updateCarryPrice(int proprice1, int proprice2, int proprice3, int proprice4, int cridx);
}
