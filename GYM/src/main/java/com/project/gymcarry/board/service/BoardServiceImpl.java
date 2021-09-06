package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper mapper;

    @Override
    public List<BoardDto> listAll() {
        return mapper.listAll();
    }
}
