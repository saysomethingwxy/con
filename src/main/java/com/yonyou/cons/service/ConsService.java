package com.yonyou.cons.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yonyou.cons.dao.ConDao;
import com.yonyou.cons.entity.Contract;

@Service
public class ConsService {

  @Autowired
  private ConDao conDao;

  Logger logger = LoggerFactory.getLogger(ConsService.class);

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

  /**
   * 
   * @Title:updateCon
   * @Description:TODO 更新合同状态
   * @param conid
   * @return
   * @author winxinyuan
   */
  public int updateCon(String conid) {
    return conDao.updateCon(conid);
  }
  
  public List<Contract> getConsByWord(String word){
    return conDao.findContractByWord(word);
  }
}
