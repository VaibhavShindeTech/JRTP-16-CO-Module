package com.vaibhavshindetech.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	@Autowired
	private JavaMailSender mailSender;

	public EmailUtils(JavaMailSender javaMailSender) {
		// TODO Auto-generated constructor stub
		mailSender=javaMailSender;
	}

	public boolean sendEmail(String to, String subject, String body) throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		boolean isMailSent=false;

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setSubject(subject);
			mimeMessageHelper.setTo(to);
			mimeMessageHelper.setText(body, true);
			mailSender.send(mimeMessageHelper.getMimeMessage());
			isMailSent=true;
		return isMailSent;
	}
}
