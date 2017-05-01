package com.yonyou.cons.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yonyou.cons.entity.Message;


@Repository
public interface MessageDao {

  /**
   * 
   * @Title:addMessage
   * @Description:添加一条新消息
   * @param message 消息信息
   * @return
   * @author winxinyuan
   */
  public int addMessage(Message message);

  /**
   * 
   * @Title:findMessagesByCid
   * @Description:TODO
   * @param Cid
   * @return
   * @author winxinyuan
   */
  public Message findMessagesByCid(String cid);

  /**
   * 
   * @Title:findMessagesByUid
   * @Description:TODO 根据用户信息获取信息
   * @param Uid
   * @return
   * @author winxinyuan
   */
  public List<Message> findMessagesByUid(String userid);

  /**
   * 
   * @Title:updateMessage
   * @Description:TODO 更新新提醒消息
   * @param msg
   * @return
   * @author winxinyuan
   */
  public int updateMessage(Message msg);

}
