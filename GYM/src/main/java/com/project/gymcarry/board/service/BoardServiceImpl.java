package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.BoardWriteDto;
import com.project.gymcarry.board.Pagination;
import com.project.gymcarry.dao.BoardDao;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    private BoardDao dao;

    @Autowired
    private SqlSessionTemplate template;


    // 게시판 전체 목록 조회
    @Override
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception {
        dao = template.getMapper(BoardDao.class);
        return dao.getBoardList(pagination);
    }

    // 총 게시글 개수 확인
    @Override
    public int getBoardListCnt() throws Exception {
        dao = template.getMapper(BoardDao.class);
        return dao.getBoardListCnt();
    }

    // 게시판 카테고리 리스트
    @Override
    public List<BoardDto> getListCommuni() {
        dao = template.getMapper(BoardDao.class);
        return dao.getListCommuni();
    }

    // 게시글 입력
    @Override
    public int getBoardWrite(Map<String, String> map) throws Exception{
        dao = template.getMapper(BoardDao.class);
        return dao.insertBoardWrite(map);
    }

    // 게시글 상세 페이지 출력
    @Override
    public BoardDto getBoardDetail(int postidx) {
        dao = template.getMapper(BoardDao.class);
        return dao.selectBoardDetail(postidx);
    }

    // 게시글 수정시 입력된 값 그대로 출력
    @Override
    public BoardWriteDto getBoardUpdate(int postidx) throws Exception{
        dao = template.getMapper(BoardDao.class);
        return dao.selectBoardUpdate(postidx);
    }

    // 게시글 수정
    @Override
    public int getBoardContent(Map<String, Object> map) {
        dao = template.getMapper(BoardDao.class);
        return dao.updateBoardContent(map);
    }


    // 게시글 삭제
    @Override
    public int getDeleteBoard(int postidx) {
        dao = template.getMapper(BoardDao.class);
        return dao.deleteBoard(postidx);
    }


}
