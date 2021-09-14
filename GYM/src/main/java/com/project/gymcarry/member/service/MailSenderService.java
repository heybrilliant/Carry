package com.project.gymcarry.member.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;

@Service
public class MailSenderService {

	@Autowired
	private JavaMailSender sender;
	@Autowired
	private SqlSessionTemplate template;
	private MemberDao dao;

	// 인증키 생성
	public String create_joinkey(int size) {
		String joinkey = "";
		Random rd = new Random();

		for (int i = 0; i < 8; i++) {
			joinkey += rd.nextInt(8);
		}
		return joinkey;
	}

	private boolean lowerCheck;
	private int size;

	public String getJoinkey(boolean lowerCheck, int size) {
		this.lowerCheck = lowerCheck;
		this.size = size;
		return create_joinkey(size);
	}

	
	// 회원한테 보내는 가입 인증 메일
	public String send_mail(String mememail, String memname) {

		String joinkey = getJoinkey(false, 8);
		dao = template.getMapper(MemberDao.class);
		dao.GetJoinkey(mememail, joinkey);

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("GymCarry 회원가입 인증 메일입니다.", "UTF-8");

			// 메일 내용 컨텐츠 html
			String html = "<h1>GymCarry 회원가입 인증 이메일입니다.</h1>";
			html += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			html += "<h3 style='color: blue;'>";
			html += "안녕하세요 " + memname + " 회원님 :) ! 짐캐리 회원가입을 환영합니다!</h3>";
			html += "<div style='font-size: 130%'>";
			html += "하단의 인증 버튼 클릭시 정상적으로 회원가입이 완료됩니다.</div><br/>";
			html += "<form method='post' " + "action='http://localhost:8080/gym/member/join/alterjoinkey'>";
			html += "<input type='hidden' name='mememail' value='" + mememail + "'>";
			html += "<input type='hidden' name='joinkey' value='" + joinkey + "'>";
			html += "<input type='submit' value='인증' style= 'width:70px; height:25px; border:0px; background-color: #4380ce; color: #fff; font-weight: bold'></form><br/></div>";

			// message에 내용 적용
			message.setText(html, "utf-8", "html");

			// from 설정
			message.setFrom(new InternetAddress("gymcarryemail@gmail.com"));

			// to 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(mememail));

			// 메일 발송
			sender.send(message);
			System.out.println("메일센더 메일발송 + mememail = " + mememail);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return joinkey;
	}
	
	// 캐리에게 보내는 가입 인증 메일 
	public String crsend_mail(String cremail, String crname) {

		String joinkey = getJoinkey(false, 8);
		dao = template.getMapper(MemberDao.class);
		dao.cr_GetJoinkey(cremail, joinkey);

		MimeMessage message = sender.createMimeMessage();

		try {

			// 메일 제목
			message.setSubject("GymCarry 회원가입 인증 메일입니다.", "UTF-8");

			// 메일 내용 컨텐츠 html
			String html = "<h1>GymCarry 회원가입 인증 이메일입니다.</h1>";
			html += "<div align='center' style='border:1px solid black; font-family:verdana'>";
			html += "<h3 style='color: blue;'>";
			html += "안녕하세요 " + crname + " 캐리님 :) ! 짐캐리 회원가입을 환영합니다!</h3>";
			html += "<div style='font-size: 130%'>";
			html += "하단의 인증 버튼 클릭시 정상적으로 회원가입이 완료됩니다.</div><br/>";
			html += "<form method='post' " + "action='http://localhost:8080/gym/carry/join/cr_alterjoinkey'>";
			html += "<input type='hidden' name='cremail' value='" + cremail + "'>";
			html += "<input type='hidden' name='joinkey' value='" + joinkey + "'>";
			html += "<input type='submit' value='인증' style= 'width:70px; height:25px; border:0px; background-color: #4380ce; color: #fff; font-weight: bold'></form><br/></div>";

			// message에 내용 적용
			message.setText(html, "utf-8", "html");

			// from 설정
			message.setFrom(new InternetAddress("gymcarryemail@gmail.com"));

			// to 설정
			message.addRecipient(RecipientType.TO, new InternetAddress(cremail));

			// 메일 발송
			sender.send(message);
			System.out.println("메일센더 메일발송 + cremail = " + cremail);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return joinkey;
	}
	
	// 멤버 이메일 인증시 인증값 변경 
	public void alterjoinkey(String mememail, String joinkey, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (dao.alterjoinkey(mememail, joinkey) == 0) { // 이메일 인증 실패시
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else { // 이메일 인증 성공시
			out.println("<script>");
			out.println("alert('인증이 완료되었습니다! 로그인 후 이용해주세요.');");
			out.println("location.href='../index.jsp';");
			out.println("</script>");
			out.close();
		}
	}
	
	// 캐리 이메일 인증시 인증값 변경 
	public void cr_alterjoinkey(String cremail, String joinkey, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (dao.cr_alterjoinkey(cremail, joinkey) == 0) { // 이메일 인증 실패시
			out.println("<script>");
			out.println("alert('잘못된 접근입니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
		} else { // 이메일 인증 성공시
			out.println("<script>");
			out.println("alert('인증이 완료되었습니다! 로그인 후 이용해주세요.');");
			out.println("location.href='../index.jsp';");
			out.println("</script>");
			out.close();
		}
	}
	

	public int alterjoinkey_service(String mememail, String joinkey) {
		int resultCnt = 0;

		dao = template.getMapper(MemberDao.class);
		resultCnt = dao.alterjoinkey(mememail, joinkey);

		return resultCnt;
	}
	
	public int cr_alterjoinkey_service(String cremail, String joinkey) {
		int resultCnt = 0;

		dao = template.getMapper(MemberDao.class);
		resultCnt = dao.cr_alterjoinkey(cremail, joinkey);

		return resultCnt;
	}
	
}
