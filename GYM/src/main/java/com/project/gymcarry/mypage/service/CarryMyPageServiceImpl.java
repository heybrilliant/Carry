package com.project.gymcarry.mypage.service;

import com.project.gymcarry.carry.CarryDto;
import com.project.gymcarry.dao.CarryMyPageDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarryMyPageServiceImpl implements CarryMyPageService{

    private CarryMyPageDao dao;

    @Autowired
    private SqlSessionTemplate template;

    @Override
    public int updateCarryModify(CarryDto carryMyPageDto) throws Exception {
        dao = template.getMapper(CarryMyPageDao.class);
        return dao.updateCarryModify(carryMyPageDto);
    }
}
