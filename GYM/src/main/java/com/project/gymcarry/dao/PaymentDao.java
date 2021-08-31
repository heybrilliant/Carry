package com.project.gymcarry.dao;

import com.project.gymcarry.payment.PaymentDto;

public interface PaymentDao {

	// 결제 정보 출력
	PaymentDto paymentPrice(int cridx, int payprice);
	// 결제 정보 등록
	int savePayment(PaymentDto paymentDto);
}
