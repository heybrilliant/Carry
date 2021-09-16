package com.project.gymcarry.mypage.service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.mypage.CarryMyPageDto;
import com.project.gymcarry.mypage.CarryMyPageDto2;

public interface CarryMyPageService {

    public int updateCarryModify(CarryMyPageDto2 carryMyPageDto2) throws Exception;

    int updateCarryPrice(int proprice1, int proprice2, int proprice3, int proprice4);
}
