package com.springboot.shoppingMall.common;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Properties;

public class MailSender {

    public static boolean sendMail(HashMap<String, Object> param){

        boolean result = false;

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jongbell4@gmail.com", "wckbhodqkdlganfp");
            }
        });

        //String receiver = "jongbell4@gmail.com"; // 메일 받을 주소
        String receiver = (String) param.get("receiver");
//        String title = "테스트 메일입니다.";
        String title = (String) param.get("title");
//        String content = "<h2 style='color:blue'>안녕하세요</h2>";
        String content = (String) param.get("content");
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("jongbell4@gmail.com", "관리자", "utf-8"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
            message.setSubject(title);
            message.setContent(content, "text/html; charset=utf-8");

            Transport.send(message);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
