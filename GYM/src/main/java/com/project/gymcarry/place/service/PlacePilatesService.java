package com.project.gymcarry.place.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.PlaceDao;
import com.project.gymcarry.place.PlaceDto;

@Service
public class PlacePilatesService {

    @Autowired
    private SqlSessionTemplate template;
    private PlaceDao dao;

    // 필라테스 플레이스 리스트
    public List<PlaceDto> getPilatesPlaceList() {
        dao = template.getMapper(PlaceDao.class);
        return dao.selectPilatesPlaceList();
    }
    
    
	// 필라테스 플레이스 상세 정보 
	public PlaceDto getHealthPlaceInfo(int placeidx) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceInfo(placeidx);
	}
	

}