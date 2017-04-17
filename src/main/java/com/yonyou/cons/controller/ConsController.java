package com.yonyou.cons.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cons.Enum.CodeEnum;
import com.yonyou.cons.common.CommonResponse;
import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.Message;
import com.yonyou.cons.service.ConsService;
import com.yonyou.cons.service.MessService;
import com.yonyou.cons.service.UserService;

@RestController
@RequestMapping(value = "/cons")
public class ConsController {

  @Autowired
  private ConsService consService;

  @Autowired
  private UserService userService;

  @Autowired
  private MessService messSevice;

  @RequestMapping(value = "/consinfo", method = RequestMethod.GET)
  public CommonResponse getCons(@RequestParam String userid) {
    List<Contract> cons = new ArrayList<Contract>();
    List<Message> messages = null;
    List datas = new ArrayList();
    // 非空判断
    if (StringUtils.isEmpty(userid)) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    try {
      cons = consService.getConsByUserid(userid);
      if (cons != null) {
        messages = getMess(cons);
      }
      // 封装合同信息和提醒消息
      datas.add(cons);
      datas.add(messages);
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功", datas);
  }

  /**
   * 
   * @Title:getMess
   * @Description:TODO 根据获取的合同顺序依次获取提醒信息
   * @param cons
   * @return
   * @author winxinyuan
   */
  private List<Message> getMess(List<Contract> cons) {
    List<Message> mess = new ArrayList<Message>();
    for (Contract con : cons) {
      Message message = messSevice.getMessageByCid(con.getConid());
      mess.add(message);
    }
    return mess;
  }
  
  @RequestMapping(value="/endcon", method = RequestMethod.GET)
  public CommonResponse endCon(@RequestParam String conid){
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
  }
}
