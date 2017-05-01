package com.yonyou.cons.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yonyou.cons.Enum.CodeEnum;
import com.yonyou.cons.common.CommonResponse;
import com.yonyou.cons.entity.Contract;
import com.yonyou.cons.entity.Message;
import com.yonyou.cons.entity.User;
import com.yonyou.cons.service.ConsService;
import com.yonyou.cons.service.EmailService;
import com.yonyou.cons.service.MessService;
import com.yonyou.cons.service.UserService;

@RestController
@RequestMapping(value = "/mess")
public class MessageController {

  @Autowired
  private EmailService mailServie;

  @Autowired
  private UserService userService;

  @Autowired
  private MessService messService;

  @Autowired
  private ConsService conService;

  /**
   * 
   * @Title:sendMail
   * @Description:TODO 添加一条信息
   * @author winxinyuan
   */
  @RequestMapping(value = "/addmess", method = RequestMethod.POST)
  public CommonResponse addMessage(@RequestBody Message msg) {
    // 非空判断
    if (msg == null) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    User user = new User();
    user.setUserid(msg.getUid());
    user = userService.getUserById(user);
    // 更新新消息
    try {
      msg.setDate(new SimpleDateFormat().format(new Date()));
      int line = messService.updateMessage(msg);
      if (line <= 0) {
        return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作数据库错误");
      }
      // 发送邮件
      mailServie.eamil(user.getEmail(), msg.getType());
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功");
  }

  /**
   * 
   * @Title:getMessage
   * @Description:TODO 获取信息
   * @param userid
   * @return
   * @author winxinyuan
   */
  @RequestMapping(value = "/getmess", method = RequestMethod.GET)
  public CommonResponse getMessage(@RequestParam String userid) {
    List data = new ArrayList();
    List<Contract> cons = null;
    List<Message> messages = null;
    // 非空判断
    if (StringUtils.isEmpty(userid)) {
      return new CommonResponse(CodeEnum.NULL_CODE.getCode(), "参数不能为空");
    }
    try {
      // 获取信息集合
      messages = messService.getMsgByUserid(userid);
      if (messages != null) {
        // 获取合同集合
        cons = conService.getConsByMsg(messages);
        data.add(messages);
        data.add(cons);
      }
    } catch (Exception e) {
      e.printStackTrace();
      return new CommonResponse(CodeEnum.FAIL_CODE.getCode(), "操作失败");
    }
    return new CommonResponse(CodeEnum.SUCCESS_CODE.getCode(), "操作成功",data);
  }
}
