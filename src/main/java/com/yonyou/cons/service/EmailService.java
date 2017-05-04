package com.yonyou.cons.service;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 邮件提醒消息
 * 
 * @author weixy
 *
 */
@Component
public class EmailService {

  private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

  @Autowired
  private JavaMailSender mailSender;

  private String receiver;

  @Autowired
  @Value("${mail.smtp.username}")
  private String emailFrom;
  
  @Autowired
  private StringRedisTemplate template;
  
  private int code=0;

  public void eamil(String rev,String type) {
    String text=null;
    if(type.equals("register")){
      code=(int)((Math.random()*9+1)*100000);
      //缓存处理
     // template.opsForValue().set("ss", code+"");
      text="用友电子合同平台的注册验证码是："+code+"。";
    }
    if(type.equals("mess")){
      text="您有一条新的合同提醒消息，请及时登录查看！";
    }
    if(type.equals("forget")){
      text="用友电子合同平台的找回密码验证码是："+code+"。";  
    }
    JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
    // 设定mail server
    senderImpl.setHost("smtp.163.com");

    // 建立邮件消息
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    // 设置收件人，寄件人 用数组发送多个邮件
    // String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
    // mailMessage.setTo(array);
    mailMessage.setTo(rev);
    mailMessage.setFrom("aiweix@163.com ");
    mailMessage.setSubject("用友电子合同平台消息提醒 ");
    mailMessage.setText(text);

    senderImpl.setUsername("aiweix@163.com"); // 根据自己的情况,设置username
    senderImpl.setPassword("a1981327"); // 根据自己的情况, 设置password

    Properties prop = new Properties();
    prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
    prop.put("mail.smtp.timeout", "25000");
    senderImpl.setJavaMailProperties(prop);
    // 发送邮件
    senderImpl.send(mailMessage);
    logger.debug("发送邮件成功！");
  }
  
  public int getCode(){
    return code;
  }
}

