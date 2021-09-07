package com.project.gymcarry.board.service;

import com.project.gymcarry.board.BoardDto;
import com.project.gymcarry.dao.BoardMapper;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class CommunityService {

    @Inject
    private BoardMapper mapper;

    public List<BoardDto>listAll(PageObject\ ) {
        return mapper.listAll();
    }
}
