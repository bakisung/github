package kr.or.dw.util;
 
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendEmail {
	
	public String pwdEmail(String stu_email) {
		int result = 0;
		
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break;
			case 1:
				// A-Z
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break;
			case 2:
				// 0-9
				temp.append((rnd.nextInt(10)));
				break;
			}
		}
		String AuthenticationKey = temp.toString();
		System.out.println(AuthenticationKey);
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");		
		
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dwuniversity4@gmail.com", "cqwphvdwoebqhmdk");
			}
		});
		
		String receiver = stu_email; // 메일 받을 주소
		String title = "비밀번호 인증 코드입니다.";
		String content = "인증번호는 " + AuthenticationKey + "입니다.";
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("dwuniversity4@gmail.com", "DW대학교", "utf-8"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
			message.setSubject(title);
			message.setContent(content, "text/html; charset=utf-8");
 
			Transport.send(message);
			System.out.println("메일전송 성공");
			result = 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return AuthenticationKey;
	}
}