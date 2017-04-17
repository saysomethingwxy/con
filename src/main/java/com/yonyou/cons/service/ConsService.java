package com.yonyou.cons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.yonyou.cons.dao.ConDao;
import com.yonyou.cons.entity.Contract;

@Service
public class ConsService {

  @Autowired
  private ConDao conDao;

  /**
   * 
   * @Title:getConsByUserid
   * @Description:TODO 根据用户id获取用户相关合同信息
   * @return
   * @author winxinyuan
   */
  public List<Contract> getConsByUserid(String userid) {
    return conDao.findContracsByUid(userid);
  }
}
