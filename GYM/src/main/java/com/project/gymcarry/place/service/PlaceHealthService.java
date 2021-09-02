package com.project.gymcarry.place.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.PlaceDao;
import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.PlaceSearchDto;


@Service
public class PlaceHealthService {
	
	@Autowired
	private SqlSessionTemplate template;
	private PlaceDao dao;
	
	// 헬스 플레이스 리스트 
	public List<PlaceDto> getHealthPlaceList(int placenum) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceList(placenum);
	}
	
	// 헬스 플레이스 상세 정보 
	public PlaceDto getHealthPlaceInfo(int placeidx) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceInfo(placeidx);
	}
	
	// place 검색 자동 완성
	public List<PlaceSearchDto> getPlaceSearch() {
		dao = template.getMapper(PlaceDao.class);
        return dao.selectHealthPlaceSearch();
    }



	
}
