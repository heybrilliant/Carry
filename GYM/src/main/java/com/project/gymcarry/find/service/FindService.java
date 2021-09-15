package com.project.gymcarry.find.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.gymcarry.dao.MemberDao;
import com.project.gymcarry.find.TempPWD;
import com.project.gymcarry.member.MemberDto;
import com.project.gymcarry.member.service.MailSenderService;
import com.project.gymcarry.member.service.memSha256;

@Service
public class FindService {

	@Autowired
	private SqlSessionTemplate template;
	@Autowired
	private MailSenderService mailsender;
	private MemberDao dao;


	// 캐리 아이디 찾기
	public String findcarryid(HttpServletResponse response, String crname, String crphone) throws IOException {
		dao = template.getMapper(MemberDao.class);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String cremail = dao.findcarryid(crname, crphone);
		System.out.println(" cremail : " + cremail);
		System.out.println(" crname : " + crname);
		System.out.println(" crphone : " + crphone);
		
		if (cremail == null) {
			out.println("<script>");
			out.println("alert('가입된 이메일이 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return cremail;
		}
	}
	
	// 회원 아이디 찾기
	public String findid(HttpServletResponse response, String memname, String memphone) throws IOException {
		dao = template.getMapper(MemberDao.class);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String mememail = dao.findmemberid(memname, memphone);
		System.out.println(" mememail : " + mememail);
		System.out.println(" memname : " + memname);
		System.out.println(" memphone : " + memphone);
		
		if (mememail == null) {
			out.println("<script>");
			out.println("alert('가입된 이메일이 없습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			out.close();
			return null;
		} else {
			return mememail;
		}
	}
	
	// 패스워드 찾기 이메일 발송
//		public void mailSendWithPassword(String memname, String mememail, HttpServletRequest request) {
//			//이메일로 임시 비밀번호 보내주기
//			String tempPWD = TempPWD.randomPw();
//			System.out.println("생성된 임시 비밀번호 : "+tempPWD);
//			
//			dao = template.getMapper(MemberDao.class);
//	
//			// 회원 이름 꺼내는 코드
//			MemberDto memberDto= dao.member(memname);
//			String memname2 = memberDto.getMemname();
//	
//			MimeMessage mail = mailsender.createMimeMessage();
//			String htmlStr = "<h2>안녕하세요 '"+ memname +"' 님</h2><br><br>" 
//					+ "<p>비밀번호 찾기를 신청해주셔서 임시 비밀번호를 발급해드렸습니다.</p>"
//					+ "<p>임시로 발급 드린 비밀번호는 <h2 style='color : blue'>'" + tempPWD +"'</h2>이며 로그인 후 마이페이지에서 비밀번호를 변경해주시면 됩니다.</p><br>"
//					+ "<h3><a href='http://54.180.123.73/MS/'>로그인 바로가기</a></h3><br><br>"
//					+ "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
//			try {
//				mail.setSubject("[MS :p] 임시 비밀번호가 발급되었습니다", "utf-8");
//				mail.setText(htmlStr, "utf-8", "html");
//				mail.addRecipient(RecipientType.TO, new InternetAddress(mememail));
//				mailsender.send(mail);
//			} catch (MessagingException e) { 
//				e.printStackTrace();
//			}
//			// 비밀번호 암호화해주는 메서드
//			tempPWD = memSha256.encrypt(tempPWD);
//			// 데이터 베이스 값은 암호한 값으로 저장시킨다.
//			dao.searchPassword(memname, mememail);
//			
//		}

}
