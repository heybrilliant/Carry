package com.project.gymcarry.place.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.PlaceDao;
import com.project.gymcarry.place.PlaceDto;


@Service
public class PlaceHealthListService {
	
	@Autowired
	private SqlSessionTemplate template;
	private PlaceDao dao;
	
	// 헬스 플레이스 리스트 
	public List<PlaceDto> getHealthPlaceList(int placenum) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceList(placenum);
	}
	
}
