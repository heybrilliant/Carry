package com.project.gymcarry.dao;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.board.Pagination;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.util.List;

@Repository
public class BoardDAOImpl implements BoardDao {

    @Inject
    private SqlSession sqlSession;

    // 게시판 전체 리스트
    @Override
    public List<BoardDto> selectBoardList(Pagination pagination) throws Exception {
        return sqlSession.selectList("com.project.gymcarry.dao.BoardDao.selectBoardList",pagination);
    }

    @Override
    public List<BoardDto> getBoardList(Pagination pagination) throws Exception {
        return sqlSession.selectList("com.project.gymcarry.dao.BoardDao.getBoardList", pagination);

    }

    @Override
    public BoardDto getBoardContent(int postidx) throws Exception {
        return sqlSession.selectOne("com.project.gymcarry.dao.BoardDao.getBoardContent",postidx);
    }

    // 조회수
    @Override
    public int updateViewCnt(int postidx) throws Exception {
        return sqlSession.update("com.project.gymcarry.dao.BoardDao.updateViewCnt", postidx);
    }

    // 총 게시글 개수 확인 (페이징)
    @Override
    public int getBoardListCnt() throws Exception {
        return sqlSession.selectOne("com.project.gymcarry.dao.BoardDao.getBoardListCnt");
    }

    @Override
    public List<BoardDto> getCategoryList(String boardcategory) throws Exception {
        return sqlSession.selectList("com.project.gymcarry.dao.BoardDao.getCategoryList",boardcategory);
    }

    // 카테고리 리스트 가져오기



    // 게시글 전체 출력
}
