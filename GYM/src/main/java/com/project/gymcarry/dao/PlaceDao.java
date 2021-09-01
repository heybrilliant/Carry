package com.project.gymcarry.dao;

import java.util.List;

import com.project.gymcarry.place.PlaceDto;

public interface PlaceDao {
	
	// 헬스 플레이스 전체 정보
	List<PlaceDto> selectHealthPlaceList(int placenum);
	
	// 플레이스 상세 페이지 정보
	PlaceDto selectHealthPlaceInfo(int placeidx);
	
	
}
