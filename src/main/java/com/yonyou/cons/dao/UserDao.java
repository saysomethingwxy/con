package com.yonyou.cons.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yonyou.cons.entity.User;

/**
 * 用户相关数据操作
 * 
 * @author weixy
 *
 */
@Repository
public interface UserDao {
  // @Autowired
  // private User user;

  /**
   * 
   * @Title:addUser
   * @Description:添加新用户
   * @param user 用户信息
   * @return
   * @author winxinyuan
   */
  public int addUser(User user);

  /**
   * 
   * @Title:deleteUserById
   * @Description:删除用户根据id
   * @param id 员工号
   * @return
   * @author winxinyuan
   */
  // public int deleteUserById(String id);

  /**
   * 
   * @Title:updateUserById
   * @Description:更新用户信息
   * @param user 用户信息
   * @return
   * @author winxinyuan
   */
  public int updateUserById(User user);
  /**
   * 
   * @Title:findUsersById
   * @Description:查找所有用户信息
   * @return
   * @author winxinyuan
   */
  // public List<User> findUsersById();

  /**
   * 
   * @Title:findUserById
   * @Description:根据员工姓名或员工号查找员工
   * @param user
   * @return
   * @author winxinyuan
   */
  public User findUserById(User user);

  /**
   * 
   *@Title:getUserByMail  
   * @Description:TODO 根据邮箱获取用户
   * @param mail
   * @return
   * @author winxinyuan
   */
  public User getUserByMail(String mail);

}
