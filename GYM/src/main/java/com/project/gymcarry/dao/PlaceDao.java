package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.place.PlaceDto;
import com.project.gymcarry.place.PlaceSearchDto;

public interface PlaceDao {
	
	// 플레이스 전체 보기
    List<PlaceDto> selectAllPlaceList();
	
	// 헬스 플레이스 전체 정보
    List<PlaceDto> selectHealthPlaceList();

    // 플레이스 상세 페이지 정보
    PlaceDto selectHealthPlaceInfo(int placeidx);

    // 플레이스 검색 자동 완성
    List<PlaceDto> selectHealthPlaceSearch(String keyword);
    
    // 플레이스 검색 후 상세페이지 이동
    PlaceDto selectSearchPlaceInfo(String placename);

    // 필라테스 플레이스 전체 정보
    List<PlaceDto> selectPilatesPlaceList() ;
    
    // 요가 플레이스 전체 정보
    List<PlaceDto> selectYogaPlaceList() ;
	
}
