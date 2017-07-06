package com.yonyou.cons.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.yonyou.cons.dao.ConDao;
import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.User;
/**
 * 系统检测提示邮件
 * @author weixy
 *
 */
@Component("mailtask")
public class SysEmailService {

  private static final Logger logger = LoggerFactory.getLogger(SysEmailService.class);

  @Autowired
  private JavaMailSender mailSender;

  private String receiver;
  
  @Autowired
  private UserService userService;
  
  @Autowired
  private ConDao condao;

  @Autowired
  @Value("${mail.smtp.username}")
  private String emailFrom;
  
  public void task(){
    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM");
    String date=format.format(new Date());
    List<User> user=condao.getEmailForCon(date);
    if(user.size()<1){
      return;
    }
    for(User u:user){
      eamil(u.getEmail());
    }
  }
  public void eamil(String rev) {
    String text="用友电子合同平台提醒您：本月有需要完成的临期的合同请登录查看！";
   
    JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
    // 设定mail server
    senderImpl.setHost("smtp.163.com");

    // 建立邮件消息
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    // 设置收件人，寄件人 用数组发送多个邮件
    //mailMessage.setTo(array);
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

