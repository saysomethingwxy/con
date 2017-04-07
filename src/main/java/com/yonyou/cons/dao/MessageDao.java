package com.yonyou.cons.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yonyou.cons.entity.Message;


@Repository
public interface MessageDao {
  // @Autowired
  // private Message message;
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
  public List<Message> findMessagesByCid(String Cid);

  /**
   * 
   * @Title:findMessagesByUid
   * @Description:TODO
   * @param Uid
   * @return
   * @author winxinyuan
   */
  public List<Message> findMessagesByUid(String Uid);

}
