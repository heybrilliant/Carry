package com.project.gymcarry.mypage.service;

import com.project.gymcarry.carry.CarryDto;

public interface CarryMyPageService {

    public int updateCarryModify(CarryDto carryMyPageDto) throws Exception;

    int updateCarryMoney(int proprice1, int proprice2, int proprice3, int proprice4);
}
