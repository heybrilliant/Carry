package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.dao.BoardDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Inject
    private BoardDao dao;


    // 게시판 전체 목록 조회
    @Override
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception {
        return dao.getBoardList(pagination);

    }

    // 총 게시글 개수 확인
    @Override
    public int getBoardListCnt() throws Exception {
        return dao.getBoardListCnt();
    }

    // 카테고리 리스트
    @Override
    public List<BoardDto> getCategoryList(String boardcategory) throws Exception {
        return dao.getCategoryList(boardcategory);
    }



}
