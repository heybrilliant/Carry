package com.project.gymcarry.mypage.service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.dao.CarryMyPageDao;
import com.project.gymcarry.mypage.CarryMyPageDto;
import com.project.gymcarry.mypage.CarryMyPageDto2;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarryMyPageServiceImpl implements CarryMyPageService{

    private CarryMyPageDao dao;

    @Autowired
    private SqlSessionTemplate template;

    @Override
    public int updateCarryModify(CarryMyPageDto2 carryMyPageDto2) throws Exception {
        dao = template.getMapper(CarryMyPageDao.class);
        return dao.updateCarryModify(carryMyPageDto2);
    }

    @Override
    public int updateCarryPrice(int proprice1, int proprice2, int proprice3, int proprice4, int cridx) {
        dao = template.getMapper(CarryMyPageDao.class);
        return dao.updateCarryPrice(proprice1,proprice2,proprice3,proprice4, cridx);
    }

}
