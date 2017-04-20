package com.yonyou.cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cons.dao.FriendsDao;
import com.yonyou.cons.dao.MessageDao;
import com.yonyou.cons.entity.Friends;
import com.yonyou.cons.entity.Message;

@Service
public class MessService {

  @Autowired
  private MessageDao messDao;

  /**
   * 
   * @Title:getMessageByCid
   * @Description:TODO 根据合同id查找消息
   * @param conid
   * @return
   * @author winxinyuan
   */
  public Message getMessageByCid(String conid) {
    return messDao.findMessagesByCid(conid);
  }

  /**
   * 
   * @Title:addBaseMess
   * @Description:TODO 添加一条合同基本信息
   * @param msg
   * @return
   * @author winxinyuan
   */
  public int addBaseMess(Message msg) {
    return messDao.addMessage(msg);
  }
}
