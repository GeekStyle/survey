package com.geekstyle.survey.util;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil{

    private static String SENDER = "postmaster@yxjilu.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "yang0511WEI88"; // GMail password
    
    public static void sendRestPasswordEmail(String verifyCode,String recipient) {
    	String body = "<div style='width: 500px;height: 250px;background: gainsboro;text-align: center;margin: 0 auto;font-family: 微软雅黑;'><table style='border: 0'><tr style='background: #3D5E86;-webkit-border-radius: 10px;border-radius: 10px;'><td style='color: white;font-size: 20px;'><b>游戏纪录网-重置密码</b></td></tr><tr><td>&nbsp;</td></tr><tr><td align='left' style='padding-left: 15px;'>你此次重置密码的验证码为:<span style='color: red;font-size: 20px;'><b>" + verifyCode + "</b></span>，请在10分钟内输入验证码进行下一步操作。 如非你本人操作，请忽略此邮件。</td></tr></table></div>";
    	String from = SENDER;
        String pass = PASSWORD;
        String[] to = { recipient }; // list of recipient email addresses
        String subject = "重置密码";
        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.mxhichina.com";
        props.put("mail.smtp.starttls.enable", "false");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "false");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for( int i = 0; i < to.length; i++ ) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for( int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setContent(body,"text/html;charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }
}