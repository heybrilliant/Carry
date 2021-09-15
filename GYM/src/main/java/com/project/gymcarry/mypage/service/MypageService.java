package com.project.gymcarry.mypage.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MypageDao;
import com.project.gymcarry.mypage.MypageDto;
import com.project.gymcarry.mypage.MypagepaymentDto;

@Service
public class MypageService {

	@Autowired
	private SqlSessionTemplate template;

	private MypageDao dao;

	public int memberMemo(MypageDto mypDto) {
		dao = template.getMapper(MypageDao.class);
		return dao.insertMemo(mypDto);

	}

	public int updateMemo(MypageDto mypDto) {
		dao = template.getMapper(MypageDao.class);
		return dao.updateMemo(mypDto);

	}

	public List<MypageDto> selectMemo(String memidx, String infodate, String infotype) {
		dao = template.getMapper(MypageDao.class);
		return dao.selectMemo(memidx, infodate, infotype);
	}

}
