package com.yonyou.cons.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cons.dao.FriendsDao;

@Service
public class FriendService {

  @Autowired
  private FriendsDao friDao;
  
  
}
