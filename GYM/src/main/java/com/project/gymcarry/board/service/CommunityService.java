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
    

}