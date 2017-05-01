package com.yonyou.cons.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yonyou.cons.dao.ConDao;
import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.Message;

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

  /**
   * 
   * @Title:getConsByWord
   * @Description:TODO 根据合同姓名关键字查询合同信息
   * @param word
   * @return
   * @author winxinyuan
   */
  public List<Contract> getConsByWord(String word, String userid) {
    return conDao.findContractByWord(word, userid);
  }

  /**
   * 
   * @Title:addCon
   * @Description:TODO 添加新合同
   * @param con
   * @return
   * @author winxinyuan
   */
  public int addCon(Contract con) {
    return conDao.addContract(con);
  }

  /**
   * 
   * @Title:getConByCid
   * @Description:TODO 根据合同id查找合同
   * @param conid
   * @return
   * @author winxinyuan
   */
  public Contract getConByCid(String conid) {
    return conDao.findContractByCid(conid);
  }

  /**
   * 
   * @Title:getImgs
   * @Description:TODO 根据img分割出图片信息
   * @param img
   * @return
   * @author winxinyuan
   */
  public List<String> getImgs(String img) {
    String[] image = null;
    if (!StringUtils.isEmpty(img)) {
      image = img.split("#");
    }
    return Arrays.asList(image);
  }

  /**
   * 
   *@Title:getConsByMsg  
   * @Description:TODO 根据提醒信息获取合同
   * @param messages
   * @return
   * @author winxinyuan
   */
  public List<Contract> getConsByMsg(List<Message> messages) {
    List<Contract> con= new ArrayList<Contract>();
    for(Message m:messages){
      Contract c=conDao.findContractByCid(m.getCid());
      con.add(c);
    }
    return con;
  }
}
