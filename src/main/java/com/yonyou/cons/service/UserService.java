package com.yonyou.cons.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cons.dao.UserDao;
import com.yonyou.cons.entity.User;

/**
 * 用户相关服务逻辑
 * 
 * @author weixy
 *
 */
@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  Logger logger = LoggerFactory.getLogger(UserService.class);

  /**
   * 
   * @Title:addUser
   * @Description:TODO 添加新用户
   * @param user
   * @return
   * @author winxinyuan
   */
  public User addUser(User user) {
    // 补充用户默认信息
    user = creatUser(user);
    try {
      int line = userDao.addUser(user);
      if (line <= 0) {
        logger.error("插入新用户信息失败");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    logger.debug("添加新用户成功");
    return user;
  }

  /**
   * 
   * @Title:creatUser
   * @Description:TODO 补充用户默认相关信息
   * @param user
   * @return
   * @author winxinyuan
   */
  private User creatUser(User user) {
    Date date = new Date();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    user.setPicture("/img/tx2.jpg");
    user.setCompany("用友电子发票事业部");
    user.setDate(format.format(date));
    return user;
  }

  /**
   * 
   * @Title:getUserById
   * @Description:TODO 根据用户id查找用户
   * @param user
   * @return
   * @author winxinyuan
   */
  public User getUserById(User user) {
    return userDao.findUserById(user);
  }

  public boolean checkUserLogin(User user, User loguser) {
    if (user.getPassword().equals(loguser.getPassword())) {
      return true;
    }
    return false;
  }


}
