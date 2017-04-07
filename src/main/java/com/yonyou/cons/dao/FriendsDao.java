package com.yonyou.cons.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yonyou.cons.entity.Friends;
import com.yonyou.cons.entity.User;

/**
 * 好友关系数据处理
 * 
 * @author weixy
 *
 */
@Repository
public interface FriendsDao {
  /**
   * 
   * @Title:addFriend
   * @Description:
   * @param friends 好友关系信息
   * @return
   * @author winxinyuan
   */
  public int addFriend(Friends friends);

  /**
   * 
   * @Title:findFriendsById
   * @Description:根据当前登录员工号获取好友user
   * @param uId 当前登录员工号
   * @return
   * @author winxinyuan
   */
  public List<User> findFriendsById(String uId);

  /**
   * 
   * @Title:findRequest
   * @Description:根据关系状态和当前登录员工号查找好友请求
   * @param friends
   * @return
   * @author winxinyuan
   */
  public List<User> findRequest(Friends friends);
}
