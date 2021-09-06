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
	
	// 전체 플레이스 리스트 
	public List<PlaceDto> getAllPlaceList() {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectAllPlaceList();
	}
	
	// 헬스 플레이스 리스트 
	public List<PlaceDto> getHealthPlaceList() {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceList();
	}
	
	// 요가 플레이스 리스트 
	public List<PlaceDto> getYogaPlaceList() {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectYogaPlaceList();
	}
	
	// 헬스 플레이스 상세 정보 
	public PlaceDto getHealthPlaceInfo(int placeidx) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceInfo(placeidx);
	}
	
	// 플레이스 자동 완성 검색 리스트
	public List<PlaceDto> getHealthPlaceSearch(String keyword) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectHealthPlaceSearch(keyword);
	}
	
	// 헬스 플레이스 검색 결과 상세 정보 페이지 이동 
	public PlaceDto getSearchPlaceInfo(String placename) {
		dao = template.getMapper(PlaceDao.class);
		return dao.selectSearchPlaceInfo(placename);
	}
	
	
	// place 검색 자동 완성
//	public List<PlaceSearchDto> getPlaceSearch() {
//		dao = template.getMapper(PlaceDao.class);
//        return dao.selectHealthPlaceSearch();
//    }



	
}