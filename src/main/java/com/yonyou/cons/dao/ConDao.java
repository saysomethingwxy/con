package com.yonyou.cons.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.User;

/**
 * 合同数据处理
 * 
 * @author weixy
 *
 */
@Repository
public interface ConDao {

  // @Autowired
  // private Contract contract;
  /**
   * 
   * @Title:addContract
   * @Description:添加新合同
   * @param contract 合同信息
   * @return
   * @author winxinyuan
   */
  public int addContract(Contract contract);


  /**
   * 
   * @Title:findContractById
   * @Description:根据合同号查找合同信息
   * @param id
   * @return
   * @author winxinyuan
   */
  public Contract findContractById(String id);

  /**
   * 
   * @Title:findContractsById
   * @Description:查找所有合同
   * @return
   * @author winxinyuan
   */
  public List<Contract> findContractsById();

  /**
   * 
   * @Title:findContracsByUid
   * @Description:根据用户id查找合同信息
   * @param userid 用户id
   * @return
   * @author winxinyuan
   */
  public List<Contract> findContracsByUid(String userid);

  /**
   * 
   * @Title:findContractByWord
   * @Description:根据合同关键字查询合同
   * @param word 合同关键字
   * @return
   * @author winxinyuan
   */
  public List<Contract> findContractByWord(@Param(value = "part") String part);

  /**
   * 
   * @Title:updateCon
   * @Description:TODO 更新合同信息
   * @param conid
   * @return
   * @author winxinyuan
   */
  public int updateCon(String conid);

}
