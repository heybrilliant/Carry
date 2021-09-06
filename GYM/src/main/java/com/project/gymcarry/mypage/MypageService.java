package com.project.gymcarry.mypage;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.dao.MypageDao;

@Service
public class MypageService {

	@Autowired
	private SqlSessionTemplate template;
	
	private MypageDao dao;

	public int memberMemo(MypageDto mypDto) {
		dao = template.getMapper(MypageDao.class);
		return dao.insertMemo(mypDto);

	}
}
