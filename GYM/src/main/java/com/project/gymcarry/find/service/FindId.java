package com.project.gymcarry.find.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindId {

	@Autowired
	private SqlSessionTemplate template;
}
