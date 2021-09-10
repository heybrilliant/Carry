package com.project.gymcarry.admin.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.dao.AdminCommunityDao;

@Service
public class AdminCommunityService {
	
	@Autowired
	private SqlSessionTemplate template;
	private AdminCommunityDao dao;

	
	// 전체 관리자 게시판 리스트 출력
	public List<BoardDto> AdminBoardList() {
		dao = template.getMapper(AdminCommunityDao.class);
		return dao.selectCommunityList();
	}
	// 관리자 게시판 게시글 삭제
	public void deleteCommunity(int postidx) {
		dao.deleteCommunity(postidx);
	}
	
	
}
