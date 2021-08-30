package com.project.gymcarry.payment.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.PaymentDao;
import com.project.gymcarry.payment.PaymentDto;

@Service
public class PaymentService {

	@Autowired
	private SqlSessionTemplate template;
	private PaymentDao dao;
	
	// 결제 정보 출력
	public PaymentDto paymentPrice(int cridx) {
		dao = template.getMapper(PaymentDao.class);
		return dao.paymentPrice(cridx);
	}
	
	// 결제 정보 저장
	public int SavePayment(PaymentDto paymentDto) {
		dao = template.getMapper(PaymentDao.class);
		return dao.savePayment(paymentDto);
	}
	
	
}
