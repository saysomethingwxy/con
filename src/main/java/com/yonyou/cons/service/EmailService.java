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

  public void task(String receiver) {
    try {
      this.receiver = receiver;
      logger.info("执行后台报告任务");
      // 2. 构建模板
      String htmlText = "收到合同提醒信息，请查看！";
      // 3. 发送邮件
      logger.debug("收件人:{}", receiver);
      sendEmail(htmlText);
      logger.info("发送邮件完毕");
    } catch (Exception e) {
      logger.error("发送邮件发生错误:" + e.getMessage());
    }



  }

  private void sendEmail(String htmlText)
      throws AddressException, MessagingException, UnsupportedEncodingException {
    MimeMessage mime = mailSender.createMimeMessage();
    MimeMessageHelper mimehelper = new MimeMessageHelper(mime, true);
    mimehelper.setFrom(emailFrom);
    // 设置收件人
    mimehelper.setTo(getReceiverArray());
    // 设置发送日期
    mimehelper.setSentDate(new Date());
    String subject = "用友电子发票平台提醒消息" + getCurDate("yyyy-MM-dd");
    // 设置主题
    mimehelper.setSubject(subject);
    // 设置邮件内容为HTML超文本格式
    mimehelper.setText("附件为提醒消息，请查收", false);

    // 将邮件发送
    mailSender.send(mime);


  }

  private InternetAddress[] getReceiverArray() throws AddressException {
    String[] addrs = receiver.split(",");
    List<InternetAddress> rtnList = new ArrayList<InternetAddress>();
    for (String addr : addrs) {
      InternetAddress ia = new InternetAddress(addr);
      rtnList.add(ia);
    }
    return rtnList.toArray(new InternetAddress[0]);
  }

  private String getCurDate(String pattern) {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    return sdf.format(date);
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getReceiver() {
    return receiver;
  }

  public void eamil(String rev,String type) {
    String text=null;
    if(type.equals("register")){
      int code=(int)((Math.random()*9+1)*100000);
      //缓存处理
     // template.opsForValue().set("ss", code+"");
      text="用友电子合同平台的注册验证码是："+code+"。";
    }else{
      text="您有一条新的合同提醒消息，请及时登录查看！";
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
}

