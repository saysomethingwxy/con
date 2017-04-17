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
  
  public Message getMessageByCid(String conid){
    return messDao.findMessagesByCid(conid);
  }
}
