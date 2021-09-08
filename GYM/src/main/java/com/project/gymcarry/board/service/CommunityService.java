package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardWriteDto;
import com.project.gymcarry.dao.BoardDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommunityService {

    @Autowired
    private SqlSessionTemplate template;
    private BoardDao dao;

    // 게시글 전체 출력
    public List<BoardDto> getBoardList() {
        dao = template.getMapper(BoardDao.class);
        return dao.selectBoardList();
    }
    
    // 게시글 입력
    public int getBoardWrite(Map<String, String> map) throws Exception{
    	dao = template.getMapper(BoardDao.class);
    	return dao.insertBoardWrite(map);
    }
    
    // 게시글 상세 페이지 출력
	public BoardDto getBoardDetail(int postidx) {
		dao = template.getMapper(BoardDao.class);
    	return dao.selectBoardDetail(postidx);
	}
	
	// 게시글 수정시 입력된 값 그대로 출력
	public BoardWriteDto getBoardUpdate(int postidx) throws Exception{
		dao = template.getMapper(BoardDao.class);
    	return dao.selectBoardUpdate(postidx);
	}
	
	// 게시글 수정
	public int getBoardContent(Map<String, Object> map) {
		dao = template.getMapper(BoardDao.class);
    	return dao.updateBoardContent(map);
	}
	
	
	// 게시글 삭제
	public int getDeleteBoard(int postidx) {
		dao = template.getMapper(BoardDao.class);
    	return dao.deleteBoard(postidx);
	}
    

}